package shann.java.problems.trees;

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
