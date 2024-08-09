package shann.java.problems.hashMapAndHashSet;

import java.util.*;

public class CountOfSubArraysEqualToSum {
  public static void main(String[] args) {
    int[] A = {1, 0, 1};
    int B = 1;
    int[] prefiArray  = new int[A.length];
    prefiArray[0] = A[0];
    for (int i = 1; i < A.length; i++) {
      prefiArray[i] = prefiArray[i - 1] + A[i];
    }
    Set<Integer> set = new HashSet();
    set.add(0);
    int count = 0;
    for(int i = 0; i < prefiArray.length; i++) {
      if(set.contains(prefiArray[i]-B)) {
        count ++;
      }else{
        set.add(prefiArray[i]);
      }
    }
    System.out.println(count);
  }
}
