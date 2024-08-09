package shann.java.problems.hashMapAndHashSet;

import java.util.HashMap;
import java.util.Map;

public class CountPairDiff {
  public static void main(String[] args) {
    int B = 25;
    int[] A = {19,8,17,17,16,6,3,11,25,17};
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }
    for (int i : A) {
      if (map.containsKey((i - B))) {
        count += map.get((i - B));
      }
    }
    System.out.println(count);
  }
}
