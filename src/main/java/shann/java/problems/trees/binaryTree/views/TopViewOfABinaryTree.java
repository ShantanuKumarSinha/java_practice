package shann.java.problems.trees.binaryTree.views;

import java.util.*;
import shann.java.problems.trees.utility.TreeNode;

/*
* feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

Return the nodes in any order.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the top view of the binary tree.



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

 [1, 2, 4, 8, 3, 7]
Output 2:

 [1, 2, 3]


Example Explanation
Explanation 1:

Top view is described.
Explanation 2:

Top view is described.
* */
public class TopViewOfABinaryTree {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);
    root1.right.left = new TreeNode(6);
    root1.right.right = new TreeNode(7);
    root1.left.left.left = new TreeNode(8);
    System.out.println(topViewOfBinaryTree(root1));
  }

  public static List<Integer> topViewOfBinaryTree(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<Pair> deque = new ArrayDeque<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    deque.push(new Pair(0, root));
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    while (!deque.isEmpty()) {
      var pair = deque.pollFirst();
      min = Math.min(min, pair.level);
      max = Math.max(max, pair.level);

      map.computeIfAbsent(pair.level, k -> new ArrayList<>()).add(pair.node.val);
      if (pair.node.left != null) deque.push(new Pair(pair.level - 1, pair.node.left));
      if (pair.node.right != null) deque.push(new Pair(pair.level + 1, pair.node.right));
    }
    for (int i = 0; i >= min; i--) {
      result.add(map.get(i).get(0));
    }
    for (int i = 1; i <= max; i++) {
      result.add(map.get(i).get(0));
    }
    return result;
  }

  static class Pair {
    TreeNode node;
    int level;

    public Pair(int level, TreeNode node) {
      this.level = level;
      this.node = node;
    }
  }
}
