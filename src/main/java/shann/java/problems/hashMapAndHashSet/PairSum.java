package shann.java.problems.hashMapAndHashSet;

import java.util.HashSet;
import java.util.Set;

public class PairSum {
  public static void main(String[] args) {
    int A = 8;
    int[] B = {3, 5, 1, 2, 1, 2};
    Set<Integer> set = new HashSet<>();
    for (int i : B) {
      if (set.contains(A - i)) {
        System.out.println(1);
        return;
      } else set.add(i);
    }
  }
}
