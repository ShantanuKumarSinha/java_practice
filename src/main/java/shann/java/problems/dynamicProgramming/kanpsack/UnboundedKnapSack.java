package shann.java.problems.dynamicProgramming.kanpsack;

/*
Problem Description

Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.



Problem Constraints

1 <= A <= 1000

1 <= |B| <= 1000

1 <= B[i] <= 1000

1 <= C[i] <= 1000



Input Format

First argument is the Weight of knapsack A

Second argument is the vector of values B

Third argument is the vector of weights C



Output Format

Return the maximum value that fills the knapsack completely



Example Input

Input 1:

A = 10
B = [5]
C = [10]
Input 2:

A = 10
B = [6, 7]
C = [5, 5]


Example Output

Output 1:

 5
Output 2:

14


Example Explanation

Explanation 1:

Only valid possibility is to take the given item.
Explanation 2:

Take the second item twice.
*/
public class UnboundedKnapSack {
  public static void main(String[] args) {
    int capacity = 50;
    int[] weights = {20, 10, 30, 40};
    int[] values = {100, 60, 120, 150};
    UnboundedKnapSack unboundedKnapSack = new UnboundedKnapSack();
    var result1 = unboundedKnapSack.findUnboundedKnapSackBottomUp(weights, values, capacity);
    var result2 = unboundedKnapSack.findUnboundedKnapSackBottomUp2(weights, values, capacity);
    System.out.println(result1);
    System.out.println(result2);
  }

  private int findUnboundedKnapSackBottomUp(int[] weights, int[] values, int capacity) {
    int[] dp = new int[capacity + 1];

    for (int i = 0; i <= capacity; i++) {
      for (int j = 0; j < weights.length; j++) {
        if (weights[j] <= i) {
          dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
        }
      }
    }
    return dp[capacity];
  }

  private int findUnboundedKnapSackBottomUp2(int[] weights, int[] values, int capacity) {
    int[][] dp = new int[weights.length + 1][capacity + 1];

    for (int i = 0; i <= weights.length; i++) {
      for (int j = 0; j <= capacity; j++) {
        if (i == 0 || j == 0) dp[i][j] = 0;
        else {
          var reject = dp[i - 1][j];
          var select = 0;
          if (weights[i - 1] <= j) {
            select = dp[i][j - weights[i - 1]] + values[i - 1];
          }
          dp[i][j] = Math.max(reject, select);
        }
      }
    }
    return dp[weights.length][capacity];
  }
}
