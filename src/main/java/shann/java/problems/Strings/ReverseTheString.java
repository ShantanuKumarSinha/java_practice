package shann.java.problems.Strings;

import java.util.Collections;
import java.util.Comparator;

public class ReverseTheString {
  public static void main(String[] args) {
    var value = "Test";

//    var stringArray = value.toCharArray();
//    StringBuilder sb = new StringBuilder();
//    for (int i = stringArray.length - 1; i >= 0; i--) {
//      sb.append(stringArray[i]);
//    }
//    var result = sb.toString();
//    System.out.println(result);


    var list = value.chars().mapToObj(c -> (char) c).toList();
    var reversedList = list.stream().sorted((a,b)->b-a);
    StringBuilder sb = new StringBuilder();
    reversedList.forEach(
        s -> {
          sb.append(s);
        });
    System.out.println(sb.toString());
  }
}
