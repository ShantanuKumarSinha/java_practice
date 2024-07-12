package shann.java.problems.datastructure.matrix;

import java.util.Arrays;

public class SpiralMatrix {

  public static void main(String[] args) {
    SpiralMatrix spiralMatrix = new SpiralMatrix();
    var result = spiralMatrix.generateMatrix(3);
    var matrix = Arrays.asList(result);
    for (var i = 0; i < matrix.size(); i++) {
      System.out.println(Arrays.asList(matrix.get(i)));
    }
  }

  public int[][] generateMatrix(int A) {
    int[][] spiralMatrix = new int[A][A];
    int row = 0, col = 0, count = 0;
    while (A > 1) {
      for (int i = 0; i < A - 1; i++) {
        spiralMatrix[row][col] = ++count;
        col++;
      }
      for (int i = 0; i < A - 1; i++) {
        spiralMatrix[row][col] = ++count;
        row++;
      }
      for (int i = 0; i < A - 1; i++) {
        spiralMatrix[row][col] = ++count;
        col--;
      }
      for (int i = 0; i < A - 1; i++) {
        spiralMatrix[row][col] = ++count;
        row--;
      }
      row++; col++;
      A -= 2;
    }
    if (A == 1) spiralMatrix[row][col] = ++count;

    return spiralMatrix;
  }
}
