package shann.java.problems.dynamicProgramming.kanpsack;

public class TargetSum {
  public static void main(String[] args) {
    int[] arr1 = {3, 34, 4, 12, 5, 2};
    var target1 = 9;
    int[] arr2 = {7, 2, 3, 2, 3};
    var target2 = 8;

    TargetSum targetSum = new TargetSum();
    System.out.println(targetSum.findTargetSum(arr1, arr1.length - 1, target1));
    System.out.println(targetSum.findTargetSum(arr2, arr2.length - 1, target2));

    int[][] dp1 = new int[arr1.length + 1][target1 + 1];
    int[][] dp2 = new int[arr2.length + 1][target2 + 1];

    fillArray(dp1);
    fillArray(dp2);

    System.out.println(
        targetSum.findTargetSumUsingTopDownApproach(arr1, arr1.length - 1, target1, dp1));
    System.out.println(
        targetSum.findTargetSumUsingTopDownApproach(arr2, arr2.length - 1, target2, dp2));

    System.out.println(targetSum.findTargetSumUsingBottomUpApproach(arr1, target1));
    System.out.println(targetSum.findTargetSumUsingBottomUpApproach(arr2, target2));
  }

  private static void fillArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = -1;
      }
    }
  }

  // just backtracking
  private boolean findTargetSum(int[] nums, int i, int target) {
    if (target == 0) return true;
    if (target < 0 || i < 0) return false;
    return findTargetSum(nums, i - 1, target - nums[i]) || findTargetSum(nums, i - 1, target);
  }

  // top down approach
  private int findTargetSumUsingTopDownApproach(int[] nums, int i, int j, int[][] dp) {
    if (j == 0) return 1;
    if (j < 0 || i < 0) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    if (findTargetSumUsingTopDownApproach(nums, i - 1, j - nums[i], dp) == 1
        || findTargetSumUsingTopDownApproach(nums, i - 1, j, dp) == 1) dp[i][j] = 1;
    else dp[i][j] = 0;
    return dp[i][j];
  }

  // bottom approach
  private boolean findTargetSumUsingBottomUpApproach(int[] nums, int target) {
    // dp table
    boolean[][] dp = new boolean[nums.length + 1][target + 1];
    // Base case: dp[i][0] = true (0 sum is always possible)
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = true;
    }
    // Fill in the DP
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        // exclude the current element
        dp[i][j] = dp[i - 1][j];
        // Include the current element if it's not larger than j
        if (nums[i - 1]<=j) {
          dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[nums.length][target];
  }
}
