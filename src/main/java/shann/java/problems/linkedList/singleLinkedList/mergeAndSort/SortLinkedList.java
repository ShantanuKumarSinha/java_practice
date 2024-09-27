package shann.java.problems.linkedList.singleLinkedList.mergeAndSort;

import shann.java.problems.linkedList.singleLinkedList.utility.LinkedListUtilityClass;
import shann.java.problems.linkedList.singleLinkedList.utility.Node;

/*
Sort a linked list, A in O(n log n) time.



Problem Constraints

0 <= |A| = 105



Input Format

The first and the only arugment of input contains a pointer to the head of the linked list, A.



Output Format

Return a pointer to the head of the sorted linked list.



Example Input

Input 1:

A = [3, 4, 2, 8]
Input 2:

A = [1]


Example Output

Output 1:

[2, 3, 4, 8]
Output 2:

[1]


Example Explanation

Explanation 1:

 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
Explanation 2:

 The sorted form of [1] is [1].
*/
public class SortLinkedList {
  public static void main(String[] args) {
    Node head = new Node(3);
    head.next = new Node(4);
    head.next.next = new Node(2);
    head.next.next.next = new Node(8);
    var sortedHead = sort(head);
    LinkedListUtilityClass.printValueFromLinkedList(sortedHead);
  }

  private static Node sort(Node head) {
    if (head == null || head.next == null) return head;
    Node slow = head;
    Node fast = head;
    while (fast.next != null && fast.next.next!= null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    var head2 = slow.next;
    slow.next = null;
    var head1 = sort(head);
    head2 = sort(head2);
    return mergeTwoLists(head1, head2);
  }

  private static Node mergeTwoLists(Node head1, Node head2) {
    if (head1 == null && head2 == null) return null;
    if (head1 == null) return head2;
    if (head2 == null) return head1;
    if (head1.val < head2.val) {
      head1.next = mergeTwoLists(head1.next, head2);
      return head1;
    } else {
      head2.next = mergeTwoLists(head1, head2.next);
      return head2;
    }
  }
}
