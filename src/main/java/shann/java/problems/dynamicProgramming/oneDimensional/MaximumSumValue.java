package shann.java.problems.dynamicProgramming.oneDimensional;

/*
Problem Description

You are given an array A of N integers and three integers B, C, and D.

You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.



Problem Constraints

1 <= N <= 105

-10000 <= A[i], B, C, D <= 10000



Input Format

First argument is an array A
Second argument is an integer B
Third argument is an integer C
Fourth argument is an integer D



Output Format

Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.



Example Input

Input 1:

 A = [1, 5, -3, 4, -2]
 B = 2
 C = 1
 D = -1
Input 2:

 A = [3, 2, 1]
 B = 1
 C = -10
 D = 3


Example Output

Output 1:

 18
Output 2:

 -4

*/
public class MaximumSumValue {
  public static void main(String[] args) {
    MaximumSumValue maximumSumValue = new MaximumSumValue();
    int[] input = {1, 5, -3, 4, -2};
    int b = 2, c = 1, d = -1;
    var result = maximumSumValue.findMaxSum(input, b, c, d);
    System.out.println(result);
  }

  private int findMaxSum(int[] arr, int b, int c, int d) {
    int maxOfB[] = new int[arr.length];
    maxOfB[0] = b * arr[0];
    for (int i = 1; i < arr.length; i++) {
      maxOfB[i] = Math.max(maxOfB[i - 1], b * arr[i]);
    }
    int maxOfC[] = new int[arr.length];
    maxOfC[0] = maxOfB[0] + c * arr[0];
    for (int i = 1; i < arr.length; i++) {
      maxOfC[i] = Math.max(maxOfB[i] + c * arr[i], maxOfC[i - 1]);
    }
    int maxOfD[] = new int[arr.length];
    maxOfD[0] = maxOfC[0] + d * arr[0];
    for (int i = 1; i < arr.length; i++) {
      maxOfD[i] = Math.max(maxOfD[i - 1], maxOfC[i] + d * arr[i]);
    }
    return maxOfD[arr.length - 1];
  }
}
