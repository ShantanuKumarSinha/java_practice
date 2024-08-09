package shann.java.problems.datastructure.arrays;

public class MaximumDecreasingSubArray {
  public static void main(String[] args) {
    int[] arr = {4,10, 1, 6,3, 3};
    //int[] arr = {10, 4, 9, 1, 3, 5};
    int sum = arr[0], maxSum = arr[0];
    for (int si = 1; si < arr.length; si++) {
      if (arr[si] < arr[si - 1]) sum += arr[si];
      else {
        if (maxSum < sum) maxSum = sum;
        sum = arr[si];
      }
    }
    System.out.println(maxSum);
  }
}
