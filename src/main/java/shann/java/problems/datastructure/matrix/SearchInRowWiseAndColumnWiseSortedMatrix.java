package shann.java.problems.datastructure.matrix;

import java.util.ArrayList;
import java.util.List;

public class SearchInRowWiseAndColumnWiseSortedMatrix {
  public static void main(String[] args) {
    SearchInRowWiseAndColumnWiseSortedMatrix searchInRowWiseAndColumnWiseSortedMatrix =
        new SearchInRowWiseAndColumnWiseSortedMatrix();
    var list =
        new ArrayList<>(
            List.of(
                new ArrayList<>(List.of(1, 2, 3)),
                new ArrayList<>(List.of(4, 5, 6)),
                new ArrayList<>(List.of(7, 8, 9))));
    //    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};int searchCriteria =2;
    // int[][] matrix = {{1, 2}, {3, 3}};int searchCriteria =3;
    int[][] matrix = {{1, 3, 5, 7}, {2, 4, 6, 8}};
    int searchCriteria =10;

    System.out.println(searchInRowWiseAndColumnWiseSortedMatrix.search(matrix, searchCriteria));
  }

  private int search(int[][] matrix, int searchCriteria) {
      int col = matrix[0].length - 1, row = 0;
      int sum = 0, ans = Integer.MAX_VALUE;
      while (col >= 0 && row < matrix.length) {
        if (matrix[row][col] == searchCriteria) {
          sum = (row + 1) * 1009 + col + 1;
          if (sum < ans) ans = sum;
          col--;    
        } else if (matrix[row][col] > searchCriteria) {
          col--;
        } else row++;
      }
      if(ans==Integer.MAX_VALUE&& sum==0)
        return -1;
      return ans;
  }
}
