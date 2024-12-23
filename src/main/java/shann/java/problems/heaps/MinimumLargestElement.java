package shann.java.problems.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Problem Description

Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.







Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.









Problem Constraints

1 <= N <= 104
0 <= B <= 104
1 <= A[i] <= 104



Input Format

The first argument is an integer array A.
The second argument is an integer B.



Output Format

Return an integer denoting the minimum possible largest element after B operations.



Example Input

Input 1:

 A = [1, 2, 3, 4]
 B = 3
Input 2:

 A = [5, 1, 4, 2]
 B = 5


Example Output

Output 1:

 4
Output 2:

 5


Example Explanation

Explanation 1:

 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.
Explanation 2:

 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5.

*/
public class MinimumLargestElement {
  public static void main(String[] args) {
    int[] input1 = {15, 20,5};
    int numberOfOperations = 8;
    MinimumLargestElement minimumLargestElement = new MinimumLargestElement();
    System.out.println(minimumLargestElement.findMinimumLargesr(input1, numberOfOperations));
  }

  private int findMinimumLargesr(int[] inputs, int numberOfOperations) {
    int[] state = Arrays.copyOf(inputs, inputs.length);
    PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1,p2)->p1.value-p2.value);
    for (int i = 0; i < inputs.length; i++) {
      minHeap.add(new Pair(i,inputs[i]*2));
    }
    for (int i = 0; i < numberOfOperations; i++) {
      Pair pair = minHeap.poll();
      state[pair.key]=pair.value;
      pair.value += inputs[pair.key];
      minHeap.add(pair);
    }
    int minLargest = Integer.MIN_VALUE;
    for (int i = 0; i < state.length; i++) {
      minLargest = Math.max(minLargest, state[i]);
    }
    return minLargest;
  }
}
class Pair{
  int key;
  int value;
  Pair(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
