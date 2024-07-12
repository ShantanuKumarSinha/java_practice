package shann.java.problems.streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectCommonIntegersFromTwoListsToArray {
  public static void main(String[] args) {
    // two array of type integer which contains common integer and collect it to array
    List<Integer> firstNumbers = List.of(1, 2, 3, 4, 5, 6);

    List<Integer> secondNumbers = List.of(4, 5, 6, 7, 8, 9);

    var filteredList = firstNumbers.stream().filter(secondNumbers::contains).toList();
    System.out.println(filteredList);

    List<Integer> thirdNumbers = List.of(1, 2, 3, 4, 5, 3);
    var result = thirdNumbers.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println("result: " + result);
  }
}
