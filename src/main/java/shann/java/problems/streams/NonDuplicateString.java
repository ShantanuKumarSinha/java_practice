package shann.java.problems.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonDuplicateString {
  public static void main(String[] args) {
    var input = "programming";
    var result = Stream.of(input.split("")).distinct().collect(Collectors.joining());
    input.chars().mapToObj(c -> (char) c).forEach(System.out::print);
    System.out.println();

    String s = "collector joining sorted array";
    var string = Arrays.stream(s.split(" ")).sorted().collect(Collectors.joining(" "));
    System.out.println(string);
  }
}
