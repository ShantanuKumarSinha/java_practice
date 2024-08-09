package shann.java.problems.hashMapAndHashSet;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingElement {
  public static void main(String[] args) {
    int[] A = {10, 5, 3, 4, 3, 5, 6};
    var result = firstRepeatingElement(A);
    System.out.println(result);
  }

  private static int firstRepeatingElement(int[] arr) {
    Set<Integer> hashSet = new HashSet<>();
    int minIndex = Integer.MAX_VALUE;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (hashSet.contains(arr[i])) {
        if (minIndex > i) minIndex = i;
      } else hashSet.add(arr[i]);
    }
    if (minIndex == Integer.MAX_VALUE) return -1;
    return arr[minIndex];
  }
}
