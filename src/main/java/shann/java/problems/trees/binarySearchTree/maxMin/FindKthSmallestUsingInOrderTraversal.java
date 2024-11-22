package shann.java.problems.trees.binarySearchTree.maxMin;
/*
Problem Description

Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format

First and only argument is head of the binary tree A.



Output Format

Return an integer, representing the Bth element.



Example Input

Input 1:


            2
          /   \
         1    3
B = 2
Input 2:


            3
           /
          2
         /
        1
B = 1



Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

2nd element is 2.
Explanation 2:

1st element is 1.
*/
import java.util.ArrayList;
import java.util.List;
import shann.java.problems.trees.utility.TreeNode;

public class FindKthSmallestUsingInOrderTraversal {
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(3);

    TreeNode root2 = new TreeNode(3);
    root2.left = new TreeNode(2);
    List<TreeNode> list = new ArrayList<>();

    FindKthSmallestUsingInOrderTraversal findKthSmallestUsingInOrderTraversal =
        new FindKthSmallestUsingInOrderTraversal();
    findKthSmallestUsingInOrderTraversal.inOrderTraversal(root1, list);
    int k =2;
    // finding kth smallest
    System.out.println(list.get(k));
  }

  public void inOrderTraversal(TreeNode root, List<TreeNode> list) {
    if (root == null) return;
    inOrderTraversal(root.left, list);
    list.add(root);
    inOrderTraversal(root.right, list);
  }
}
