package shann.java.problems.sorting.quicksort;

import java.util.Arrays;

// This is used in Quick Sort
public class PartitionOfAnArray {

  public static void main(String[] args) {
    int[] arr = {54, 26, 93, 17, 77, 31, 44, 55, 20};

    var result = partitionOfAnArray(arr, 0, arr.length - 1);
  }
//  How partition is supposed to work
//  first A[0] = pivot;
//  left = 1; right = n-1;
//   54 26 20 17 77 31 44 55 93
//   54 26 20 17 55 31 44 77 93
//   54 26 20 17 44 31 55 77 93
//   after swap
//   31 26 20 17 44 54 55 77 93
  static int partitionOfAnArray(int[] arr, int pI, int right) {
    int pivot = arr[pI];
    int left = pI + 1;
    while (left < right) {
      if (arr[left] < pivot) left++;
      else if (arr[left] >= pivot) {
        swap(arr, left, right);
        right--;
      }
    }
    swap(arr, 0, right);
    pI = right;
    System.out.println(Arrays.stream(arr).boxed().toList());
    return pI;
  }

  private static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
