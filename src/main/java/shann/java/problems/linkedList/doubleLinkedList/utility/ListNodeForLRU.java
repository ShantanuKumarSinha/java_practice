package shann.java.problems.linkedList.doubleLinkedList.utility;

public class ListNodeForLRU {
  public int key;
  public int val;
  public ListNodeForLRU next;
  public ListNodeForLRU prev;

  public ListNodeForLRU(int key, int val) {
    this.key = key;
    this.val = val;
  }
}
