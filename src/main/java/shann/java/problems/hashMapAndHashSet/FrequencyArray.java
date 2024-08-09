package shann.java.problems.hashMapAndHashSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyArray {
  public static void main(String[] args) {
    int[] A = {1, 2, 1, 1};
    int[] B = {1, 2, 5};
    Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    for (int a : A) {
      if (freqMap.containsKey(a)) freqMap.put(a, freqMap.get(a) + 1);
      else freqMap.put(a, 1);
    }
    int[] result = new int[B.length];
    int index = 0;
    for (int i = 0; i < B.length; i++) {
      if(freqMap.containsKey(B[i]))
      result[i] = freqMap.get(B[i]);
      else result[i] = 0;
    }
    List resultList = Arrays.stream(result).boxed().toList();
    System.out.println(resultList);
  }
}
