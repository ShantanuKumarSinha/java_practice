package shann.java.problems.trees.binaryTree.operate;

import shann.java.problems.trees.utility.TreeNode;

/*
Problem Description

Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



Problem Constraints

1 <= size of tree <= 100000




0 <= value of node <= 109



Input Format

First and only argument is head of tree A.



Output Format

Return 1 if the tree can be partitioned into two trees of equal sum else return 0.



Example Input

Input 1:


                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:


                1
               / \
              2   10
                  / \
                 20  2


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 Remove edge between 5(root node) and 7:
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:

 The given Tree cannot be partitioned.


*/
public class EqualTreePartition {
  TreeNode resultTree = null;
  private boolean subTreeWithHalfSumOfTree = false;

  public static void main(String[] args) {
    EqualTreePartition equalTreePartition = new EqualTreePartition();

    //    TreeNode root1 = new TreeNode(1);
    //    root1.left = new TreeNode(2);
    //    root1.right = new TreeNode(10);
    //    root1.right.left = new TreeNode(20);
    //    root1.right.right = new TreeNode(2);
    //
    //    var sum1 = equalTreePartition.findSum(root1);
    //    if (sum1 % 2 == 1) {
    //      System.out.println(0);
    //    } else {
    //      equalTreePartition.findSubTreeWithSumEqualsToHalfSumOfSubTree(root1, sum1);
    //      System.out.println(equalTreePartition.subTreeWithHalfSumOfTree);
    //    }
    //
    //    TreeNode root2 = new TreeNode(5);
    //    root2.left = new TreeNode(3);
    //    root2.right = new TreeNode(7);
    //    root2.left.left = new TreeNode(4);
    //    root2.left.right = new TreeNode(6);
    //    root2.right.left = new TreeNode(5);
    //    root2.right.right = new TreeNode(6);
    //
    //    var sum2 = equalTreePartition.findSum(root2);
    //
    //    if (sum2 % 2 == 1) {
    //      System.out.println(0);
    //    } else {
    //      equalTreePartition.subTreeWithHalfSumOfTree = false;
    //      equalTreePartition.findSubTreeWithSumEqualsToHalfSumOfSubTree(root2, sum2);
    //      System.out.println(equalTreePartition.subTreeWithHalfSumOfTree ? 1 : 0);
    //    }

    TreeNode root3 = new TreeNode(106);
    root3.right = new TreeNode(480);
    root3.right.left = new TreeNode(454);
    root3.right.right = new TreeNode(321);
    root3.right.right.left = new TreeNode(719);

    var sum3 = equalTreePartition.findSum(root3);

    if (sum3 % 2 == 1) {
      System.out.println(0);
    } else {
      equalTreePartition.subTreeWithHalfSumOfTree = false;
      equalTreePartition.findSubTreeWithSumEqualsToHalfSumOfSubTree(root3, sum3);
      System.out.println(equalTreePartition.subTreeWithHalfSumOfTree ? 1 : 0);
      // not required just added
      System.out.println(equalTreePartition.resultTree.val);
    }
  }

  public int findSubTreeWithSumEqualsToHalfSumOfSubTree(TreeNode root, int sum) {
    if (root == null) return 0;
    var leftSum = findSubTreeWithSumEqualsToHalfSumOfSubTree(root.left, sum);
    var rightSum = findSubTreeWithSumEqualsToHalfSumOfSubTree(root.right, sum);

    if (leftSum == sum / 2) {
      subTreeWithHalfSumOfTree = true;
      resultTree = root.left;
    } else if (rightSum == sum / 2) {
      subTreeWithHalfSumOfTree = true;
      resultTree = root.right;
    }
    return leftSum + rightSum + root.val;
  }

  public int findSum(TreeNode root) {
    if (root == null) return 0;
    return findSum(root.left) + findSum(root.right) + root.val;
  }
}
