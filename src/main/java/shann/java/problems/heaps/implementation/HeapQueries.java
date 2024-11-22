package shann.java.problems.heaps.implementation;

/*
Problem Description

You have an empty min heap. You are given an array A consisting of N queries. Let P denote A[i][0] and Q denote A[i][1]. There are two types of queries:

P = 1, Q = -1 : Pop the minimum element from the heap.
P = 2, 1 <= Q <= 109 : Insert Q into the heap.

Return an integer array containing the answer for all the extract min operation. If the size of heap is 0, then extract min should return -1.



Problem Constraints

1 <= N <= 105

1 <= A[i][0] <= 2

1 <= A[i][1] <= 109 or A[i][1] = -1



Input Format

The only argument A is a 2D integer array



Output Format

Return an integer array



Example Input

Input 1:

A = [[1, -1], [2, 2], [2, 1], [1, -1]]
Input 2:

A = [[2, 5], [2, 3], [2, 1], [1, -1], [1, -1]]


Example Output

Output 1:

[-1, 1]
Output 2:

[1, 3]


Example Explanation

Explanation 1:

For the first extract operation the heap is empty so it gives -1. For the second extract operation the heap contains the elements 2 and 1. Extract min returns the element 1.
Explanation 2:

The heap contains the elements 5, 3 and 1. The first extract min operation gets the element 1 and the second operation gets the element 3.
*/
public class HeapQueries {
  private int heapIndex =-1;
  public static void main(String[] args) {
//    int[][] operationAndValue = {{1, -1}, {2, 2}, {2, 1}, {1, -1}};
//    int[][] operationAndValue = {{2,5}, {2, 3}, {2, 1}, {1, -1}, {1, -1}};
    int[][] operationAndValue = {{2,17}, {2, 13}, {2, 10}};
    //         p = operationAndValue[0];
    //         q = operationAndValue[1];
    //        if p =1 and q =-1 remove min from heap;
    //        if p >1 and q>1 add q in heap;
    HeapQueries heapQueries = new HeapQueries();
    int[] heap = new int[operationAndValue.length];
    for (int i = 0; i < operationAndValue.length; i++) {
      if (operationAndValue[i][0] == 1 && operationAndValue[i][1] == -1) {
        var removedItem = heapQueries.removeMinFromHeap(heap);
        System.out.println(removedItem);
      } else if (operationAndValue[i][0] > 1 && operationAndValue[i][1] > 0) {
        heapQueries.insertIntoHeap(heap, operationAndValue[i][1]);
      }
    }
  }

  private void insertIntoHeap(int[] heap, int value) {
    if (heapIndex == -1) {
      heap[++heapIndex] = value;
      return;
    }
    heap[++heapIndex] = value;
    reverseHeapfiy(heap, heapIndex );
  }

  private void reverseHeapfiy(int[] heap, int i) {
    while (i > 0) {
      if (heap[(i - 1) / 2] > heap[i]) {
        swap(heap, i, (i-1 )/ 2 );
        i = (i - 1) / 2;
      } else break;
    }
  }

  private int removeMinFromHeap(int[] heap) {
    if (heapIndex== -1) return -1;
    swap(heap, 0, heapIndex);
    var min = heap[heapIndex];
    heap[heapIndex--] = 0;
    heapify(heap, 0);
    return min;
  }

  private void heapify(int[] heap, int i) {
    while (2 * i + 1 <= heapIndex) {
      var minChild =
          2 * i + 2 <= heapIndex ? Math.min(heap[2 * i + 1], heap[2 * i + 2]) : heap[2 * i + 1];
      var min = Math.min(heap[i], minChild);
      if (min == heap[i]) break;
      else if (min == heap[2 * i + 1]) {
        swap(heap, i, 2 * i + 1);
        i = 2 * i + 1;
      } else {
        swap(heap, i, 2 * i + 2);
        i = 2 * i + 2;
      }
    }
  }

  private void swap(int[] heap, int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }
}
