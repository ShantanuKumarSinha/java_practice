package shann.java.problems.backtracking;

import java.util.Arrays;

/*
* Problem Description
Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= N <= 9



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D array denoting all possible permutation of the array.



Example Input
A = [1, 2, 3]


Example Output
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3]
  [2, 3, 1]
  [3, 1, 2]
  [3, 2, 1] ]


Example Explanation
All the possible permutation of array [1, 2, 3].
*/
public class Permutation {
  private static int resultIndex=0;
  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    var factorial = getFactorial(arr.length);
    int[][] result = new int[factorial][arr.length];
    boolean[] visited = new boolean[arr.length];
    generatePermutation(arr, 0, new int[arr.length], visited, result);
    Arrays.stream(result).forEach(each->System.out.println(Arrays.toString(each)));
  }

  private static void generatePermutation(int[] arr, int index, int[] ans, boolean[] visited, int[][] result) {
    if (index == arr.length) {
      result[resultIndex++] = Arrays.copyOf(ans, ans.length);
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        ans[index] = arr[i];
        generatePermutation(arr, index + 1, ans, visited, result);
        visited[i] = false;
      }
    }
  }

  private static int getFactorial(int n) {
    int factorial = 1;
    while (n > 0) {
      factorial *= n;
      n--;
    }
    return factorial;
  }
}
