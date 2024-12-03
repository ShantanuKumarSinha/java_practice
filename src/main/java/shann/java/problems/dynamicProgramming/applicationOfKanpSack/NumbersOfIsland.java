package shann.java.problems.dynamicProgramming.applicationOfKanpSack;

/*
Problem Description

Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

1 <= N, M <= 100

0 <= A[i] <= 1



Input Format

The only argument given is the integer matrix A.



Output Format

Return the number of islands.



Example Input

Input 1:

 A = [
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]
Input 2:

 A = [
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]
     ]


Example Output

Output 1:

 2
Output 2:

 5
*/
public class NumbersOfIsland {
  int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
  int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

  public static void main(String[] args) {
    int[][] grid1 = {{0, 1, 0}, {0, 0, 1}, {1, 0, 0}};
    int[][] grid2 = {
      {1, 1, 0, 0, 0},
      {0, 1, 0, 0, 0},
      {1, 0, 0, 1, 1},
      {0, 0, 0, 0, 0},
      {1, 0, 1, 0, 1}
    };
    NumbersOfIsland numbersOfIsland = new NumbersOfIsland();
    System.out.println(numbersOfIsland.findNumbersOfIsland(grid1));
    System.out.println(numbersOfIsland.findNumbersOfIsland(grid2));
  }

  private int findNumbersOfIsland(int[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          ans++;
          dfs(grid, i, j);
        }
      }
    }
    return ans;
  }

  private void dfs(int[][] grid, int row, int col) {
    grid[row][col] = 0;
    for (int i = 0; i < 8; i++) {
      int newRow = row + dr[i];
      int newCol = col + dc[i];
      if (newRow >= 0
          && newCol >= 0
          && newRow < grid.length
          && newCol < grid[0].length
          && grid[newRow][newCol] == 1) {
        dfs(grid, newRow, newCol);
      }
    }
  }
}
