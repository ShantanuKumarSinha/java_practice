package shann.java.problems.linkedList.singleLinkedList.operate;
/*
* Problem Description
You are given A which is the head of a linked list. Also given is the value B and position C. Complete the function that should insert a new node with the said value at the given position.

Notes:

In case the position is more than length of linked list, simply insert the new node at the tail only.
In case the pos is 0, simply insert the new node at head only.
Follow 0-based indexing for the node numbering.


Problem Constraints
0 <= size of linked list <= 105

1 <= value of nodes <= 109

1 <= B <= 109

0 <= C <= 105



Input Format
The first argument A is the head of a linked list.

The second argument B is an integer which denotes the value of the new node

The third argument C is an integer which denotes the position of the new node



Output Format
Return the head of the linked list


Example Input
Input 1:
A = 1 -> 2
B = 3
C = 0
Input 2:
A = 1 -> 2
B = 3
C = 1


Example Output
Output 1:
3 -> 1 -> 2
Output 2:
1 -> 3 -> 2


Example Explanation
For Input 1:
The new node is add to the head of the linked list
For Input 2:
The new node is added after the first node of the linked list
* */

import shann.java.problems.linkedList.singleLinkedList.utility.LinkedListUtilityClass;
import shann.java.problems.linkedList.singleLinkedList.utility.Node;

public class InsertIntoLinkedList {
  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(5);
    head.next.next.next.next = new Node(6);
    var result = insertIntoLinkedList(head, 4, 3);
//    Node head = new Node(7);
//    var result =  insertIntoLinkedList(head, 5 ,2);
    LinkedListUtilityClass.printValueFromLinkedList(result);
  }


  public static Node insertIntoLinkedList(Node head, int val, int index) {
    Node nn = new Node(val);
    if(head == null) {
      return nn;
    }
    if (index == 0) {
      nn.next = head;
      head = nn;
      return head;
    }
    int i =0;
    Node tmp = head;
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

  private static int findSize(Node node) {
    int size = 0;
    while (node != null) {
      node = node.next;
      size++;
    }
    return size;
  }
}
