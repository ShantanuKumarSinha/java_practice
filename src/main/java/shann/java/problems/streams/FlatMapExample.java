package shann.java.problems.streams;

import java.util.Collection;
import java.util.List;

public class FlatMapExample {
  public static void main(String[] args) {
    List<List<Integer>> listOfList =
        List.of(
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            List.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
            List.of(21, 22, 23, 24, 25, 26, 27, 28, 29, 30));
    var finalList =
        listOfList.stream()
            .flatMap(
                list -> {
                  return list.stream().map(e -> e * e);
                })
            .toList();
    System.out.println(finalList);

    var flatList = listOfList.stream().flatMap(Collection::stream).toList();
    System.out.println(flatList);
    var flatList2 = listOfList.stream().flatMap(list -> list.stream()).toList();
    System.out.println(flatList2);
  }
}
