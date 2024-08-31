package shann.java.problems.trees.bst;

/*
* Valid Binary Search Tree
Unsolved
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description
You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints
1 <= Number of nodes in binary tree <= 105

0 <= node values <= 232-1



Input Format
First and only argument is head of the binary tree A.



Output Format
Return 0 if false and 1 if true.



Example Input
Input 1:


   1
  /  \
 2    3
Input 2:


  2
 / \
1   3


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.
* */

import shann.java.problems.trees.traversal.InOrderTraversal;
import shann.java.problems.trees.utility.TreeNode;

public class ValidBinarySearchTree {
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    System.out.println(isValidBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));

    TreeNode root2 = new TreeNode(2);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(3);
    System.out.println(isValidBST(root2, Integer.MIN_VALUE, Integer.MAX_VALUE));

    TreeNode root3 = new TreeNode(4);
    root3.left = new TreeNode(2);
    root3.right = new TreeNode(6);
    root3.left.left = new TreeNode(1);
    root3.left.right = new TreeNode(3);
    root3.right.left = new TreeNode(5);
    root3.right.right = new TreeNode(7);
    System.out.println(isValidBST(root3, Integer.MIN_VALUE, Integer.MAX_VALUE));

    TreeNode root4 = new TreeNode(6);
    root4.left = new TreeNode(9);
    root4.right = new TreeNode(4);
    root4.right.left = new TreeNode(8);
    root4.right.left.right = new TreeNode(3);
    System.out.println(isValidBST(root4, Integer.MIN_VALUE, Integer.MAX_VALUE));

    TreeNode root5 = new TreeNode(13);
    root5.left = new TreeNode(10);
    root5.right = new TreeNode(17);
    root5.left.left = new TreeNode(5);
    root5.left.right = new TreeNode(14);
    root5.right.left = new TreeNode(12);
    root5.right.right = new TreeNode(18);
    System.out.println(isValidBST(root5, Integer.MIN_VALUE, Integer.MAX_VALUE));

    TreeNode root6 = new TreeNode(8);
    root6.left = new TreeNode(4);
    root6.right = new TreeNode(20);
    root6.left.left = new TreeNode(2);
    root6.left.right = new TreeNode(9);
    root6.left.left.left = new TreeNode(1);
    root6.left.left.right = new TreeNode(3);
    root6.left.right.left = new TreeNode(5);
    root6.left.right.right = new TreeNode(10);
    System.out.println(isValidBST(root6, Integer.MIN_VALUE, Integer.MAX_VALUE));
    try {
      checkBSTViaInOrderTraversal(root6);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private static boolean isValidBST(TreeNode root, int start, int end) {
    if (root == null) return true;
    if (root.val >= start && root.val <= end) {
      return isValidBST(root.left, start, root.val - 1)
          && isValidBST(root.right, root.val + 1, end);
    }
    return false;
  }

  // approach2 use inOrder Traversal

  private static boolean checkBSTViaInOrderTraversal(TreeNode root) {
    var list = InOrderTraversal.inOrderTraversal(root);
    // var sortedList = list.stream().sorted().toList();
    // compare each item of sorted list if it matches the original one
    return list.stream()
        .reduce(
            (a, b) -> {
              if (a > b) throw new RuntimeException("Not A Valid Binary Search Tree");
              else return b;
            })
        .isPresent();
  }
}
