package shann.java.problems.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupBy {

  public static void main(String[] args) {

    List<Student> list = new ArrayList<>();

    list.add(new Student(1, "A", "CSE"));

    list.add(new Student(3, "B", "MECH"));

    list.add(new Student(4, "C", "CSE"));

    list.add(new Student(5, "Y", "CSE"));

    list.add(new Student(6, "Z", "MECH"));

    list.add(new Student(7, "U", "CSE"));

    list.add(new Student(8, "T", "MECH"));

    list.add(new Student(9, "I", "MECH"));

    list.add(new Student(10, "P", "MECH"));

    var s11 = new Student(10, "P", "MECH");

    var s12 = new Student(10, "P", "MECH");

    // get a list of student group by id in reverse order
    Collections.sort(list, Collections.reverseOrder(Comparator.comparing(Student::getID)));
    System.out.println("Student List sorted by Id in reverse order : " + list);
    System.out.println("Find Student with maximum Id");
    // Find Student with maximum Id
    // max method
    var student1 = list.stream().max((s1, s2) -> s1.getID() - s2.getID()).orElseThrow();
    // maxBy Method
    var student2 =
        list.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getID))).orElseThrow();
    System.out.println("student1 " + student1 + " " + "student2 " + student2);
    var listSortedByDepartmentInReverseOrder =
        list.stream()
            .filter(student -> student.getID() >= 1)
            .sorted((s1, s2) -> s2.getDepartment().compareTo(s1.getDepartment()))
            .toList();

    System.out.println(
        "List Sorted By Department In Reverse Order \n" + listSortedByDepartmentInReverseOrder);

    // 2nd way
    var listSortedByDepartmentInReverseOrder2 =
        list.stream()
            .filter(student -> student.getID() >= 1)
            .sorted(Collections.reverseOrder(Comparator.comparing(Student::getDepartment)))
            .toList();

    System.out.println(
        "List Sorted By Department In Reverse Order 2nd Method \n"
            + listSortedByDepartmentInReverseOrder2);

    // check if two Students are equal
    System.out.println("Check if Two Strings are equal");
    System.out.println(s11 == s12);
    System.out.println(s11.equals(s12));
  }
}

class Student {

  int id;

  String name;

  String department;

  Student(int id, String name, String department) {

    this.id = id;

    this.name = name;

    this.department = department;
  }

  public Integer getID() {
    return id;
  }

  public String getDepartment() {
    return department;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return id == student.id
        && Objects.equals(name, student.name)
        && Objects.equals(department, student.department);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, department);
  }

  @Override
  public String toString() {

    return "Student [id=" + id + ", name=" + name + ", department=" + department + "]";
  }
}
