package shann.java.problems.datastructure.matrix;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedOverlappingIntervals {
  public static void main(String[] args) {
    int[][] matrix = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    int l = matrix[0][0], r = matrix[0][1];
    int left = 0, right = 0;
    for (int i = 1; i < matrix.length; i++) {
      if (r > matrix[i][0]) {
        if (r < matrix[i][1]) r = matrix[i][1];
      } else {
        result.add(new ArrayList<Integer>(List.of(l, r)));
        l = matrix[i][0];
        r = matrix[i][1];
      }
    }
    result.add(new ArrayList<Integer>(List.of(l, r)));
    System.out.println(result);
  }
}
