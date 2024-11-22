package shann.java.problems.hashMapAndHashSet;

/*
Problem Description

Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.



Problem Constraints

1 <= length(A) <= 2500
0 <= A[i] <= 2500



Input Format

The first and the only argument is an integer array A.



Output Format

Return an integer representing the length of the longest increasing subsequence.



Example Input

Input 1:

 A = [1, 2, 1, 5]
Input 2:

 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
//    1, 2, 2, 3,  2, 3,  3, 4,  2, 4, 3, 4

Example Output

Output 1:

 3
Output 2:

 6


Example Explanation

Explanation 1:

 The longest increasing subsequence: [1, 2, 5]
Explanation 2:

 The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
*/
// dynamic programming
public class LongestIncreasingSubSequence {

  public static void main(String[] args) {
    LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
    var result = lis.findLongestIncreasingSubSequence(new int[] {1, 2, 1, 5});
    System.out.println(result);

    var result2 =
        lis.findLongestIncreasingSubSequence(
            new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
    System.out.println(result2);

    var result3 =
        lis.findLongestIncreasingSubSequence(
            new int[] {
              14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78
            });
    System.out.println(result3);
    System.out.println(result3);
  }

  private int findLongestIncreasingSubSequence(int[] arr) {
    var result = new int[arr.length];
    for (var i = 0; i < result.length; i++) {
      result[i] = 1;
    }
    for (var i = 0; i < arr.length; i++) {
      for (int j = 0; j <= i - 1; j++) {
        if (arr[j] < arr[i]) {
          result[i] = Math.max(result[j] + 1, result[i]);
        }
      }
    }
    int sequenceLength = 0;
    for (var i = 0; i < result.length; i++) {
      sequenceLength = Math.max(sequenceLength, result[i]);
    }
    return sequenceLength;
  }
}
