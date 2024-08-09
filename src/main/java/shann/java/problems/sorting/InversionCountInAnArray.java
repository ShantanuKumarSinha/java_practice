package shann.java.problems.sorting;

// TODO
public class InversionCountInAnArray {
  public static void main(String[] args) {
    int[] arr = {45, 10, 15, 25, 50};
    var ans = solve(arr);
    System.out.println(ans);
  }

  public static int solve(int[] A) {
    int l = 0, r = A.length - 1;
    int count = sort(A, l, r) % 1000000007;
    return count;
  }

  public static int sort(int[] a, int l, int r) {
    int count = 0;
    while (l < r) {
      int m = l + r / 2;
      sort(a, l, m);
      sort(a, m + 1, r);
      count = (count % 1000000007) + (merge(a, l, m, r) % 1000000007);
    }
    return count;
  }

  public static int merge(int[] arr, int l, int m, int r) {
    int n1 = m;
    int n2 = r - m;
    int swap = 0;

    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++) L[i] = arr[l + i];
    for (int j = 0; j < n1; j++) R[j] = arr[m + 1 + j];

    int i = 0, j = 0;
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
        swap += (m + 1) - (l + i);
      }
      k++;
    }
    while (i < n1) {
      arr[k] = L[i];
      i++;

      k++;
    }

    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
    return swap;
  }
}
