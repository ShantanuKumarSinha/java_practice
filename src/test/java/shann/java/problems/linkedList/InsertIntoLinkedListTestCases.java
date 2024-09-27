package shann.java.problems.linkedList;


import org.junit.jupiter.api.Test;
import shann.java.problems.linkedList.singleLinkedList.operate.InsertIntoLinkedList;

class InsertIntoLinkedListTestCases {
    @Test
    void testInsertIntoLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        var result1 = InsertIntoLinkedList.insertIntoLinkedList(head,4,3);

    }


}
