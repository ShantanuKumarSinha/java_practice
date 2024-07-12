package shann.java.problems.recursion;

public class FindMaxUsingRecursion {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 15, 6, 7, 8, 9};
    var result = findMax(arr,0,arr[0]);
    System.out.println(result);
  }

  private static int findMax(int[] A, int i, int max) {
    if(i==A.length)
        return max;
    if(max<A[i])
        max = A[i];
    return findMax(A,i+1, max);
  }
}
