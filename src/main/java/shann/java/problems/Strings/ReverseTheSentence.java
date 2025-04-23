package shann.java.problems.Strings;

import java.util.Arrays;
import java.util.Collections;

public class ReverseTheSentence {
  public static void main(String[] args) {
    String originalString = "I love Java";

    // output reversedString  = "Java love I";

   var list = Arrays.asList(originalString.split(" "));
   Collections.reverse(list);
    System.out.println(list);
  }
}
