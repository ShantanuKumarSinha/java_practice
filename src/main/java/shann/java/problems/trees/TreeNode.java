package shann.java.problems.trees;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "TreeNode{" +
            "left=" + left +
            ", val=" + val +
            ", right=" + right +
            '}';
  }
}
