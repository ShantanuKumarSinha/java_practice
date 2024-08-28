package shann.java.problems.queues;

import java.util.PriorityQueue;
import java.util.Queue;

/*
* Problem Description
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.

NOTE: All the A integers will fit in 32-bit integers.



Problem Constraints
1 <= A <= 29500



Input Format
The only argument given is integer A.



Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.



Example Input
Input 1:

 A = 3
Input 2:

 A = 7


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [1, 2, 3, 11, 12, 13, 21]


Example Explanation
Explanation 1:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:

 Output denotes the first 7 integers that contains only digits 1, 2 and 3.

*/
public class NthNumberContainingOnlyGivenNumber {
  public static void main(String[] args) {
    var nums = findNthNumber(1);
    QueueUtility.printELementsOfArray(nums);
  }

  private static int[] findNthNumber(int n) {
    int[] result = new int[n];
    Queue<Integer> queue = new PriorityQueue<>();

    int j = 0;
    while (j < 3 && j<n) {
      result[j] = j + 1;
      queue.add(j + 1);
      j++;
    }
    if (n <= 3) return result;

    int i = 4;
    while (i <= n) {
      int rem = queue.poll();
      var a = rem * 10 + 1;
      var b = rem * 10 + 2;
      var c = rem * 10 + 3;
      queue.add(a);
      queue.add(b);
      queue.add(c);
      result[i - 1] = a;
      if (i < n) result[i] = b;
      if (i + 1 < n) result[i + 1] = c;
      i += 3;
    }

    return result;
  }
}
