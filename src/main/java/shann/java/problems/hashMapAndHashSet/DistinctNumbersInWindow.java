package shann.java.problems.hashMapAndHashSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
  public static void main(String[] args) {
    int[] A = {1, 2, 1, 3, 4, 3};
    int B = 3;
    int[] result = new int[A.length-B+1];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < B; i++) {
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }
    int count = 0;
    result[count++] = map.size();
    for (int i = B; i < A.length; i++) {
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
      if (map.get(A[i-B]) ==1)
        map.remove(A[i-B]);
        else
          map.put(A[i-B], map.get(A[i-B]) - 1);
        result[count++] = map.size();
    }
    System.out.println(Arrays.stream(result).boxed().toList());
  }
}
