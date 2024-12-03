package shann.java.problems.dynamicProgramming.applicationOfKanpSack;

/*
Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).



Problem Constraints

1 <= N <= 500

1 <= C, B[i] <= 106

1 <= A[i] <= 50



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [6, 10, 12]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [1, 3, 2, 4]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 22
Output 2:

 0
*/
public class KnapSack2 {
  public static void main(String[] args) {
    int[] value = {6, 10, 12};
    int[] weighs = {10, 20, 30};
    int capacity = 50;
    KnapSack2 knapSack = new KnapSack2();
    var result = knapSack.findMaxValue(weighs, value, capacity);
    System.out.println(result);
  }

  private int findMaxValue(int[] weight, int[] value, int capacity) {
    int[] dp = new int[capacity + 1];

    for (int i = 0; i < value.length; i++) {
      for (int j = capacity; j >= weight[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
      }
    }
    return dp[capacity];
  }
}
