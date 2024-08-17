package shann.java.problems.binraySearch;

public class BalancedBinarySearchTree {

  //     3
  //    2 4
  //   1    5

  public void search(int[] arr, int l, int r, int search) {
    int m = l + r / 2;
    int[] L = new int[m];
    int[] R = new int[r - m];
    for (int i = 0; i < m; i++) L[i] = arr[l + i];
    for (int j = 0; j < r - m; j++) R[j] = arr[r - m + j];
    if (arr[m] == search) {
      System.out.println("Found");
    } else if (arr[m] < search) {
      search(L, l, m, search);
    } else search(R, m, r, search);
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int l = 0, r = arr.length - 1;
    int search = 2;
    BalancedBinarySearchTree balancedBinarySearchTree = new BalancedBinarySearchTree();
    balancedBinarySearchTree.search(arr, l, r, search);
  }
}
