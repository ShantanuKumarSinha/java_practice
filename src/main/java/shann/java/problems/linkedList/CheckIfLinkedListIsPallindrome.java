package shann.java.problems.linkedList;
/*
* Problem Description
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.



Problem Constraints
1 <= |A| <= 105



Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format
Return 0, if the linked list is not a palindrome.

Return 1, if the linked list is a palindrome.



Example Input
Input 1:

A = [1, 2, 2, 1]
Input 2:

A = [1, 3, 2]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
Explanation 2:

 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
* */

public class CheckIfLinkedListIsPallindrome {
  public static void main(String[] args) {
    Node head = new Node(8);
    head.next = new Node(6);
    head.next.next = new Node(4);
    head.next.next.next = new Node(6);
    head.next.next.next.next = new Node(8);
    var size = findSize(head);
    if (size == 1) {
      System.out.println(1);
      return;
    } else if (size == 2) {
      if (head.val == head.next.val) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
      return;
    } else if (size == 3) {
      if (head.val == head.next.next.val) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
      return;
    }
    var mid = size / 2;
    var secondHalf = findSecondfHalf(head, mid);
    var reversedSecondHalf = ReverseLinkedList.reverseTheLinkedList(secondHalf);
    for (int i = 0; i < mid; i++) {
      if (head.val != reversedSecondHalf.val) {
        System.out.println(0);
        return;
      }
      head = head.next;
      reversedSecondHalf = reversedSecondHalf.next;
    }
    System.out.println(1);
  }

  private static int findSize(Node head) {
    var size = 0;
    while (head != null) {
      head = head.next;
      size++;
    }
    return size;
  }

  private static Node findSecondfHalf(Node head, int mid) {
    int i = 0;
    while (i < mid) {
      head = head.next;
      i++;
    }
    return head;
  }

}

