package shann.java.problems.Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ReverseTheSentence {
  public static void main(String[] args) {
    String originalString = "I love Java";
    // output reversedString  = "Java love I";
//    var list = originalString.chars().mapToObj(c -> (char) c).toList();
//    Collections.sort(list, Comparator.reverseOrder());
//    StringBuilder sb = new StringBuilder();
//    list.forEach(
//        s -> {
//          sb.append(s);
//        });
//    System.out.println(sb.toString());
   var list = Arrays.asList(originalString.split(" "));
   Collections.reverse(list);
    System.out.println(list);
  }
}
