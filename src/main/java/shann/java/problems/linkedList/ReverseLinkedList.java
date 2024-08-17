package shann.java.problems.linkedList;

public class ReverseLinkedList {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    var reversedLinkedList = reverseTheLinkedList(head);
    LinkedListUtilityClass.printValueFromLinkedList(reversedLinkedList);
  }

  protected static ListNode reverseTheLinkedList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}

// Definition for singly-linked list.
class ListNode {
  public int val;
  public ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}
