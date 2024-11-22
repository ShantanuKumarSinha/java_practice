package shann.java.problems.dynamicProgramming.twoDimensional;

// notes question
// no of ways to go from (0,0) to (n-1,m-1) in matrix
// only can go right or down
public class CountUniquePaths {
  public static void main(String[] args) {
    int n = 5;
    int m = 6;
    int[][] dp = new int[n][m];
    for (int i = 0; i < m; i++) {
      dp[0][i] = 1;
    }
    for (int i = 0; i < n; i++) {
      dp[i][0] = 1;
    }
    CountUniquePaths countUniquePaths = new CountUniquePaths();
    System.out.println(countUniquePaths.numberOfWays(n - 1, m - 1, dp));
    System.out.println(countUniquePaths.numberOfWays2(n - 1, m - 1));
  }

  // top down approach
  private int numberOfWays(int n, int m, int[][] dp) {
    if (n == 0 && m == 0) {
      dp[n][m] = 1;
      return 1;
    }
    if (n < 0 || m < 0) return 0;
    if (dp[n][m] != 0) return dp[n][m];
    dp[n][m] = numberOfWays(n - 1, m, dp) + numberOfWays(n, m - 1, dp);
    return dp[n][m];
  }

  // bottom up approach
  private int numberOfWays2(int n, int m) {
    if (n == 0 && m == 0) return 1;
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i < m; i++) {
      dp[0][i] = 0;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[n - 1][m - 1];
  }
}
