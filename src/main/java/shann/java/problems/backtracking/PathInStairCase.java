package shann.java.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
You are climbing a staircase and it takes A steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

You need to return all the distinct ways to climb to the top in lexicographical order.



Problem Constraints
2 <= A <= 25



Input Format
The first and the only argument contains an integer A, the number of steps.



Output Format
Return an 2-D Integer Array, which denotes all the unique valid paths to reach the top.



Example Input
Input 1:

 A = 2
Input 2:

 A = 3


Example Output
Output 1:

[ [1, 1], [2] ]
Output 2:

[ [1, 1, 1], [1, 2], [2, 1] ]


Example Explanation
Explanation 1:

 Distinct ways to reach top: 1 + 1, 2.
Explanation 2:

 Distinct ways to reach top: 1 + 1 + 1, 1 + 2, 2 + 1.
*/
public class PathInStairCase {
  public static void main(String[] args) {
    List<List<Integer>> resultList = new ArrayList<>();

    generateWaysToClimb(4, resultList, new ArrayList<>());
    System.out.println(resultList);
  }

  private static void generateWaysToClimb(int n, List<List<Integer>> result, List<Integer> steps) {
    if (n == 0) {
      result.add(new ArrayList<>(steps));
      return;
    }
    if (n >= 1) {
      steps.add(1);
      generateWaysToClimb(n - 1, result, steps);
      steps.remove(steps.size() - 1);
    }
    if (n >= 2) {
      steps.add(2);
      generateWaysToClimb(n - 2, result, steps);
      steps.remove(steps.size() - 1);
    }
  }
}
