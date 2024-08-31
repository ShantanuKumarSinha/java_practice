package shann.java.problems.trees.traversal;

import shann.java.problems.trees.utility.TreeNode;

import java.util.*;

/*
* Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
0 <= number of nodes <= 105



Input Format
First and only arument is a pointer to the root node of binary tree, A.



Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output
Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation
Explanation 1:

 First row represent the verical line 1 and so on.
* */
public class VerticalOrderTraversal {
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(6);
    root1.left = new TreeNode(3);
    root1.right = new TreeNode(7);
    root1.left.left = new TreeNode(2);
    root1.left.right = new TreeNode(5);
    root1.right.right = new TreeNode(9);
    var result1 = verticalOrderTraversal(root1);
    System.out.println(result1);
  }

  public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();

    Map<Integer, List<Integer>> map = new HashMap<>();
    Deque<Pair> deque = new ArrayDeque<>();
    deque.add(new Pair(0, root));
    int minLevel = Integer.MAX_VALUE, maxLevel = Integer.MIN_VALUE;

    while (!deque.isEmpty()) {
      var pair = deque.pollFirst();
      minLevel = Math.min(minLevel, pair.level);
      maxLevel = Math.max(maxLevel, pair.level);
      map.computeIfAbsent(pair.level, k -> new ArrayList<>()).add(pair.node.val);
      if (pair.node.left != null) deque.add(new Pair(pair.level - 1, pair.node.left));
      if (pair.node.right != null) deque.add(new Pair(pair.level + 1, pair.node.right));
    }

    for (int i = minLevel; i <= maxLevel; i++) {
      result.add(map.get(i));
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
