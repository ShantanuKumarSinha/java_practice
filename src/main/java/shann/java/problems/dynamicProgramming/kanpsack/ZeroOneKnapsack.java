package shann.java.problems.dynamicProgramming.kanpsack;

/*
Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Problem Constraints

1 <= N <= 103

1 <= C <= 103

1 <= A[i], B[i] <= 103



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 220
Output 2:

 0


Example Explanation

Explanation 1:

 Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
Explanation 2:

 Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
*/
public class ZeroOneKnapsack {
  public static void main(String[] args) {
    int[] value = {60, 100, 120};
    int[] weight = {10, 20, 30};
    int n = 3;
    int capacity = 50;
    int[][] dp = new int[3][capacity + 1];
    fillArray(dp);
    ZeroOneKnapsack knapsack = new ZeroOneKnapsack();
    System.out.println(knapsack.zeroOneKnapsack(n - 1, capacity, weight, value, dp));
    System.out.println(knapsack.zeroOneKnapsack2(weight, value, capacity));
  }

  private static void fillArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = -1;
      }
    }
  }

  // top-down approach
  private int zeroOneKnapsack(int i, int j, int[] weight, int[] value, int[][] dp) {
    if (i < 0 || j < 0) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    int reject = zeroOneKnapsack(i - 1, j, weight, value, dp);
    int select = 0;
    if (weight[i] <= j) {
      select = zeroOneKnapsack(i - 1, j - weight[i], weight, value, dp) + value[i];
    }
    dp[i][j] = Math.max(select, reject);
    return dp[i][j];
  }

  // bottom up approach
  private int zeroOneKnapsack2(int[] weight, int[] value, int capacity) {
    int[][] dp = new int[weight.length + 1][capacity + 1];

    for (int i = 0; i <= weight.length; i++) {
      for (int j = 0; j <= capacity; j++) {
        if (i == 0 || j == 0) dp[i][j] = 0;
        else {
          var rej = dp[i - 1][j];
          var sel = 0;
          if (weight[i - 1] <= j) sel = dp[i - 1][j - weight[i - 1]] + value[i - 1];
          dp[i][j] = Math.max(sel, rej);
        }
      }
    }
    return dp[weight.length][capacity];
  }
}
