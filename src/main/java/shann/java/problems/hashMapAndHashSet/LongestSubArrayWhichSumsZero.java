package shann.java.problems.hashMapAndHashSet;

import java.util.*;

public class LongestSubArrayWhichSumsZero {
  public static void main(String[] args) {
    int[] A = {9, -20, -11, -8, -4, 2, -12, 14, 1};
    // int[] A = {16,-16,2};
    int[] prefixSum = new int[A.length];
    prefixSum[0] = A[0];
    for (int i = 1; i < A.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + A[i];
    }

    Set<Integer> set = new HashSet<>();
    int maxLength = 0;
    for (int i = 0; i < prefixSum.length; i++) {
      if (prefixSum[i] == 0) maxLength = Math.max(maxLength, i + 1);
    }
    int firstIndex = 0, secondIndex = 0;
    for (int i = 0; i < prefixSum.length; i++) {
      if (set.contains(prefixSum[i])) {
        secondIndex = i;
        for (int j = 0; j < secondIndex; j++) {
          if (prefixSum[j] == prefixSum[i]) {
            firstIndex = j;
            break;
          }
        }
        maxLength = Math.max(maxLength, secondIndex - firstIndex);
      } else set.add(prefixSum[i]);
    }

    //    Map<Integer, List<Integer>> map = new HashMap<>();
    //    for (int i = 0; i < A.length; i++) {
    //      map.computeIfAbsent(prefixSum[i], k -> new ArrayList<>()).add(i);
    //    }
    //    for (List<Integer> indexList : map.values()) {
    //      if (indexList.size() == 2) {
    //        maxLength = Math.max(maxLength, indexList.get(1) - indexList.get(0));
    //      }
    //    }

    System.out.println(maxLength);
  }
}
