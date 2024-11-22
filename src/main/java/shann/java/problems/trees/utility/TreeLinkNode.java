package shann.java.problems.trees.utility;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeLinkNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
