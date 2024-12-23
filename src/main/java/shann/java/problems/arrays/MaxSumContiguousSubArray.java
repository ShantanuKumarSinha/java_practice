package shann.java.problems.arrays;

import java.util.List;

public class MaxSumContiguousSubArray {
  public static void main(String[] args) {
    MaxSumContiguousSubArray maxSumContiguousSubArray = new MaxSumContiguousSubArray();
    System.out.println(maxSumContiguousSubArray.maxSubArray(List.of(-500)));
  }

  public int maxSubArray(final List<Integer> A) {
    int ans = 0, sum = 0;

    for (int i = 0; i < A.size(); i++) {
      sum += A.get(i);
      if (sum > ans) ans = sum;
      if (sum < 0) sum = 0;
    }
    if (ans == 0) {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < A.size(); i++) if (max < A.get(i)) max = A.get(i);
      return max;
    }
    return ans;
  }
}
