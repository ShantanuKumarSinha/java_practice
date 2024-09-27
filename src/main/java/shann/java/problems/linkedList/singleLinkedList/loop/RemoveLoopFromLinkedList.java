package shann.java.problems.linkedList.singleLinkedList.loop;

import shann.java.problems.linkedList.singleLinkedList.utility.LinkedListUtilityClass;
import shann.java.problems.linkedList.singleLinkedList.utility.Node;

import java.util.HashSet;
import java.util.Set;

/*
Problem Description

You are using Google Maps to help you find your way around a new place. But, you get lost and end up walking in a circle. Google Maps has a way to keep track of where you've been with the help of special sensors.These sensors notice that you're walking in a loop, and now, Google wants to create a new feature to help you figure out exactly where you started going in circles.

Here's how we can describe the challenge in simpler terms: You have a Linked List A that shows each step of your journey, like a chain of events. Some of these steps have accidentally led you back to a place you've already been, making you walk in a loop. The goal is to find out the exact point where you first started walking in this loop, and then you want to break the loop by not going in the circle just before this point.




Problem Constraints

1 <= number of nodes <= 1000



Input Format

The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
The second line of the input contains an integer which denotes the position of node where cycle starts.



Output Format

return the head of the updated linked list.



Example Input

Input 1:


1 -> 2
^    |
| - -
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |
          - - - - - -


Example Output

Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation

Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.
*/
public class RemoveLoopFromLinkedList {
  public static void main(String[] args) {

    Node head1 = new Node(3);
    head1.next = new Node(2);
    head1.next.next = new Node(4);
    head1.next.next.next = new Node(5);
    head1.next.next.next.next = new Node(6);
    head1.next.next.next.next.next = head1.next.next;
    var result1 = hasCycle(head1) ? removeLoop(head1) : head1;
    LinkedListUtilityClass.printValueFromLinkedList(result1);

    Node head2 = new Node(1);
    head2.next = new Node(2);
    head2.next.next = new Node(3);
    var result2 = hasCycle(head2) ? removeLoop(head2) : head2;
    LinkedListUtilityClass.printValueFromLinkedList(result2);
  }

  private static Node removeLoop(Node head) {
    Node slow = head;
    Node fast = head;
    while (slow.next != fast.next.next) {
      slow = slow.next;
      fast = fast.next.next;
    }
    fast = fast.next.next;
    var tail = fast;
    // find the node where they meet
    slow = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    while (tail.next != fast) tail = tail.next;
    tail.next = null;
    return head;
  }

  private static boolean hasCycle(Node head) {
    Set<Node> nodeSet = new HashSet<>();
    var temp = head;
    while (temp != null) {
      if (nodeSet.add(temp)) temp = temp.next;
      else return true;
    }
    return false;
  }
}
