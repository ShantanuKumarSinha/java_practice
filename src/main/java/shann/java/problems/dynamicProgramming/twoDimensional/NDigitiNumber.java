package shann.java.problems.dynamicProgramming.twoDimensional;

/*
Problem Description

Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.

Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007



Problem Constraints

1 <= A <= 1000

1 <= B <= 10000



Input Format

First argument is the integer A

Second argument is the integer B



Output Format

Return a single integer, the answer to the problem



Example Input

Input 1:

 A = 2
 B = 4
Input 2:

 A = 1
 B = 3


Example Output

Output 1:

 4
Output 2:

 1


Example Explanation

Explanation 1:

 Valid numbers are {22, 31, 13, 40}
 Hence output 4.
Explanation 2:

 Only valid number is 3
*/
//TODO
public class NDigitiNumber {
  private static final int MOD = 1000000007;

  public static void main(String[] args) {
    int allowedNumbers = 2;
    int sum = 4;
    int[][] dp = new int[allowedNumbers + 1][sum + 1];
    for (int i = 0; i <= allowedNumbers; i++) {
      for (int j = 0; j <= sum; j++) {
        dp[i][j] = -1;
      }
    }
    NDigitiNumber nDigitiNumber = new NDigitiNumber();
    var result = nDigitiNumber.countNumberOfDigits(allowedNumbers, sum, true, dp);
    System.out.println(result);
  }

  private int countNumberOfDigits(int allowedNumbers, int sum, boolean isFirstDig, int[][] dp) {
    if (allowedNumbers == 0 && sum == 0) return 1;
    if (allowedNumbers == 0 || sum < 0) return 0;

    if (dp[allowedNumbers][sum] != -1) return dp[allowedNumbers][sum];

    int ways = 0;
    int startDigit = isFirstDig ? 1 : 0;

    for (int d = startDigit; d <= 9; d++) {
      ways = (ways + countNumberOfDigits(allowedNumbers - 1, sum - d, false, dp)) % MOD;
    }

    dp[allowedNumbers][sum] = ways;
    return ways;
  }

  private int countNumberOfDigits(int allowedNumbers, int sum, boolean isFirstDig) {
    return 0;
  }
}
