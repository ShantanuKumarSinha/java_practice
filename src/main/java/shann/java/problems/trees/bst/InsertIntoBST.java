package shann.java.problems.trees.bst;

import shann.java.problems.trees.traversal.LevelOrderTraversal;
import shann.java.problems.trees.utility.TreeNode;

public class InsertIntoBST {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(15);
    root.left = new TreeNode(10);
    root.right = new TreeNode(21);
    root.left.left = new TreeNode(5);
    root.left.left.left = new TreeNode(1);
    root.left.left.right = new TreeNode(8);
    root.right.right = new TreeNode(27);
    root.right.right.left = new TreeNode(24);
    root.right.right.right = new TreeNode(34);

    System.out.println(LevelOrderTraversal.printLevelOrder(insertIntoBST(root, 7)));
    System.out.println(LevelOrderTraversal.printLevelOrder(insertIntoBST(root, 12)));
    System.out.println(LevelOrderTraversal.printLevelOrder(insertIntoBSTOtherApproach(root, 26)));
  }

  private static TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      TreeNode node = new TreeNode(val);
      return node;
    }
    if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    } else if (val > root.val) {
      root.right = insertIntoBST(root.right, val);
    }
    return root;
  }

  private static TreeNode insertIntoBSTOtherApproach(TreeNode root, int val) {
    if (val < root.val)
      root.left = root.left == null ? new TreeNode(val) : insertIntoBST(root.left, val);
    else if (val > root.val)
      root.right = root.right == null ? new TreeNode(val) : insertIntoBST(root.right, val);

    return root;
  }
}
