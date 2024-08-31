package shann.java.problems.trees.bst;

/*
* Problem Description
Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.


Problem Constraints
1 <= Number of nodes in binary tree <= 105

0 <= B <= 106



Input Format
First argument is a root node of the binary tree, A.

Second argument is an integer B.



Output Format
Return 1 if such a node exist and 0 otherwise



Example Input
Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 16
Input 2:

            8
           / \
          6  21
         / \
        1   7

     B = 9


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Node with value 16 is present.
Explanation 2:

 There is no node with value 9.
* */

import shann.java.problems.trees.utility.TreeNode;

public class SearchInBST {
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(15);
    root1.left = new TreeNode(12);
    root1.right = new TreeNode(20);
    root1.left.left = new TreeNode(10);
    root1.left.right = new TreeNode(14);
    root1.right.left = new TreeNode(16);
    root1.right.right = new TreeNode(27);
    System.out.println(binarySearchInTree(root1, 16));

    TreeNode root2 = new TreeNode(8);
    root2.left = new TreeNode(6);
    root2.right = new TreeNode(21);
    root2.left.left = new TreeNode(1);
    root2.left.right = new TreeNode(7);
    System.out.println(binarySearchInTree(root2, 9));

  }

  private static int binarySearchInTree(TreeNode root, int val) {
    if (root == null) return 0;
    else if (root.val == val) return 1;
    else if (val < root.val) {
      return binarySearchInTree(root.left, val);
    } else return binarySearchInTree(root.right, val);
  }
}
