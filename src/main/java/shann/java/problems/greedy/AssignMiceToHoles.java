package shann.java.problems.greedy;

import java.util.Arrays;

/*
Problem Description

N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.



The positions of Mice are denoted by array A, and the position of holes is denoted by array B.

A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consume 1 minute.

Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.





Problem Constraints

1 <= N <= 105

-109 <= A[i], B[i] <= 109



Input Format

The first argument is an integer array A.



The second argument is an integer array B.





Output Format

Return an integer denoting the minimum time when the last nouse gets inside the holes.



Example Input

Input 1:

 A = [-4, 2, 3]
 B = [0, -2, 4]
Input 2:

 A = [-2]
 B = [-6]


Example Output

Output 1:

 2
Output 2:

 4


Example Explanation

Explanation 1:

 Assign the mouse at position (-4 to -2), (2 to 0) and (3 to 4).
 The number of moves required will be 2, 2 and 1 respectively.
 So, the time taken will be 2.
Explanation 2:

 Assign the mouse at position -2 to -6.
 The number of moves required will be 4.
 So, the time taken will be 4.
*/
public class AssignMiceToHoles {
  public static void main(String[] args) {
    int[] mice = {-4, 2, 3};
    int[] holes = {0, -2, 4};
    AssignMiceToHoles assignMiceToHoles = new AssignMiceToHoles();
    var ans = assignMiceToHoles.findMinimumTimeInWhichMouseGetsHole(mice, holes);
    System.out.println(ans);
  }

  private int findMinimumTimeInWhichMouseGetsHole(int[] mice, int[] holes) {
    Arrays.sort(mice);
    Arrays.sort(holes);
    var timeTaken = Integer.MIN_VALUE;
    for (int i = 0; i < mice.length; i++) {
      timeTaken = Math.max(timeTaken, Math.abs(mice[i] - holes[i]));
    }
    return timeTaken;
  }
}
