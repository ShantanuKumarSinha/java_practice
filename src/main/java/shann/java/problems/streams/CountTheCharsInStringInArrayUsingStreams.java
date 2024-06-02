package shann.java.problems.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTheCharsInStringInArrayUsingStreams {

  // Java Program to count occurrences of each character of a String in a List :-
  // {"Apple","Mango","Papaya","Melon","Orange"}

  public static void main(String[] args) {
    String[] arr = {"Apple", "Mango", "Papaya", "Melon", "Orange"};
    var list = Arrays.asList(arr);
    var map =
        list.stream()
            .map(s -> s.toLowerCase())
            .collect(
                Collectors.toMap(
                    Function.identity(),
                    s ->
                        s.chars()
                            .mapToObj(c -> (char) c)
                            .collect(
                                Collectors.groupingBy(
                                    Function.identity(), Collectors.counting()))));

    System.out.println(map);
    for (Map<Character, Long> m : map.values().stream().collect(Collectors.toList()))
          System.out.println(m);
    for(Map.Entry mE: map.entrySet()){
      System.out.println(mE.getKey() + " " + mE.getValue());
    }
  }
}
