package shann.java.problems.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonDuplicateString {
  public static void main(String[] args) {
    var input = "programming";
    var result = Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
    var set = input.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    System.out.println(set);
    System.out.println(result);

    String s = "collector joining sorted array";
    var string = Arrays.stream(s.split(" ")).sorted().collect(Collectors.joining(" "));
    System.out.println(string);
  }
}
