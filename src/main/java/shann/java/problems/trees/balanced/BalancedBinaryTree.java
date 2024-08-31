package shann.java.problems.trees.balanced;

import shann.java.problems.trees.utility.TreeNode;

/*
* Problem Description
Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the root of the tree A.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input
Input 1:

    1
   / \
  2   3
Input 2:


       1
      /
     2
    /
   3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

It is a complete binary tree.
Explanation 2:

Because for the root node, left subtree has depth 2 and right subtree has depth 0.
Difference = 2 > 1.
* */
public class BalancedBinaryTree {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.left.left = new TreeNode(3);

    TreeNode root3 = new TreeNode(1);
    root3.left = new TreeNode(2);
    root3.right = new TreeNode(3);
    root3.left.left = new TreeNode(4);
    root3.left.right = new TreeNode(5);
    root3.left.left.left = new TreeNode(6);

    TreeNode root4 = new TreeNode(6);
    root4.left = new TreeNode(9);
    root4.right = new TreeNode(4);
    root4.right.left = new TreeNode(8);
    root4.right.left.right = new TreeNode(3);

    BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
    System.out.println(balancedBinaryTree.isBalanced(root1));
    System.out.println(balancedBinaryTree.isBalanced(root2));
    System.out.println(balancedBinaryTree.isBalanced(root3));
    System.out.println(balancedBinaryTree.isBalanced(root4));
  }

  private boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    var leftHeight = root.left == null ? 0 : getHeight(root.left);
    var rightHeight = root.right == null ? 0 : getHeight(root.right);
    if (Math.abs(leftHeight - rightHeight) > 1) return false;
    return isBalanced(root.left) && isBalanced(root.right);
  }

  private int getHeight(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    var leftHeight = getHeight(root.left);
    var rightHeight = getHeight(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
