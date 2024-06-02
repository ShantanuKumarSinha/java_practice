package shann.java.problems.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GroupByAndSubGroupByUsingStreams {
    //employeeList employee id, name, dept and salary
 static class Employee{
    Long empId;
    String empName;
    String department;
    String countryName;

    String getCountry(){
        return this.countryName;
    }
    String getDepartment(){
        return this.department;
    }

    Employee(Long empId, String empName, String department, String countryName){
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.countryName = countryName;
    }

        @Override
        public String toString() {
            return "Employee{" +
                    "countryName='" + countryName + '\'' +
                    ", empId=" + empId +
                    ", empName='" + empName + '\'' +
                    ", department='" + department + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
    var list = new ArrayList<Employee>();
        list.add(new Employee(1L, "Test1", "HR", "India"));
        list.add( new Employee(2L, "Test2", "IT", "India"));
        list.add( new Employee(3L, "Test3", "HR", "SouthAfrica"));
        list.add( new Employee(4L, "Test4", "Sales", "USA"));
        list.add( new Employee(5L, "Test5", "IT", "India"));
        //System.out.println(list.get(0).getCountry()+" "+list.get(1).getCountry());
        // give country wise count
//        Comparator<Employee> employeeComparator = Comparator.comparing(Employee::getCountry).thenComparing(Employee::getDepartment);
//        var result = list.stream().min(employeeComparator).get();
        //System.out.println(result);

       var map =list.stream().collect(Collectors.groupingBy(Employee::getCountry,Collectors.groupingBy(Employee::getDepartment,Collectors.counting())));
        System.out.println(map);

    }
}
