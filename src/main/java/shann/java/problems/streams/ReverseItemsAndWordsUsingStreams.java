package shann.java.problems.streams;


import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseItemsAndWordsUsingStreams {
    //write a program to reverse each word individually in the string
    public static void main(String[] args){
        String stringToBeReversed = "I Love Java";
        var list1 = Arrays.asList(stringToBeReversed.split(" "));
        Collections.reverse(list1);
        System.out.println(list1);

        String originalString = "how are you";
        var list = Arrays.asList(originalString.split(" "));
        var reverse = list
                .stream()
                .map(word -> new StringBuilder(word).reverse()+" ")
                .collect(Collectors.joining());
    System.out.println(reverse);
    }
}

