package shann.java.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* Problem Description
Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.



Problem Constraints
1 <= A <= 10



Input Format
First and only argument is integer A.



Output Format
Return a sorted list of all possible parenthesis.



Example Input
Input 1:

A = 3
Input 2:

A = 1


Example Output
Output 1:

[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:

[ "()" ]


Example Explanation
Explanation 1:

 All paranthesis are given in the output list.
Explanation 2:

 All paranthesis are given in the output list.
* */
public class GeneratePranathesis {
  public static void main(String[] args) {
    List<String> paranthesisList = new ArrayList<>();
    generatePranathesis(3, "", 0, 0, paranthesisList);
    System.out.println(paranthesisList);
  }

  private static void generatePranathesis(
      int n, String paranthesis, int opening, int closing, List<String> paranthesisList) {
    if (paranthesis.length() == 2 * n) paranthesisList.add(paranthesis);
    if (opening < n) generatePranathesis(n, paranthesis + "(", opening + 1, closing, paranthesisList);
    if (closing < opening) generatePranathesis(n, paranthesis + ")", opening, closing + 1, paranthesisList);
  }
}
