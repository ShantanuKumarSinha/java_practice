package shann.java.problems.bitwise;

public class LongestConsecutiveOnesByReplacement {

  public static void main(String[] args) {
    // var A = "01110110110";
    var A = "11010110000000000";
    int count = 0, maxStreak = 0;
    int countOf1s = 0, longestConsecutive1s = 0;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '1') countOf1s++;
    }
    if (countOf1s == A.length()) {
      System.out.println(countOf1s);
      return;
    }

    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '0') {
        int j = i - 1, left = 0, right = 0;
        while (j >= 0) {
          if (A.charAt(j) == '1') left++;
          else break;
          j--;
        }
        j = i + 1;
        while (j < A.length()) {
          if (A.charAt(j) == '1') right++;
          else break;
          j++;
        }
        if (left + right == countOf1s) {
          System.out.println(left + right);
          return;
        }
        if (left + right + 1 > longestConsecutive1s) longestConsecutive1s = left + right + 1;
      }
    }
    System.out.println(longestConsecutive1s);
  }
}
