package shann.java.problems.sorting.quicksort;

import static shann.java.problems.sorting.quicksort.PartitionOfAnArray.partitionOfAnArray;

// TODO
public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {54, 26, 93, 17, 77, 31, 44, 55, 20};
    quickSort(arr, 0, arr.length - 1);
  }

  private static void quickSort(int[] arr, int left, int right) {
    if (left >= right) return;
    var pI = partitionOfAnArray(arr,left,right);
    quickSort(arr, left, pI - 1);
    quickSort(arr, pI + 1, right);
  }

}
