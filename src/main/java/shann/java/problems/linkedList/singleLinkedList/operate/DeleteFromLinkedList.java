package shann.java.problems.linkedList.singleLinkedList.operate;

import shann.java.problems.linkedList.singleLinkedList.utility.LinkedListUtilityClass;
import shann.java.problems.linkedList.singleLinkedList.utility.Node;

/*
* Problem Description
You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.

Note : Follow 0-based indexing for the node numbering.



Problem Constraints
1 <= size of linked list <= 105
1 <= value of nodes <= 109
0 <= B < size of linked list



Input Format
The first argument A is the head of a linked list.

The second arguement B is an integer.



Output Format
Return the head of the linked list after deletion



Example Input
Input 1:
A = 1 -> 2 -> 3
B = 1
Input 2:
A = 4 -> 3 -> 2 -> 1
B = 0


Example Output
Output 1:
1 -> 3
Output 2:
3 -> 2 -> 1


Example Explanation
For Input 1:
The linked list after deletion is 1 -> 3.
For Input 2:
The linked list after deletion is 3 -> 2 -> 1.
* */
public class DeleteFromLinkedList {
    public static void main(String[] args){
//        Node head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(3);
//        head.next.next.next = new Node(6);
//        head.next.next.next.next = new Node(4);
//        head.next.next.next.next.next = new Node(5);
        Node head = new Node(16);
        head.next = new Node(3);
        head.next.next = new Node(3);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = new Node(17);
        head.next.next.next.next.next.next.next = new Node(13);
        head.next.next.next.next.next.next.next.next = new Node(7);

        var result = deleteNode(head,1);
        LinkedListUtilityClass.printValueFromLinkedList(result);
    }
    public static Node deleteNode(Node head, int index) {
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
