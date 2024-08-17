package shann.java.problems.comparator;

import java.util.*;

public class ArrangeStringsInDescendingOrderOfSize {
  public static void main(String[] args) {
    String s = "abc bcd ddddeeds ewrwerewr rr rtr rteq qwi ewrwerewrwqeqweqwe";
    var lst = Arrays.asList(s.split(" "));
    var ans = solve(lst);
    System.out.println(ans);
  }

  public static List<String> solve(List<String> A) {
    Collections.sort(A, new MyComparator().reversed());
    return A;
  }
}

class MyComparator implements Comparator<String> {
  @Override
  public int compare(String s1, String s2) {
    if (s1.length() == s2.length()) return 0;
    else {
      return s1.length() - s2.length();
    }
  }
}
