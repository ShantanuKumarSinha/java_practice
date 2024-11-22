package shann.java.problems.trees.binarySearchTree.leastCommonAncestor;

import shann.java.problems.trees.utility.TreeNode;

/*
Problem Description

Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.


Note 1 :- It is guaranteed that the nodes B and C exist.

Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.



Problem Constraints

1 <= Number of nodes in binary tree <= 105

1 <= B , C <= 105



Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.




Output Format

Return the LCA of the two nodes



Example Input

Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 8
     C = 20
Input 2:

            8
           / \
          6  21
         / \
        1   7

     B = 7
     C = 1


Example Output

Output 1:

 15
Output 2:

 6
*/
public class LeastCommonAncestor {
  public static void main(String[] args) {
    LeastCommonAncestor lca = new LeastCommonAncestor();

    TreeNode root1 = new TreeNode(15);
    root1.left = new TreeNode(12);
    root1.right = new TreeNode(20);
    root1.left.left = new TreeNode(10);
    root1.left.right = new TreeNode(14);
    root1.right.left = new TreeNode(16);
    root1.right.right = new TreeNode(27);
    root1.left.left.left = new TreeNode(8);

    var ans1 = lca.findLowestCommonAncestor(root1, 8, 20);
    System.out.println(ans1);

    TreeNode root2 = new TreeNode(19);
    root2.left = new TreeNode(7);
    root2.right = new TreeNode(26);
    root2.left.left = new TreeNode(4);
    root2.left.right = new TreeNode(15);
    root2.right.left = new TreeNode(24);
    root2.right.right = new TreeNode(36);
    root2.left.left.left = new TreeNode(2);

    var ans2 = lca.findLowestCommonAncestor(root2, 4, 2);
    System.out.println(ans2);
  }

  private int findLowestCommonAncestor(TreeNode treeNode, int num1, int num2) {
    if(num1>num2)
      return findLowestCommonAncestor(treeNode, num2, num1);
    if (treeNode.val >= num1 && treeNode.val <= num2) {
      return treeNode.val;
    } else if (treeNode.val > num1 && treeNode.val > num2) {
      return findLowestCommonAncestor(treeNode.left, num1, num2);
    } else return findLowestCommonAncestor(treeNode.right, num1, num2);
  }
}
