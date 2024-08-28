package shann.java.problems.trees;

/*
Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


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
public class BinaryTreeFromInOrderAndPostOrderTraversal {
  private static int lastIndexInPostOrder = 0;

  public static void main(String[] args) {
    int[] inOrder = {4, 2, 7, 5, 1, 3, 8, 6};
    int[] postOrder = {4, 7, 5, 2, 8, 6, 3, 1};
    lastIndexInPostOrder = postOrder.length - 1;
    //    int[] inOrder = {6, 1, 3, 2};
    //    int[] postOrder = {6, 3, 2, 1};
    var result = buildTree(inOrder, postOrder, 0, inOrder.length - 1);
    System.out.println(TreeUtility.preOrderTraversal(result));
  }

  public static TreeNode buildTree(int[] inorder, int[] postorder, int start, int end) {
    if (start > end) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[lastIndexInPostOrder--]);
    int rootIndex = 0;

    for (int i = start; i <= end; i++) {
      if (root.val == inorder[i]) {
        rootIndex = i;
        break;
      }
    }
    root.right = buildTree(inorder, postorder, rootIndex + 1, end);
    root.left = buildTree(inorder, postorder, start, rootIndex - 1);
    return root;
  }
}
