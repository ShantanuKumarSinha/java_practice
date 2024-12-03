package shann.java.problems.dynamicProgramming.oneDimensional;

import java.util.Arrays;

/*
Problem Description

Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.



Problem Constraints

1 <= A <= 105



Input Format

First and only argument is an integer A.



Output Format

Return an integer denoting the minimum count.



Example Input

Input 1:

 A = 6
Input 2:

 A = 5


Example Output

Output 1:

 3
Output 2:

 2


Example Explanation

Explanation 1:

 Possible combinations are : (1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 1^2) and (1^2 + 1^2 + 2^2).
 Minimum count of numbers, sum of whose squares is 6 is 3.
Explanation 2:

 We can represent 5 using only 2 numbers i.e. 1^2 + 2^2 = 5
*/
public class MinimumNumbersOfSquare {
  public static void main(String[] args) {
    MinimumNumbersOfSquare minimumNumbersOfSquare = new MinimumNumbersOfSquare();

    var result1 = minimumNumbersOfSquare.minNumberOfSquares(5);
    System.out.println(result1);

    int[] dp2 = new int[34];
    Arrays.fill(dp2, Integer.MAX_VALUE);
    dp2[0]=0;
    dp2[1]=1;
    var result2 = minimumNumbersOfSquare.minNumberOfSquares2(33, dp2);
    System.out.println(result2);

    int[] dp3 = new int[14];
    Arrays.fill(dp3, Integer.MAX_VALUE);
    dp3[0]=0;
    dp3[1]=1;
    var result3 = minimumNumbersOfSquare.minNumberOfSquares2(13, dp3);
    System.out.println(result3);
  }

  // bottom up approach tabulation
  public int minNumberOfSquares(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 1; i <= n; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    return dp[n];
  }

  // top down approach memoization
  public int minNumberOfSquares2(int n, int[] dp) {
    if (n <= 1) return n;
    if (dp[n] != Integer.MAX_VALUE) return dp[n];
    for (int i = 1; i * i <= n; i++) {
      dp[n - i * i] =
          dp[n - i * i] != Integer.MAX_VALUE ? dp[n - i * i] : minNumberOfSquares2(n - i * i, dp);
      dp[n] = Math.min(dp[n], dp[n - i * i] + 1);
    }
    return dp[n];
  }
}
