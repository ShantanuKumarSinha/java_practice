package shann.java.problems.linkedList;


public class InsertIntoLinkedList {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = new ListNode(6);
    var result = insertIntoLinkedList(head, 4, 3);
//    ListNode head = new ListNode(7);
//    var result =  insertIntoLinkedList(head, 5 ,2);
    LinkedListUtilityClass.printValueFromLinkedList(result);
  }


  public static ListNode insertIntoLinkedList(ListNode head, int val, int index) {
    ListNode nn = new ListNode(val);
    if(head == null) {
      return nn;
    }
    if (index == 0) {
      nn.next = head;
      head = nn;
      return head;
    }
    int i =0;
    ListNode tmp = head;
    var size = findSize(head);
    if(index > size)
      index = size;
    while(i<index-1){
      tmp = tmp.next;
      i++;
    }
    nn.next = tmp.next;
    tmp.next = nn;
    return head;
  }

  private static int findSize(ListNode node) {
    int size = 0;
    while (node != null) {
      node = node.next;
      size++;
    }
    return size;
  }
}
