package shann.java.problems.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import shann.java.problems.linkedList.singleLinkedList.utility.LinkedListUtilityClass;
import shann.java.problems.linkedList.singleLinkedList.utility.Node;

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
public class MergeKSortedArraysWithLinkedList {
  public static void main(String[] args) {
    Node head1 = new Node(1);
    head1.next = new Node(10);
    head1.next.next = new Node(20);

    Node head2 = new Node(4);
    head2.next = new Node(11);
    head2.next.next = new Node(13);

    Node head3 = new Node(3);
    head3.next = new Node(8);
    head3.next.next = new Node(9);

    var list = new ArrayList<>(List.of(head1, head2, head3));
    MergeKSortedArraysWithLinkedList mergeKSortedArraysWithLinkedList =
        new MergeKSortedArraysWithLinkedList();
    var resultList = mergeKSortedArraysWithLinkedList.mergeTheArrays(list);
    LinkedListUtilityClass.printValueFromLinkedList(resultList);
  }

  private Node mergeTheArrays(List<Node> nodeList) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>();
    for (int i = 0; i < nodeList.size(); i++) {
      var kthNode = nodeList.get(i);
      var pair = new Pair(kthNode.val, i);
      minHeap.add(pair);
    }
    var minPair = minHeap.poll();
    var listNode = new Node(minPair.value);
    var firstReplacement = nodeList.get(minPair.order).next;
    nodeList.set(minPair.order, firstReplacement);
    if (firstReplacement != null)
    minHeap.add(new Pair(firstReplacement.val, minPair.order));
    var tmp = listNode;
    while (!minHeap.isEmpty()) {
      var min = minHeap.peek();
      tmp.next = new Node(min.value);
      tmp = tmp.next;
      minHeap.poll();
      var node = nodeList.get(min.order);
      node = node.next;
      nodeList.set(min.order, node);
      if (node != null) minHeap.add(new Pair(node.val, min.order));
    }
    return listNode;
  }

  private class Pair implements Comparable<Pair> {
    private int value;
    // kth number
    private int order;

    public Pair(int value, int order) {
      this.value = value;
      this.order = order;
    }

    @Override
    public int compareTo(Pair pair) {
      if (this.value < pair.value) return -1;
      else if (this.value > pair.value) return 1;
      else return 0;
    }
  }
}
