package shann.java.problems.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Problem Description

N people having different priorities are standing in a queue.


The queue follows the property that each person is standing at most B places away from its position in the sorted queue.

Your task is to sort the queue in the increasing order of priorities.

NOTE:

No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).

Problem Constraints

1 <= N <= 100000
0 <= B <= N



Input Format

The first argument is an integer array A representing the priorities and initial order of N persons.
The second argument is an integer B.



Output Format

Return an integer array representing the sorted queue.



Example Input

Input 1:

 A = [1, 40, 2, 3]
 B = 2
Input 2:

 A = [2, 1, 17, 10, 21, 95]
 B = 1


Example Output

Output 1:

 [1, 2, 3, 40]
Output 2:

 [1, 2, 10, 17, 21, 95]


Example Explanation

Explanation 1:

 Given array A = [1, 40, 2, 3]
 After sorting, A = [1, 2, 3, 40].
 We can see that difference between initial position of elements amd the final position <= 2.
Explanation 2:

 After sorting, the array becomes [1, 2, 10, 17, 21, 95].
*/
public class SortNearlySortedArray {
  public static void main(String[] args) {
    SortNearlySortedArray sortNearlySortedArray = new SortNearlySortedArray();
    var result1 = sortNearlySortedArray.getSortedArray(new int[] {1, 40, 2, 3}, 2);
    System.out.println(Arrays.toString(result1));

    var result2 = sortNearlySortedArray.getSortedArray(new int[] {2, 1, 17, 10, 21, 95}, 2);
    System.out.println(Arrays.toString(result2));
  }

  private int[] getSortedArray(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < k + 1; i++) {
      pq.add(arr[i]);
    }
    int[] result = new int[arr.length];
    int index = 0;
    for (int i = k + 1; i < arr.length; i++) {
      result[index++] = pq.poll();
      pq.add(arr[i]);
    }
    while (!pq.isEmpty()) {
      result[index++] = pq.poll();
    }
    return result;
  }
}
