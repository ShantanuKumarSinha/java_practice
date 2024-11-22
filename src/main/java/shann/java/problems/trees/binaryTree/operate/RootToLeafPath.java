package shann.java.problems.trees.binaryTree.operate;

import shann.java.problems.trees.utility.TreeNode;

/*
Problem Description

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.



Problem Constraints

1 <= number of nodes <= 105

-100000 <= B, value of nodes <= 100000



Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B denoting the sum.



Output Format

Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.



Example Input

Input 1:

 Tree:    5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

 B = 22
Input 2:

 Tree:    5
         / \
        4   8
       /   / \
     -11 -13  4

 B = -1


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
Explanation 2:

 There is no path which has sum -1.



Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
*/
public class RootToLeafPath {
  public static void main(String[] args) {
    RootToLeafPath rootToLeafPath = new RootToLeafPath();
    TreeNode root1 = new TreeNode(5);
    root1.left = new TreeNode(4);
    root1.right = new TreeNode(8);
    root1.left.left = new TreeNode(11);
    root1.right.left = new TreeNode(13);
    root1.right.right = new TreeNode(4);
    root1.left.left.left = new TreeNode(7);
    root1.left.left.right = new TreeNode(2);
    root1.right.right.right = new TreeNode(1);
    int k1=22;
    var result1 = rootToLeafPath.rootToNodePathWithGivenSum(root1,k1);
    System.out.println(result1);
  }

  private boolean rootToNodePathWithGivenSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.left == null && root.right == null) return sum == root.val;
    else
      return rootToNodePathWithGivenSum(root.left, sum - root.val)
          || rootToNodePathWithGivenSum(root.right, sum - root.val);
  }
}
