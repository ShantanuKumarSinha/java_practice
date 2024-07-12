package shann.java.problems.datastructure.arrays;

public class DivisibleBy7AndTwoGreaterNumber {
  public static void main(String[] args) {
    int[] A = {8 , 7, 11, 9, 14};
    int itemCount = 0, result = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] % 7 == 0) {
        for (int j = 0; j < i; j++) {
          if (A[j] > A[i]) itemCount++;
        }
        for (int k = i + 1; k < A.length; k++) {
          if (A[k] > A[i]) itemCount++;
        }
        if (itemCount >= 2) result++;
        itemCount = 0;
      }
    }
    System.out.println(result);
  }
}
