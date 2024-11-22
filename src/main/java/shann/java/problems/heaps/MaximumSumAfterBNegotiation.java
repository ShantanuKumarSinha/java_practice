package shann.java.problems.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description

Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].


You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.



NOTE: You can perform the modification on the same element multiple times.



Problem Constraints

1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100



Input Format

The first argument given is an integer array A.
The second argument given is an integer B.



Output Format

Return an integer denoting the maximum array sum after B modifications.



Example Input

Input 1:

 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:

 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10


Example Output

Output 1:

 196
Output 2:

 362


Example Explanation

Explanation 1:


Operation 1: Make -29 to 29,
Operation 2: Make -9 to 9,
Operation 3: Make 9 to -9,
Operation 4: Make -68 to 68.
Thus, the final array after 4 modifications = [24, 68, 29, -9, 84]
Explanation 2:

 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
*/
// TODO Heaps1 Additional Question - 1
public class MaximumSumAfterBNegotiation {
  public static void main(String[] args) {
    MaximumSumAfterBNegotiation maximumSumAfterBNegotiation = new MaximumSumAfterBNegotiation();
    var list = new ArrayList<Integer>(List.of(24, -68, -29, -9, 84));
    var numbersOfNegotiations = 4;
    var ans = maximumSumAfterBNegotiation.doNegotiate(list, numbersOfNegotiations);
    System.out.println(ans);
  }

  public int doNegotiate(List<Integer> list, int numbersOfNegotiations) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < list.size(); i++) {
      minHeap.add(list.get(i));
    }
    for (int i = 0; i < numbersOfNegotiations; i++) {
      var numbersToBeReplaced = minHeap.poll();
      minHeap.offer(-1 * numbersToBeReplaced);
    }
    var sum = 0;
    while (!minHeap.isEmpty()) {
      sum += minHeap.poll();
    }
    return sum;
  }
}
