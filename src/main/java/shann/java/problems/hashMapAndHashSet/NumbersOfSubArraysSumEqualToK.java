package shann.java.problems.hashMapAndHashSet;

import java.util.HashMap;
import java.util.Map;

public class NumbersOfSubArraysSumEqualToK {
  public static void main(String[] args) {
    int[] arr = {1, 0, 1};
    int k = 1;
    int[] prefixSum = new int[arr.length];
    prefixSum[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 0; i < prefixSum.length; i++) {
      if (map.containsKey(prefixSum[i] - k)) {
        count += map.get(prefixSum[i] - k);
      }
      map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
    }
    System.out.println(count);
  }
}
