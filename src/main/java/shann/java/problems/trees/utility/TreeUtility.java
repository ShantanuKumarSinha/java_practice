package shann.java.problems.trees.utility;

import shann.java.problems.trees.binaryTree.traversal.PostOrderTraversal;
import shann.java.problems.trees.binaryTree.traversal.PreOrderTraversal;

import java.util.List;

public class TreeUtility {

  public static List<Integer> preOrderTraversal(TreeNode treeNode) {
    var preOrderTraversal = PreOrderTraversal.preOrderTraversal(treeNode);
    return preOrderTraversal;
  }

  public static List<Integer> postOrderTraversal(TreeNode treeNode) {
    var postOrderTraversal = PostOrderTraversal.postOrderTraversal(treeNode);
    return postOrderTraversal;
  }
}
