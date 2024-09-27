package shann.java.problems.linkedList.singleLinkedList.middle;

import shann.java.problems.linkedList.singleLinkedList.utility.Node;

/*
Problem Description
Given a linked list of integers, find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.



Problem Constraints
1 <= length of the linked list <= 100000

1 <= Node value <= 109



Input Format
The only argument given head pointer of linked list.



Output Format
Return the middle element of the linked list.



Example Input
Input 1:

 1 -> 2 -> 3 -> 4 -> 5
Input 2:

 1 -> 5 -> 6 -> 2 -> 3 -> 4


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 The middle element is 3.
Explanation 2:

 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
* */
public class FirstMiddleOfALinkedList {
  public static void main(String[] args) {
    Node head1 = new Node(1);
    head1.next = new Node(2);
    head1.next.next = new Node(3);
    head1.next.next.next = new Node(4);
    head1.next.next.next.next = new Node(5);
    var mid1 = middleNode(head1);
    System.out.println(mid1.val);
    Node head2 = new Node(1);
    head2.next = new Node(5);
    head2.next.next = new Node(6);
    head2.next.next.next = new Node(2);
    head2.next.next.next.next = new Node(3);
    head2.next.next.next.next.next = new Node(4);
    var mid2 = middleNode(head2);
    System.out.println(mid2.val);
  }

  private static Node middleNode(Node head) {
    Node slow = head;
    Node fast = head;
    // for even number this will return n/2+1
    // use fast.next!=null && fast.next.next !=null for n/2 th value
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
