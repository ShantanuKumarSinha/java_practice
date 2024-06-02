package shann.java.problems;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface =(a, b)-> a*b;
        System.out.println(myFunctionalInterface.calculate(5,4));
    // count the occurrence of items in list
    List<String> list =
        Arrays.asList("Pen", "Java", "Name", "Pen", "Mango", "Stapler", "Name", "Mango");
    var map =
        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(map);
    }
}
