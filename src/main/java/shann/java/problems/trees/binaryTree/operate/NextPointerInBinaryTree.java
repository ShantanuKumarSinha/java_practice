package shann.java.problems.trees.binaryTree.operate;

import java.util.LinkedList;
import java.util.Queue;
import shann.java.problems.trees.utility.TreeLinkNode;

/*
Problem Description

Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format

First and only argument is head of the binary tree A.



Output Format

Return the head of the binary tree after the changes are made.



Example Input

Input 1:


     1
    /  \
   2    3
Input 2:


        1
       /  \
      2    5
     / \  / \
    3  4  6  7


Example Output

Output 1:


        1 -> NULL
       /  \
      2 -> 3 -> NULL
Output 2:


         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL


Example Explanation

Explanation 1:

Next pointers are set as given in the output.
Explanation 2:

Next pointers are set as given in the output.
*/
public class NextPointerInBinaryTree {
  public static void main(String[] args) {
    TreeLinkNode root = new TreeLinkNode(1);
    root.left = new TreeLinkNode(2);
    root.left.left = new TreeLinkNode(3);
    root.left.right = new TreeLinkNode(4);
    root.right = new TreeLinkNode(5);
    root.right.left = new TreeLinkNode(6);
    root.right.right = new TreeLinkNode(7);

    NextPointerInBinaryTree nextPointerInBinaryTree = new NextPointerInBinaryTree();
    nextPointerInBinaryTree.setNextPointers(root);
    var temp = root;
    while (temp != null) {
      System.out.println(temp);
      if (temp.next == null) temp = temp.left == null ? temp.right : temp.left;
      else temp = temp.next;
    }
  }

  public void setNextPointers(TreeLinkNode root) {
    Queue<TreeLinkNode> queue = new LinkedList<>();
    queue.add(root);
    int size = queue.size();
    while (!queue.isEmpty()) {
      var temp = queue.poll();
      size--;
      if (size == 0) temp.next = null;
      else temp.next = queue.peek();
      if (temp.left != null) queue.add(temp.left);
      if (temp.right != null) queue.add(temp.right);
      if (size == 0) {
        size = queue.size();
      }
    }
  }

  public void printTreeLinkNodes(TreeLinkNode root) {}
}
