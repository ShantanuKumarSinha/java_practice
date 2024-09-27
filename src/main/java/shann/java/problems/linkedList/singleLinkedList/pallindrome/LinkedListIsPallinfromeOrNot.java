package shann.java.problems.linkedList.singleLinkedList.pallindrome;


import shann.java.problems.linkedList.singleLinkedList.utility.Node;

public class LinkedListIsPallinfromeOrNot {
  public static void main(String[] args) {
    Node head = new Node(6);
    head.next = new Node(3);
    head.next.next = new Node(7);
    head.next.next.next = new Node(3);
    head.next.next.next.next = new Node(6);

    System.out.println(lPalin(head));
  }

  public static int lPalin(Node head) {
    if (head.next == null) return 1;
    var slow = head;
    var fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    var secondHalf = slow.next;
    slow.next = null;
    if (secondHalf.next == null && secondHalf.val == head.val) return 1;
    var revrsedSecondHalf = reverseOfALinkedList(secondHalf);
    while (revrsedSecondHalf != null) {
      if (revrsedSecondHalf.val != head.val) return 0;
      revrsedSecondHalf = revrsedSecondHalf.next;
      head = head.next;
    }
    return 1;
  }

  private static Node reverseOfALinkedList(Node head) {
    Node prev = null;
    Node curr = head;
    while (curr != null) {
      var forward = curr.next;
      curr.next = prev;
      prev = curr;
      curr = forward;
    }
    return prev;
  }
}
