package shann.java.problems.dynamicProgramming.applicationOfKanpSack;


/*
Problem Description

Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).



Problem Constraints

1 <= length(A), length(B) <= 700



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B.



Output Format

Return an integer representing the answer as described in the problem statement.



Example Input

Input 1:

 A = "abc"
 B = "abc"
Input 2:

 A = "rabbbit"
 B = "rabbit"


Example Output

Output 1:

 1
Output 2:

 3


Example Explanation

Explanation 1:

 Both the strings are equal.
Explanation 2:

 These are the possible removals of characters:
    => A = "ra_bbit"
    => A = "rab_bit"
    => A = "rabb_it"

 Note: "_" marks the removed character.
*/
public class DistinctiveSubSequence {
  public static void main(String[] args) {
    DistinctiveSubSequence distinctiveSubSequence = new DistinctiveSubSequence();
    String a = "abc";
    String b = "abc";
    System.out.println(distinctiveSubSequence.findDistinctSubsequence(a, b));
  }

  private int findDistinctSubsequence(String a, String b) {
    int[] dp = new int[b.length() + 1];
    dp[0] = 1;
    for (int i = 0; i < a.length(); i++) {
      for (int j = b.length() - 1; j >= 0; j--) {
        if (a.charAt(i) == b.charAt(j)) dp[j + 1] += dp[j];
      }
    }
    return dp[b.length()];
  }
}
