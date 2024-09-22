package shann.java.problems.combinatorics;

/*
* Problem Description

Write a program to print the pascal triangle up to A rows.



Problem Constraints

1 <= A <= 25



Input Format

The first argument is an integer A.



Output Format

Return a 2D array consisting of A rows whose each row contains A integers.



Example Input

Input 1:

A = 3
Input 2:

A = 5


Example Output

Output 1:

1 0 0
1 1 0
1 2 1
Output 2:

1 0 0 0 0
1 1 0 0 0
1 2 1 0 0
1 3 3 1 0
1 4 6 4 1
*/

public class PascalTriangle {
  public static void main(String[] args) {
    var result1 = generatePascalTriangle(3);
    MatrixPrinter.printMatrix(result1);
    var result2 = generatePascalTriangle(5);
    MatrixPrinter.printMatrix(result2);
  }

  private static int[][] generatePascalTriangle(int numberOfRows) {
    int[][] result = new int[numberOfRows][numberOfRows];
    result[0][0] = 1;
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) result[i][j] = 1;
        else result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
      }
    }
    return result;
  }
}
