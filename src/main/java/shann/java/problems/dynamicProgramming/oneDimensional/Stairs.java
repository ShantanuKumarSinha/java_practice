package shann.java.problems.dynamicProgramming.oneDimensional;

/*
Problem Description

You are climbing a staircase and it takes A steps to reach the top.


Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Return the number of distinct ways modulo 1000000007



Problem Constraints

1 <= A <= 105



Input Format

The first and the only argument contains an integer A, the number of steps.



Output Format

Return an integer, representing the number of ways to reach the top.



Example Input

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 2
Output 2:

 3


Example Explanation

Explanation 1:

 Distinct ways to reach top: [1, 1], [2].
Explanation 2:

 Distinct ways to reach top: [1 1 1], [1 2], [2 1].
*/
public class Stairs {
  // bottom up approach or memoisation
  int modulo = 1000000007;

  public static void main(String[] args) {
    Stairs stairs = new Stairs();
    var method1Result = stairs.getDistinctWayToClimbStairs(4);
    System.out.println(method1Result);
    var method2Result = stairs.getDistinctWayToClimbStairs2(4);
    System.out.println(method2Result);
  }

  // bottom up approach or Tabulation
  private int getDistinctWayToClimbStairs(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  // top down approach memmoization
  public int getDistinctWayToClimbStairs2(int n) {
    long[] dp = new long[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    if (n <= 3) return n;
    return recursiveCall(n, dp);
  }

  private int recursiveCall(int n, long[] dp) {
    if (dp[n] != 0) return (int) (dp[n] % modulo);
    else {
      dp[n] =
          ((int) ((recursiveCall(n - 1, dp)) % modulo)
              + (int) ((recursiveCall(n - 2, dp)) % modulo));
      return (int) dp[n] % modulo;
    }
  }
}
