package shann.java.problems.trees.traversal;

/*
* Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the level order traversal of the given binary tree.



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
   [9, 20],
   [15, 7]
 ]
Output 2:

 [
   [1]
   [6, 2]
   [3]
 ]

* */

import shann.java.problems.trees.utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LevelOrderTraversal {
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(6);
    root1.right = new TreeNode(2);
    root1.right.left = new TreeNode(3);
    var result1 = printLevelOrder(root1);
    System.out.println(result1);

    TreeNode root2 = new TreeNode(3);
    root2.left = new TreeNode(9);
    root2.right = new TreeNode(20);
    root2.right.left = new TreeNode(15);
    root2.right.right = new TreeNode(7);
    var result2 = printLevelOrder(root2);
    System.out.println(result2);

    TreeNode root3 = new TreeNode(1);
    root3.left = new TreeNode(2);
    root3.right = new TreeNode(3);
    root3.left.left = new TreeNode(4);
    root3.left.right = new TreeNode(5);
    root3.right.left = new TreeNode(6);
    root3.right.right = new TreeNode(7);
    root3.left.left.left = new TreeNode(8);
    root3.left.left.right = new TreeNode(9);
    root3.left.right.left = new TreeNode(10);
    root3.left.right.right = new TreeNode(11);
    root3.right.left.left = new TreeNode(12);
    root3.right.left.right = new TreeNode(13);
    root3.right.right.left = new TreeNode(14);
    root3.right.right.right = new TreeNode(15);
    var result3 = printLevelOrder(root3);
    System.out.println(result3);
  }

  public static ArrayList<ArrayList<Integer>> printLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> level = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    int levelCount = deque.size();
    while (!deque.isEmpty()) {
      var node = deque.poll();
      levelCount--;
      level.add(node.val);
      if (levelCount == 0) {
        result.add(level);
        level = new ArrayList<>();
      }
      if (node.left != null) deque.add(node.left);
      if (node.right != null) deque.add(node.right);
      if (levelCount == 0) levelCount = deque.size();
    }
    return result;
  }
}
