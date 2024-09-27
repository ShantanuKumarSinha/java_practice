package shann.java.problems.linkedList.singleLinkedList.mergeAndSort;

import shann.java.problems.linkedList.singleLinkedList.utility.LinkedListUtilityClass;
import shann.java.problems.linkedList.singleLinkedList.utility.Node;

/*
Problem Description
Merge two sorted linked lists, A and B, and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists and should also be sorted.



Problem Constraints
0 <= |A|, |B| <= 105



Input Format
The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.



Output Format
Return a pointer to the head of the merged linked list.



Example Input
Input 1:

 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15
Input 2:

 A = 1 -> 2 -> 3
 B = Null


Example Output
Output 1:

 4 -> 5 -> 8 -> 11 -> 15 -> 20
Output 2:

 1 -> 2 -> 3


Example Explanation
Explanation 1:

 Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
Explanation 2:

 We don't need to merge as B is empty.
*/
public class MergeTwoSortedLists {
  public static void main(String[] args) {
    Node head1 = new Node(5);
    head1.next = new Node(8);
    head1.next.next = new Node(20);

    Node head2 = new Node(4);
    head2.next = new Node(11);
    head2.next.next = new Node(15);

    //first Way
    var head = mergeTwoLists(head1, head2);
    LinkedListUtilityClass.printValueFromLinkedList(head);
    // second way
    var headNew = merge(head1, head2);
    LinkedListUtilityClass.printValueFromLinkedList(headNew);
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

  private static Node merge(Node head1, Node head2) {
    if (head1 == null) return head2;
    if (head2 == null) return head1;
    Node head = null;
    if (head1.val < head2.val) {
      head = head1;
      head1 = head1.next;
    } else {
      head = head2;
      head2 = head2.next;
    }
    var temp = head;
    while (head1 != null && head2 != null) {
      if (head1.val < head2.val) {
        temp.next = head1;
        head1 = head1.next;
      } else {
        temp.next = head2;
        head2 = head2.next;
      }
      temp = temp.next;
    }
    if (head1 != null) temp.next = head1;

    if (head2 != null) temp.next = head2;
    return head;
  }
}
