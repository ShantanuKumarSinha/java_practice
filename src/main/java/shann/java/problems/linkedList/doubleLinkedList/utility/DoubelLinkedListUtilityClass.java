package shann.java.problems.linkedList.doubleLinkedList.utility;

public class DoubelLinkedListUtilityClass {
  public static void printNextValuesFromDoubelLinkedListUtilityClass(ListNode linkedList) {
    while (linkedList != null) {
      if (linkedList.next == null) System.out.print(linkedList.val);
      else System.out.print(linkedList.val + " ");
      linkedList = linkedList.next;
    }
    System.out.println();
  }

  public static void printPreviousValuesFromDoubelLinkedListUtilityClass(ListNode linkedList) {
    while (linkedList != null) {
      if (linkedList.prev == null) System.out.print(linkedList.val);
      else System.out.print(linkedList.val + " ");
      linkedList = linkedList.prev;
    }
    System.out.println();
  }
}
