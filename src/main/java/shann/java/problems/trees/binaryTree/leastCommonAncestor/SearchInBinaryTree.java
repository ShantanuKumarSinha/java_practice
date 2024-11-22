package shann.java.problems.trees.binaryTree.leastCommonAncestor;

import shann.java.problems.trees.utility.TreeNode;

public class SearchInBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(12);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(24);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        SearchInBinaryTree searchInBinaryTree = new SearchInBinaryTree();
        System.out.println(searchInBinaryTree.searchInBinaryTree(root, 8));
    }

    public boolean searchInBinaryTree(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        return searchInBinaryTree(root.left, target) || searchInBinaryTree(root.right, target);
    }
}
