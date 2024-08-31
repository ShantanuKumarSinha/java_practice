package shann.java.problems.trees.bst;

import shann.java.problems.trees.utility.TreeNode;

public class MaxInBST {

  public static int maxInBST(TreeNode root) {
    var current = root;
    while (current.right != null) {
      current = current.right;
    }
    return current.val;
  }
}
