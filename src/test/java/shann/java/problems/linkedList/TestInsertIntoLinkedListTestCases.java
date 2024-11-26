package shann.java.problems.linkedList;

import org.junit.jupiter.api.Test;
import shann.java.problems.linkedList.singleLinkedList.operate.InsertIntoLinkedList;
import shann.java.problems.linkedList.singleLinkedList.utility.Node;

class TestInsertIntoLinkedListTestCases {

  @Test
  void testInsertIntoLinkedList() {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(5);
    var result1 = InsertIntoLinkedList.insertIntoLinkedList(head, 4, 3);
    assert result1 != null;
    assert result1.next != null;
    assert result1.next.next != null;
    assert result1.next.next.next != null;
    assert result1.next.next.next.next != null;
    assert result1.next.next.next.next.next == null;
    assert result1.val==1;
  }
}
