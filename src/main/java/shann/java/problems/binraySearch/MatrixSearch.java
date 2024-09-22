package shann.java.problems.binraySearch;

/*
* Problem Description
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.



Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.



Output Format
Return 1 if B is present in A else, return 0.



Example Input
Input 1:

A = [
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]
    ]
B = 3
Input 2:

A = [
      [5, 17, 100, 111]
      [119, 120, 127, 131]
    ]
B = 3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

 3 is present in the matrix at A[0][1] position so return 1.
Explanation 2:

 3 is not present in the matrix so return 0.
*
* */

public class MatrixSearch {
  public static void main(String[] args) {
    int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
    System.out.println(matrixSearch(matrix1, 3));

    int[][] matrix2 = {{5, 17, 100, 111}, {119, 120, 127, 131}};
    System.out.println(matrixSearch(matrix2, 3));
  }

  private static boolean matrixSearch(int[][] matrix, int target) {
    int start = 0, end = matrix.length - 1;
    while (start <= end) {
      int midOfMatrix = start + (end - start) / 2;
      if (matrix[midOfMatrix][0] <= target
          && matrix[midOfMatrix][matrix[midOfMatrix].length - 1] >= target) {
        return doBinarySearch(matrix[midOfMatrix], target);
      } else if (matrix[midOfMatrix][matrix[midOfMatrix].length - 1] < target)
        start = midOfMatrix + 1;
      else end = midOfMatrix - 1;
    }
    return false;
  }

  private static boolean doBinarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) return true;
      else if (arr[mid] < target) left = mid + 1;
      else right = mid - 1;
    }
    return false;
  }
}
