package shann.java.problems.linkedList;

public class DeleteFromLinkedList {
    public static void main(String[] args){
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(6);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
        ListNode head = new ListNode(16);
        head.next = new ListNode(3);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next = new ListNode(17);
        head.next.next.next.next.next.next.next = new ListNode(13);
        head.next.next.next.next.next.next.next.next = new ListNode(7);

        var result = deleteNode(head,1);
        LinkedListUtilityClass.printValueFromLinkedList(result);
    }
    public static ListNode deleteNode(ListNode head, int index) {
        var tmp = head;
        if(head == null)
            return null;
        if(index ==0)
            return head.next;
        int i =0;
        while(tmp != null){
            if(i == index-1){
                tmp.next = tmp.next.next;
                return head;
            }
            tmp = tmp.next;
            i++;
        }
        return head;
    }
}
