package shann.java.problems.streams;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MaxOccurenceofCharUsingStreams {

    // max occurence of char

    public static void main(String[] args){
        String[] stringArray =  {"String", "Str", "Shubhash", "Saini"};

        var stringList = Arrays.asList(stringArray);

        var resultOld  = stringList.stream()
                .collect(Collectors.joining())
                .toLowerCase()
                .chars()
                .mapToObj(c->(char)c)
                .collect(groupingBy(Function.identity() , counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .get()
                .getKey();

        var result = stringList.stream().collect(Collectors.joining()).toLowerCase()
               .chars().mapToObj(c -> (char)c)
                        .collect(groupingBy(Function.identity(),Collectors.counting()));

    System.out.println(resultOld);
    }


}
