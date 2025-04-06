package shann.java.problems.trees.binaryTree.operate;

// Find the difference of odd and even level node of binary tree
// Consider root as at level 1

import java.util.ArrayDeque;
import java.util.Deque;
import shann.java.problems.trees.utility.TreeNode;

public class DifferenceOfOddAndEvenLevelNodes {
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);
    root1.right.left = new TreeNode(6);
    root1.right.right = new TreeNode(7);
    System.out.println(diff(root1));
  }

  private static int diff(TreeNode root) {
    Deque<PairForOddAndEvenLevelNodes> deque = new ArrayDeque<>();
    deque.push(new PairForOddAndEvenLevelNodes(root, 1));
    int oddSum = 0, evenSum = 0, levelCount = deque.size();

    while (!deque.isEmpty()) {
      var rem = deque.pop();
      if (rem.level % 2 == 0) evenSum += rem.treeNode.val;
      else oddSum += rem.treeNode.val;
      if (rem.treeNode.left != null)
        deque.add(new PairForOddAndEvenLevelNodes(rem.treeNode.left, rem.treeNode.val + 1));
      if (rem.treeNode.right != null)
        deque.add(new PairForOddAndEvenLevelNodes(rem.treeNode.right, rem.treeNode.val + 1));
    }
    return Math.abs(evenSum - oddSum);
  }
}

class PairForOddAndEvenLevelNodes {
  TreeNode treeNode;
  int level;

  public PairForOddAndEvenLevelNodes(TreeNode treeNode, int level) {
    this.treeNode = treeNode;
    this.level = level;
  }
}
