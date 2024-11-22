package shann.java.problems.linkedList.doubleLinkedList.operate;

import static shann.java.problems.linkedList.doubleLinkedList.utility.DoubelLinkedListUtilityClass.printNextValuesFromDoubelLinkedListUtilityClass;
import static shann.java.problems.linkedList.doubleLinkedList.utility.DoubelLinkedListUtilityClass.printPreviousValuesFromDoubelLinkedListUtilityClass;

import shann.java.problems.linkedList.doubleLinkedList.utility.ListNode;

public class DeleteFromDoubleLinkedList {

  public static void main(String[] args) {
    var head = new ListNode(10);
    head.next = new ListNode(20);
    head.next.prev = head;
    head.next.next = new ListNode(25);
    head.next.next.prev = head.next;
    head.next.next.next = new ListNode(30);
    head.next.next.next.prev = head.next.next;
    var tail = head.next.next.next;
    deleteFromDoubleLinkedList(head, head.next.next);
    printNextValuesFromDoubelLinkedListUtilityClass(head);
    printPreviousValuesFromDoubelLinkedListUtilityClass(tail);
  }

  private static void deleteFromDoubleLinkedList(ListNode head, ListNode target) {
    var prev = target.prev;
    var next = target.next;
    prev.next = next;
    next.prev = prev;
    target.next = null;
    target.prev = null;
  }
}
