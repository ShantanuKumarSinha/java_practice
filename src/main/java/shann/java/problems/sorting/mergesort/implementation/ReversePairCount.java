package shann.java.problems.sorting.mergesort.implementation;

// TODO
public class ReversePairCount {
  // Merge function to merge two sorted subarrays
  static void merge(int[] arr, int low, int mid, int high) {
    // Calculate the lengths of the two subarrays
    int len1 = mid - low + 1;
    int len2 = high - mid;

    // Create temporary arrays to hold the subarrays
    int[] first = new int[len1];
    int[] second = new int[len2];

    // Copy data from the main array to the temporary arrays
    int k = low;
    for (int i = 0; i < len1; i++) {
      first[i] = arr[k++];
    }

    k = mid + 1;
    for (int i = 0; i < len2; i++) {
      second[i] = arr[k++];
    }

    // Merge the two subarrays back into the main array
    int i = 0, j = 0;
    k = low;
    while (i < len1 && j < len2) {
      // Compare and merge elements in sorted order
      if (first[i] <= second[j]) {
        arr[k++] = first[i++];
      } else {
        arr[k++] = second[j++];
      }
    }

    // Copy any remaining elements from the temporary arrays
    while (i < len1) {
      arr[k++] = first[i++];
    }

    while (j < len2) {
      arr[k++] = second[j++];
    }
  }

  // Function to count the reverse pairs using merge sort
  static int countReversePairs(int[] arr, int low, int mid, int high) {
    int cnt = 0;
    int j = mid + 1;
    for (int i = low; i <= mid; i++) {
      while (i <= high && arr[i] > 2 * arr[j]) {
        j++;
      }
      cnt += (j - (mid + 1));
    }
    return cnt;
  }

  // Merge Sort function to sort the array and count reverse pairs
  static int mergeSort(int[] arr, int low, int high) {
    int cnt = 0;
    if (low >= high) {
      return cnt;
    }
    int mid = low + (high - low) / 2;

    // Recursively count reverse pairs in left and right halves
    cnt += mergeSort(arr, low, mid);
    cnt += mergeSort(arr, mid + 1, high);

    // Merge the sorted halves and count reverse pairs
    cnt += countReversePairs(arr, low, mid, high);

    // Merge the two halves
    merge(arr, low, mid, high);

    return cnt;
  }

  public static void main(String[] args) {
//    int[] arr = {14046,57239,78362,99387,27609,55100,65536,62099,40820,33056,88380,78549,57512,33137,81212,32365,42276,65368,52459,74924,25355,76044,78056,45190,94365,58869,20611};
    int[] arr = {1, 3, 2, 3, 1};
    int n = arr.length;

    // Function Call to count reverse pairs
    System.out.println("Reverse pairs are: " + mergeSort(arr, 0, n - 1));
  }
}
