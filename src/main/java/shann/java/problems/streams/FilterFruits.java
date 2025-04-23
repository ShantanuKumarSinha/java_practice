package shann.java.problems.streams;

import java.util.Arrays;

// You are given a list of strings having different fruit names. You need to filter out the names of
// the fruits whose name starts from the character A.
public class FilterFruits {
  public static void main(String[] args) {
    var list = Arrays.asList("Apple", "Banana", "Apricot", "Avocado", "Orange");
    var fruitsNameWithA = list.stream().filter(fruit -> fruit.charAt(0) == 'A').toList();
    System.out.println(fruitsNameWithA);
  }
}
