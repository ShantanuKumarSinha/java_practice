package shann.java.problems.trees.binarySearchTree.maxMin;

import shann.java.problems.trees.utility.TreeNode;

public class MinInBST {

  public static int minInBST(TreeNode root) {
    var current = root;
    while (current.left != null) {
      current = current.left;
    }
    return current.val;
  }
}
