package shann.java.problems.sorting.mergesort;

public class MergeSort {

  public static void main(String[] args) {

    int arr[] = {12, 11, 13, 5, 6, 7};
    int l = 0, r = arr.length - 1;

    MergeSort mergeSort = new MergeSort();
    mergeSort.sort(arr, l, r);
    mergeSort.printItemsInArray(arr);
  }

  private void sort(int[] arr, int l, int r) {
    if (l >= r) return;
    int mid = l + (r - l) / 2;
    sort(arr, l, mid);
    sort(arr, mid + 1, r);
    merge(arr, l, mid, r);
  }

  private void merge(int[] arr, int l, int mid, int r) {
    int n1 = mid - l + 1;
    int n2 = r - mid;
    int[] left = new int[n1];
    int[] right = new int[n2];
    for (int i = 0; i < n1; i++) {
      left[i] = arr[l + i];
    }
    for (int j = 0; j < n2; j++) {
      right[j] = arr[mid + 1 + j];
    }
    int i = 0, j = 0;
    int k = l;
    while (i < n1 && j < n2) {
      arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
    }
    while (i < n1) {
      arr[k++] = left[i++];
    }
    while (j < n2) {
      arr[k++] = right[j++];
    }
  }

  public void printItemsInArray(int[] arr) {
    for (Integer i : arr) {
      if (i == arr[arr.length - 1]) System.out.print(i);
      else System.out.print(i + ", ");
    }
  }
}
