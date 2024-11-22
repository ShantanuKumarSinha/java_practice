package shann.java.problems.trees.binaryTree.operate;

import shann.java.problems.trees.utility.TreeNode;

/*
Problem Description

Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in the tree.



Problem Constraints

0 <= N <= 105



Input Format

First and only Argument represents the root of binary tree A.



Output Format

Return an single integer denoting the diameter of the tree.



Example Input

Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output

Output 1:

 3
Output 2:

 4


Example Explanation

Explanation 1:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
*/
// TODO
public class DiameterOfABinaryTree {
  private int diameter = 0;

  public static void main(String[] args) {
    DiameterOfABinaryTree diameterOfABinaryTree = new DiameterOfABinaryTree();

    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);
    root1.right.right = new TreeNode(6);
    diameterOfABinaryTree.diameter = 0;
    diameterOfABinaryTree.heightOfBinaryTree(root1);
    System.out.println(diameterOfABinaryTree.diameter);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(3);
    root2.right.left = new TreeNode(4);
    root2.right.left.right = new TreeNode(5);
    diameterOfABinaryTree.diameter = 0;
    diameterOfABinaryTree.heightOfBinaryTree(root2);
    System.out.println(diameterOfABinaryTree.diameter);
  }

  // travel and change method
  public int heightOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    int left = heightOfBinaryTree(root.left);
    int right = heightOfBinaryTree(root.right);
    diameter = Math.max(diameter, left + right + 2);
    return Math.max(left, right) + 1;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    var left = getHeight(root.left);
    var right = getHeight(root.right);
    var maxDiameterChild =
        Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
    return Math.max(maxDiameterChild, left + right + 2);
  }

  public int getHeight(TreeNode root) {
    if (root == null) return -1;
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return Math.max(left, right) + 1;
  }
}
