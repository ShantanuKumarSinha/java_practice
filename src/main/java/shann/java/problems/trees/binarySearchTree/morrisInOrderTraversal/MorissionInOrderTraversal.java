package shann.java.problems.trees.binarySearchTree.morrisInOrderTraversal;

import shann.java.problems.trees.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description

Given a binary tree, return the inorder traversal of its nodes' values.

NOTE: Using recursion and stack are not allowed.





Problem Constraints

1 <= number of nodes <= 105



Input Format

First and only argument is root node of the binary tree, A.



Output Format

Return an integer array denoting the inorder traversal of the given binary tree.



Example Input

Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output

Output 1:

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]


Example Explanation

Explanation 1:

 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:

 The Inorder Traversal of the given tree is [6, 1, 3, 2].


*/
public class MorissionInOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.right = new TreeNode(8);
    root.right.right = new TreeNode(29);
    root.right.right.left = new TreeNode(20);
    root.right.right.right = new TreeNode(32);
    root.right.right.left.left = new TreeNode(15);
    root.right.right.left.right = new TreeNode(23);
    root.right.right.left.left.left = new TreeNode(9);
    root.right.right.left.left.right = new TreeNode(17);
    root.right.right.left.left.left.right = new TreeNode(10);
    root.right.right.left.left.left.right.right = new TreeNode(13);
    root.right.right.left.left.right.right = new TreeNode(19);
    root.right.right.left.right.right = new TreeNode(25);
    root.right.right.right.right = new TreeNode(35);
    root.right.right.right.right.left = new TreeNode(33);
    root.right.right.right.right.right = new TreeNode(39);

    List<Integer> list = new ArrayList<>();
    MorissionInOrderTraversal mor = new MorissionInOrderTraversal();
    mor.inOrderTraversal(root, list);
    System.out.println(list);
  }

  public void inOrderTraversal(TreeNode root, List<Integer> list) {
    if (root == null) return;
    var curr = root;
    while (curr != null) {
      if (curr.left == null) {
        list.add(curr.val);
        curr = curr.right;
      } else {
        var temp = curr.left;
        while (temp.right != null && temp.right != curr) {
          temp = temp.right;
        }
        if (temp.right == null) {
          temp.right = curr;
          curr = curr.left;
        }
        if (temp.right == curr) {
          temp.right = null;
          list.add(curr.val);
          curr = curr.right;
        }
      }
    }
  }
}
