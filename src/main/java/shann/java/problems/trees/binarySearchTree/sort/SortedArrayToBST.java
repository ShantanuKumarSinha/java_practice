package shann.java.problems.trees.binarySearchTree.sort;

import shann.java.problems.trees.utility.TreeNode;

/*
* Problem Description
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= length of array <= 100000



Input Format
First argument is an integer array A.



Output Format
Return a root node of the Binary Search Tree.



Example Input
Input 1:

 A : [1, 2, 3]
Input 2:

 A : [1, 2, 3, 5, 10]


Example Output
Output 1:

      2
    /   \
   1     3
Output 2:

      3
    /   \
   2     5
  /       \
 1         10


Example Explanation
Explanation 1:

 You need to return the root node of the Binary Tree.
* */

public class SortedArrayToBST {
  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 5, 10};
    var result = sortedArrayToBST(arr1, 0, arr1.length - 1);
    System.out.println(result);
  }

  private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
    int mid = start + (end - start) / 2;
    if(mid<start || mid>end) return null;
    TreeNode root = new TreeNode(nums[mid]);
      root.left = sortedArrayToBST(nums, start, mid - 1);
      root.right = sortedArrayToBST(nums, mid + 1, end);
    return root;
  }
}
