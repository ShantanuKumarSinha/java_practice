package shann.java.problems.sorting.mergesort.implementation;

// TODO
public class InversionCountInAnArray {
  // Main method
  public static void main(String[] args) {
    int arr[] = {2, 4, 1, 3, 5};
    int n = arr.length;
    System.out.println(countInv(arr, 0, n - 1));
  }

  static int countInv(int arr[], int l, int r) {
    int res = 0;
    try {
      res = 0;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    if (l < r) {
      int m = (r + l) / 2;

      // Recursively count inversions
      // in the left and right halves
      res += countInv(arr, l, m);
      res += countInv(arr, m + 1, r);

      // Count inversions such that
      // greater element is in left half
      // and smaller in right half
      res += countAndMerge(arr, l, m, r);
    }
    return res;
  }

  // This function merges two sorted subarrays
  // arr[l...m] and arr[m+1 .. r] and also counts
  // inversions in the whole subarray arr[l..r]
  static int countAndMerge(int arr[], int l, int m, int r) {

    // Counts in two subarrays
    int n1 = m - l + 1, n2 = r - m;

    // Set up two arrays for left
    // and right halves
    int[] left = new int[n1];
    int[] right = new int[n2];
    for (int i = 0; i < n1; i++) left[i] = arr[l+i];
    for (int j = 0; j < n2; j++) right[j] = arr[m + 1 + j];

    // Initialize inversion count (or
    // result) and merge two halves
    int res = 0, i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      // No increment in inversion count
      // if left[] has a smaller or equal
      if (left[i] <= right[j]) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
        res += (n1 - i);
      }
    }

    // Merge remaining elements
    while (i < n1) arr[k++] = left[i++];
    while (j < n2) arr[k++] = right[j++];

    return res;
  }
}
