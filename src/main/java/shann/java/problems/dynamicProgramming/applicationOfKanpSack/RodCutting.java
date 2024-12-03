package shann.java.problems.dynamicProgramming.applicationOfKanpSack;

/*
Problem Description

Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.

Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.



Problem Constraints

1 <= N <= 1000

0 <= A[i] <= 106



Input Format

First and only argument is an integer array A of size N.



Output Format

Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.



Example Input

Input 1:

 A = [3, 4, 1, 6, 2]
Input 2:

 A = [1, 5, 2, 5, 6]


Example Output

Output 1:

 15
Output 2:

 11


Example Explanation

Explanation 1:

 Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
Explanation 2:

 Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.

*/
public class RodCutting {
    public static void main(String[] args){
        int[] arr1 = {3, 4, 1, 6, 2};
        int[] arr2 = {1, 5, 2, 5, 6};

        int dp1[] = new int[arr1.length + 1];
        int dp2[] = new int[arr2.length + 1];

        RodCutting rodCutting = new RodCutting();
        var result1 = rodCutting.findTheMaxValueOfRodCuttingAndSelling(arr1,arr1.length);
        System.out.println(result1);
    }
    // bottom up approach
    private int findTheMaxValueOfRodCuttingAndSelling(int[] arr, int length) {
        int[] dp = new int[length + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], arr[j-1] + dp[i - j]);
            }
        }
        return dp[length];
    }
    // TODO
    // top down approach
    private int findTheMaxValueOfRodCuttingAndSelling2(int[] arr, int index, int[] dp) {

        return 0;
    }
}
