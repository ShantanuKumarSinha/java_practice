package shann.java.problems.streams;

import java.util.List;

public class DistinctNumberInTheList {
  public static void main(String[] args) {
    var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 6, 7, 4);
    var distinctNumbers = numbers.stream().distinct().toList();
    System.out.println(distinctNumbers);
  }
}
