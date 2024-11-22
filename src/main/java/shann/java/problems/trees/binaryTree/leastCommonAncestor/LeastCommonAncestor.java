package shann.java.problems.trees.binaryTree.leastCommonAncestor;

import shann.java.problems.trees.utility.TreeNode;

/*
Problem Description

Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.


Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.




Problem Constraints

1 <= size of tree <= 100000

1 <= B, C <= 109



Input Format

First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.



Output Format

Return the LCA.



Example Input

Input 1:


      1
     /  \
    2    3
B = 2
C = 3
Input 2:

      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 LCA is 1.
Explanation 2:

 LCA is 2.
*/
public class LeastCommonAncestor {
  public static void main(String[] args) {
    LeastCommonAncestor lca = new LeastCommonAncestor();

    //    TreeNode root1 = new TreeNode(1);
    //    root1.left = new TreeNode(2);
    //    root1.right = new TreeNode(3);
    //    var result1 = lca.leastCommonAncestor(root1, 2, 3);
    //    System.out.println(result1.val);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(3);
    root2.left.left = new TreeNode(4);
    root2.left.right = new TreeNode(5);
    var result2 = lca.leastCommonAncestor(root2, 4, 5);
    System.out.println(result2.val);
    SearchInBinaryTree searchInBinaryTree = new SearchInBinaryTree();
    var result3 =
        searchInBinaryTree.searchInBinaryTree(root2, 4)
                && searchInBinaryTree.searchInBinaryTree(root2, 6)
            ? lca.leastCommonAncestor(root2, 5, 6)
            : -1;
    System.out.println(result3);
  }

  public TreeNode leastCommonAncestor(TreeNode root, int num1, int num2) {
    if (root == null) return null;

    if (root.val == num1 || root.val == num2) {
      return root;
    }
    var left = leastCommonAncestor(root.left, num1, num2);
    var right = leastCommonAncestor(root.right, num1, num2);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }
}
