package shann.java.problems.hashMapAndHashSet;

import java.util.*;

// TODO
public class CommonElements {
  public static void main(String[] args) {
    int[] arr1 = {1, 2, 2, 1};
    int[] arr2 = {2, 3, 1, 2};
    solve(arr1, arr2);
  }

  public static int[] solve(int[] A, int[] B) {
    Map<Integer, Integer> aMap = new HashMap<>();
    Map<Integer, Integer> bMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for (int a : A) {
      if (aMap.containsKey(a)) aMap.put(a, aMap.get(a) + 1);
      else aMap.put(a, 1);
    }

    for (int b : B) {
      if (aMap.containsKey(b) && aMap.get(b) > 0) {
        list.add(b);
        aMap.put(b, aMap.get(b) - 1);
      }
    }
    System.out.println(list);
    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
