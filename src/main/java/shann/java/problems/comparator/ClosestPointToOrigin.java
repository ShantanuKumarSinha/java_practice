package shann.java.problems.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPointToOrigin {
  public static void main(String[] args) {
    int[][] arr = new int[][] {{1, 3}, {-2, 2}};
    int numbersOfClosestPoint = 1;
    Arrays.sort(arr, new DistanceComparator());
    int[][] result = new int[numbersOfClosestPoint][2];
    for (int i = 0; i < numbersOfClosestPoint; i++) {
      result[i][0] = arr[i][0];
      result[i][1] = arr[i][1];
    }
    for (int i = 0; i < numbersOfClosestPoint; i++) {
      System.out.println(result[i][0] + " " + result[i][1]);
    }
  }
}

class DistanceComparator implements Comparator<int[]> {
  @Override
  public int compare(int[] o1, int[] o2) {
    if (Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]) < Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1]))
      return -1;
    else if (Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]) > Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1]))
      return 1;
    return 0;
  }
}
