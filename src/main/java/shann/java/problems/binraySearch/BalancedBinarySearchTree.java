package shann.java.problems.binraySearch;
//TODO
public class BalancedBinarySearchTree {

  //     3
  //    2 4
  //   1    5
  // TODO
  public void search(int[] arr, int l, int r, int search) {
    int m = l + (r-l )/ 2;
    int[] L = new int[m];
    int[] R = new int[r - m];
    for (int i = 0; i < m; i++) L[i] = arr[l + i];
    for (int j = 0; j < r - m; j++) R[j] = arr[r - m + j];
    if (arr[m] == search) {
      System.out.println("Found");
    } else if (arr[m] > search) {
      search(L, l, m, search);
    } else search(R, m, r, search);
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6 , 7, 8, 9, 10};
    int l = 0, r = arr.length - 1;
    int search = 7;
    BalancedBinarySearchTree balancedBinarySearchTree = new BalancedBinarySearchTree();
    balancedBinarySearchTree.search(arr, l, r, search);
  }
}
