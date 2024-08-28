package shann.java.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

  private static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.right = new TreeNode(2);
    root1.right.left = new TreeNode(3);

    var result1 = inOrderTraversal(root1);
    System.out.println(result1);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(6);
    root2.right = new TreeNode(2);
    root2.right.left = new TreeNode(3);
    list = new ArrayList<>();
    var result2 = inOrderTraversal(root2);
    System.out.println(result2);
  }

  public static List<Integer> inOrderTraversal(TreeNode root) {
    if (root == null) return list;
    inOrderTraversal(root.left);
    list.add(root.val);
    inOrderTraversal(root.right);
    return list;
  }
}
