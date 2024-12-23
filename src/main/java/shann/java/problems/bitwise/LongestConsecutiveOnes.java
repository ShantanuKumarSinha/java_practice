package shann.java.problems.bitwise;

import java.util.ArrayList;
import java.util.List;

public class LongestConsecutiveOnes {

  public static void main(String[] args) {
    var list = new ArrayList<>(List.of( 0,1,1,1,0,1,1,0,1,1,0));
    int countOf1s = 0, longestConsecutive1s = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == '1') countOf1s++;
    }
    if (countOf1s == list.size()) {
      System.out.println(countOf1s);
      return;
    }

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 0) {
        int j = i - 1, left = 0, right = 0;
        while (j >= 0) {
          if (list.get(j) == 1) left++;
          else break;
          j--;
        }
        j = i + 1;
        while (j < list.size()) {
          if (list.get(j) == 1) right++;
          else break;
          j++;
        }
        if (left + right + 1 > longestConsecutive1s) longestConsecutive1s = left + right + 1;
      }
    }
    System.out.println(longestConsecutive1s);
  }
}
