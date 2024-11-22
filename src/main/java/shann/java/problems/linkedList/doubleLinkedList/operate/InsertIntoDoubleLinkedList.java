package shann.java.problems.linkedList.doubleLinkedList.operate;

import shann.java.problems.linkedList.doubleLinkedList.utility.DoubelLinkedListUtilityClass;
import shann.java.problems.linkedList.doubleLinkedList.utility.ListNode;

// Insert Just Before  Tail in Double Linked List
public class InsertIntoDoubleLinkedList {
  public static void main(String[] args) {
    var head = new ListNode(10);
    head.next = new ListNode(20);
    head.next.prev = head;
    head.next.next = new ListNode(30);
    head.next.next.prev = head.next;
    head.next.next.next = new ListNode(50);
    head.next.next.next.prev = head.next.next;
    var tail = head.next.next.next;
    insertIntoLinkedList(head, tail, 40);
    DoubelLinkedListUtilityClass.printNextValuesFromDoubelLinkedListUtilityClass(head);
    DoubelLinkedListUtilityClass.printPreviousValuesFromDoubelLinkedListUtilityClass(tail);
  }

  // insert just before tail
  private static void insertIntoLinkedList(ListNode head, ListNode tail, int data) {
    var temp = tail.prev;
    tail.prev = new ListNode(data);
    tail.prev.next = tail;
    tail.prev.prev = temp;
    temp.next = tail.prev;
  }
}
