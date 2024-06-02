package shann.java.problems.streams;

import java.util.*;
import java.util.stream.Collectors;

public class FindTheCharactersHavingCountThreeUsingStreams {
    public static void main(String[] args) {
        var test = "Testablees";

          var list  =test.chars().mapToObj(c -> (char) c).toList();

        var set = list.stream().filter(c ->
                Collections.frequency(list, c) == 3).collect(Collectors.toSet());
        for (Character c : set)
            System.out.println(c);
    }
}
