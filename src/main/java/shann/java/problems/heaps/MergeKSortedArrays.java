package shann.java.problems.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Problem Description

Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.



Problem Constraints

1 <= total number of elements in given linked lists <= 100000



Input Format

The first and only argument is a list containing N head pointers.



Output Format

Return a pointer to the head of the sorted linked list after merging all the given linked lists.



Example Input

Input 1:

 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
Input 2:

 10 -> 12
 13
 5 -> 6


Example Output

Output 1:

 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
Output 2:

 5 -> 6 -> 10 -> 12 ->13


Example Explanation

Explanation 1:

 The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
Explanation 2:

 The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
*/
// TODO
public class MergeKSortedArrays {
  public static void main(String[] args) {
    MergeKSortedArrays solution = new MergeKSortedArrays();
    int[][] arr = new int[][] {{1, 10, 20}, {4, 11, 13}, {3, 8, 9}};
    var result = solution.mergeTheArrays(arr);
    System.out.println(Arrays.toString(result));
  }

  private int[] mergeTheArrays(int[][] arr) {
    PriorityQueue<Triplet> minHeap = new PriorityQueue<>();
    for (int i = 0; i < arr.length; i++) {
      minHeap.add(new Triplet(arr[i][0], 0, i));
    }
    var totalLength = 0;
    for (int i = 0; i < arr.length; i++) {
      totalLength += arr[i].length;
    }
    int[] result = new int[totalLength];
    int index = 0;
    var triplet = minHeap.poll();
    result[index++] = triplet.value;
    var firstReplacement = arr[triplet.order][++triplet.index];
    minHeap.add(new Triplet(firstReplacement, triplet.order, triplet.index));
    while (!minHeap.isEmpty()) {
      triplet = minHeap.poll();
      result[index++] = triplet.value;
      if (triplet.index < arr[triplet.order].length - 1) {
        var replacement = arr[triplet.order][++triplet.index];
        minHeap.add(new Triplet(replacement, triplet.order, triplet.index));
      }
    }
    return result;
  }

  private class Triplet implements Comparable<Triplet> {
    private int value;
    // count in array
    private int index;
    // kth number
    private int order;

    public Triplet(int value, int index, int order) {
      this.value = value;
      this.index = index;
      this.order = order;
    }

    @Override
    public int compareTo(Triplet triplet) {
      if (this.value < triplet.value) return -1;
      else if (this.value > triplet.value) return 1;
      else return 0;
    }
  }
}
