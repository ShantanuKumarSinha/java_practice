package shann.java.problems.trees.binaryTree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import shann.java.problems.trees.utility.TreeNode;

/*
* Problem Description
Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [
   [3],
   [20, 9],
   [15, 7]
 ]
Output 2:

 [
   [1]
   [2, 6]
   [3]
 ]

* */
// TODO
public class ZigZagLevelOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(14);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(zigZagLevelOrder(root));
  }

  private static List<List<Integer>> zigZagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.addLast(root);
    int levelChangeAtZero = deque.size(), level = 0;

    List<Integer> list = new ArrayList<>();
    while (!deque.isEmpty()) {

      var node = deque.removeLast();
      levelChangeAtZero--;
      list.add(node.val);
//      if (level % 2 == 0) {
//        if (node.right != null) deque.addLast(node.right);
//        if (node.left != null) deque.addLast(node.left);
//      } else {
        if (node.left != null) deque.addLast(node.left);
        if (node.right != null) deque.addLast(node.right);
//      }

      if (levelChangeAtZero == 0) {
        result.add(list);
        list = new ArrayList<>();
        level++;
        levelChangeAtZero = deque.size();
      }
    }
    return result;
  }
}
