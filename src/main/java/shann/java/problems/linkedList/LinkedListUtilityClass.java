package shann.java.problems.linkedList;

public class LinkedListUtilityClass {
    public static void printValueFromLinkedList(ListNode linkedList) {
        while (linkedList != null) {
            if (linkedList.next == null) System.out.print(linkedList.val);
            else System.out.print(linkedList.val + " ");
            linkedList = linkedList.next;
        }
    }
}
