package shann.java.problems.linkedList;


public class CheckIfLinkedListIsPallindrome {
  public static void main(String[] args) {
    ListNode head = new ListNode(8);
    head.next = new ListNode(6);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(6);
    head.next.next.next.next = new ListNode(8);
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

  private static int findSize(ListNode head) {
    var size = 0;
    while (head != null) {
      head = head.next;
      size++;
    }
    return size;
  }

  private static ListNode findSecondfHalf(ListNode head, int mid) {
    int i = 0;
    while (i < mid) {
      head = head.next;
      i++;
    }
    return head;
  }

}

