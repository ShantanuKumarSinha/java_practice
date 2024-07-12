package shann.java.problems.datastructure.bitManipulation;

public class MaximumAndPair {

  public static void main(String[] args) {
    int[] A = {13, 18, 23, 56, 81, 20, 4, 24, 93};
    int ans = 0;
    for (int i = 31; i >= 0; i--) {
      int count = 0;
      for (int j = 0; j < A.length; j++) {
        if (checkBit(A[j], i)) count++;
      }
      if (count > 1) {
        ans = ans | (1 << i);
        for (int k = 0; k < A.length; k++) {
          if (!checkBit(A[k], i)) A[k] = 0;
        }
      }
    }
    System.out.println(ans);
  }

  private static boolean checkBit(int n, int i) {
    if ((n & (1 << i)) > 0) return true;
    return false;
  }
}
