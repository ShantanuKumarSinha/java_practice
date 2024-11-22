package shann.java.problems.trees.binaryTree.balanced.create;

import shann.java.problems.trees.utility.TreeNode;
import shann.java.problems.trees.utility.TreeUtility;

/*
 Problem Description
Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the preorder traversal of the tree.

Second argument is an integer array B denoting the inorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:

 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]


Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1
  / \
 6   2
    /
   3


Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.
*/
public class BinaryTreeFromInOrderAndPreOrderTraversal {
  private static int firstIndexInPostOrder = 0;

  public static void main(String[] args) {

    int[] preOrder = {1, 6, 2, 3};
    int[] inOrder = {6, 1, 3, 2};
    //    int[] preOrder = {1, 2, 3};
    //    int[] inOrder = {2, 1, 3};
    firstIndexInPostOrder = 0;
    var result = buildTree(preOrder, inOrder,0, inOrder.length - 1);
    System.out.println(TreeUtility.postOrderTraversal(result));
  }

  public static TreeNode buildTree(int[] preOrder, int[] inOrder, int start, int end) {
    if (start > end) {
      return null;
    }
    TreeNode root = new TreeNode(preOrder[firstIndexInPostOrder++]);
    int rootIndex = 0;

    for (int i = start; i <= end; i++) {
      if (root.val == inOrder[i]) {
        rootIndex = i;
        break;
      }
    }
    root.left = buildTree(preOrder, inOrder, start, rootIndex - 1);
    root.right = buildTree(preOrder, inOrder, rootIndex + 1, end);
    return root;
  }
}
