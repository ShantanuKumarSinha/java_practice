package shann.java.problems.trees.binaryTree.views;

import shann.java.problems.trees.utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
 Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the right view of the binary tree.



Example Input
Input 1:


            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Input 2:


            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
Output 1:

 [1, 2, 4, 8]
Output 2:

 [1, 2, 4, 5]


Example Explanation
Explanation 1:

Right view is described.
Explanation 2:

Right view is described.
*/
public class LeftViewOfABinaryTree {
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);
    root1.right.left = new TreeNode(6);
    root1.right.right = new TreeNode(7);
    root1.left.left.left = new TreeNode(8);
    var result1 = leftViewOfBinaryTree(root1);
    System.out.println(result1);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(3);
    root2.left.right = new TreeNode(4);
    root2.left.right.right = new TreeNode(5);
    var result2 = leftViewOfBinaryTree(root2);
    System.out.println(result2);
  }

  private static ArrayList<Integer> leftViewOfBinaryTree(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    var levelCount = deque.size();
    result.add(root.val);
    while (!deque.isEmpty()) {
      TreeNode node = deque.poll();
      levelCount--;
      if (node.left != null) {
        deque.addLast(node.left);
      }
      if (node.right != null) {
        deque.addLast(node.right);
      }
      if (levelCount == 0) {
        levelCount = deque.size();
        if (!deque.isEmpty()) result.add(deque.peek().val);
      }
    }

    return result;
  }
}
