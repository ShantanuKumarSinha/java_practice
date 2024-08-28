package shann.java.problems.queues;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Problem Description
Imagine you're an ice cream truck driver in a beachside town. The beach is divided into several sections, and each section has varying numbers of beachgoers wanting ice cream given by the array of integers A.

For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of potential customers in each section: [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the first section, 12 in the second, and so on.

You can only stop your truck in B consecutive sections at a time because of parking restrictions. To maximize sales, you want to park where the most customers are clustered together.

For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve the most customers. Return an array C, where C[i] is the busiest section in each of the B consecutive sections. Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.



Problem Constraints
1 <= |A|, B <= 106



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return an array C, where C[i] is the maximum value from A[i] to A[i+B-1].



Example Input
Input 1:

 A = [1, 3, -1, -3, 5, 3, 6, 7]
 B = 3
Input 2:

 A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 B = 6


Example Output
Output 1:

 [3, 3, 5, 5, 6, 7]
Output 2:

 [7, 7, 7, 7]


Example Explanation
Explanation 1:

 Window position     | Max
 --------------------|-------
 [1 3 -1] -3 5 3 6 7 | 3
 1 [3 -1 -3] 5 3 6 7 | 3
 1 3 [-1 -3 5] 3 6 7 | 5
 1 3 -1 [-3 5 3] 6 7 | 5
 1 3 -1 -3 [5 3 6] 7 | 6
 1 3 -1 -3 5 [3 6 7] | 7
Explanation 2:

 Window position     | Max
 --------------------|-------
 [1 2 3 4 2 7] 1 3 6 | 7
 1 [2 3 4 2 7 1] 3 6 | 7
 1 2 [3 4 2 7 1 3] 6 | 7
 1 2 3 [4 2 7 1 3 6] | 7

* */
public class ParkingIceCreamTruck {
  public static void main(String[] args) {

    var result1 = getMaxiumInGivenSlidingWindow(new int[] {3, 3, 5, 5, 6, 7}, 3);
    QueueUtility.printELementsOfArray(result1);

    var result2 = getMaxiumInGivenSlidingWindow(new int[] {1, 2, 3, 4, 2, 7, 1, 3, 6}, 6);
    QueueUtility.printELementsOfArray(result2);

    var result3 =
        getMaxiumInGivenSlidingWindow(
            new int[] {
              268, 202, 139, 744, 502, 582, 94, 81, 117, 258, 506, 461, 531, 768, 827, 128, 592,
              571, 559, 374, 910, 610, 561, 489, 647, 246, 355, 313, 158, 922, 557, 36, 430, 983,
              913, 303, 765, 945, 167, 340, 869, 869, 609, 809, 529, 715, 34, 13, 657, 407, 684,
              801, 129, 952, 159, 250, 546, 508, 540, 948, 429, 174
            },
            6);
  //  QueueUtility.printELementsOfArray(result3);
    int[] expectedResultForTestCase3 = {
      744, 744, 744, 744, 582, 582, 506, 531, 768, 827, 827, 827, 827, 827, 827, 910, 910, 910, 910,
      910, 910, 647, 647, 647, 922, 922, 922, 922, 983, 983, 983, 983, 983, 983, 945, 945, 945, 945,
      869, 869, 869, 869, 809, 809, 715, 715, 801, 801, 952, 952, 952, 952, 952, 952, 948, 948, 948
    };
    boolean[] expected = new boolean[expectedResultForTestCase3.length];
    for (int i = 0; i < expectedResultForTestCase3.length; i++) {

      expected[i] = expectedResultForTestCase3[i] == result3[i];
    }
    QueueUtility.printELementsOfArray(expected);
  }

  private static int[] getMaxiumInGivenSlidingWindow(int arr[], int k) {
    int[] result = new int[arr.length - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < k; i++) {
      while (!deque.isEmpty() && deque.peekLast() < arr[i]) {
        deque.removeLast();
      }
      deque.addLast(arr[i]);
    }
    result[0] = deque.getFirst();
    for (int i = 1; i <= arr.length - k; i++) {
      if (arr[i - 1] == deque.getFirst()) {
        deque.removeFirst();
      }
      int r = k + i - 1;
      while (!deque.isEmpty() && deque.peekLast() < arr[r]) {
        deque.removeLast();
      }
      deque.addLast(arr[r]);
      result[i] = deque.getFirst();
    }
    return result;
  }

  @Deprecated
  private static int[] getMaxiumInGivenSlidingWindowBruteForce(int[] arr, int k) {
    int[] result = new int[arr.length - k + 1];
    int max = 0;
    for (int i = 0; i < k; i++) {
      max = Math.max(max, arr[i]);
    }
    result[0] = max;
    for (int i = 1; i <= arr.length - k; i++) {
      max = Integer.MIN_VALUE;
      for (int j = i; j < i + k; j++) {
        max = Math.max(max, arr[j]);
      }
      result[i] = max;
    }
    return result;
  }
}
