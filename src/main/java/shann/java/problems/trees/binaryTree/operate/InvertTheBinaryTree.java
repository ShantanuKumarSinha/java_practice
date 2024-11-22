package shann.java.problems.trees.binaryTree.operate;

import shann.java.problems.trees.utility.TreeNode;
import shann.java.problems.trees.utility.TreeUtility;

/*
Problem Description

Given a binary tree A, invert the binary tree and return it.

Inverting refers to making the left child the right child and vice versa.



Problem Constraints

1 <= size of tree <= 100000



Input Format

First and only argument is the head of the tree A.



Output Format

Return the head of the inverted tree.



Example Input

Input 1:


     1
   /   \
  2     3
Input 2:


     1
   /   \
  2     3
 / \   / \
4   5 6   7


Example Output

Output 1:


     1
   /   \
  3     2
Output 2:


     1
   /   \
  3     2
 / \   / \
7   6 5   4
*/
public class InvertTheBinaryTree {
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);
    root1.right.left = new TreeNode(6);
    root1.right.right = new TreeNode(7);
    InvertTheBinaryTree invertTheBinaryTree = new InvertTheBinaryTree();
//    invertTheBinaryTree.invertTree(root1);
//    var preOrderTraversalList1 = TreeUtility.preOrderTraversal(root1);
//    System.out.println(preOrderTraversalList1);
//    var postOrderTraversalList1 = TreeUtility.postOrderTraversal(root1);
//    System.out.println(postOrderTraversalList1);

    var ans = invertTheBinaryTree.invertTree2(root1);
    System.out.println(TreeUtility.preOrderTraversal(ans));
    System.out.println(TreeUtility.postOrderTraversal(ans));
  }

  // preOrderTraversal we can do same in post order traversal also
  public void invertTreeInPreOrderTravsersal(TreeNode root) {
    if (root == null) return;
    var temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTreeInPreOrderTravsersal(root.left);
    invertTreeInPreOrderTravsersal(root.right);
  }

  //post order traversal also
  public void invertTreeInPostOrderTravsersal(TreeNode root) {
    if (root == null) return;
    invertTreeInPostOrderTravsersal(root.left);
    invertTreeInPostOrderTravsersal(root.right);
    var temp = root.left;
    root.left = root.right;
    root.right = temp;
  }
  // recurrsive call
  public TreeNode invertTree2(TreeNode root) {
    if (root == null) return null;
    var temp = invertTree2(root.left);
    root.left = invertTree2(root.right);
    root.right = temp;
    return root;
  }
}
