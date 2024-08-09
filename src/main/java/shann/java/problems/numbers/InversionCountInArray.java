package shann.java.problems.numbers;

public class InversionCountInArray {
  public static void main(String[] args) {
    int[] arr = {45, 10, 15, 25, 50};
    int result = solve(arr);
    System.out.println(result);
  }

  public static int solve(int[] A) {
    int count = 0;
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = i + 1; j < A.length; j++) {
        if (A[i] > A[j]) count++;
      }
    }
    return count;
  }
}
