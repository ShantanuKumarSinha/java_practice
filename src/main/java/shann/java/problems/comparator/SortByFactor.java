package shann.java.problems.comparator;

import static shann.java.problems.numbers.FactorsCount.factorsCount;

import java.util.Arrays;
import java.util.Comparator;

public class SortByFactor {
  public static void main(String[] args) {
    int[] A = {6, 8, 9};
    Integer[] boxedArray  = Arrays.stream(A).boxed().toArray(Integer[]::new);
    Arrays.sort(boxedArray, Comparator.reverseOrder());
    int[] result = Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
    System.out.println(Arrays.stream(result).boxed().toList());
  }
}

class FactorComparator implements Comparator<Integer> {

  @Override
  public int compare(Integer n1, Integer n2) {
    if (factorsCount(n1) < factorsCount(n2)) return -1;
    else if (factorsCount(n1) > factorsCount(n2)) return 1;
    else {
      if (n1 < n2) return -1;
      else if (n1 > n2) return 1;
      else return 0;
    }
  }
}
