package shann.java.problems.graphs.bfs;

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


Example Explanation

Explanation 1:

 The 1's at position A[0][1] and A[1][2] forms one island.
 Other is formed by A[2][0].
Explanation 2:

 There 5 island in total.
*/
public class NumbersOfIsland {
  private int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
  private int[] dc = {1, 0, -1, -1, -1, 0, 1, 1};

  public static void main(String[] args) {
    int[][] graph1 = {{0, 1, 0}, {0, 0, 1}, {1, 0, 0}};
    int[][] graph2 = {
      {1, 1, 0, 0, 0},
      {0, 1, 0, 0, 0},
      {1, 0, 0, 1, 1},
      {0, 0, 0, 0, 0},
      {1, 0, 1, 0, 1}
    };
    NumbersOfIsland numbersOfIsland = new NumbersOfIsland();
    System.out.println(numbersOfIsland.findNumOfIslands(graph1));
    System.out.println(numbersOfIsland.findNumOfIslands(graph2));
  }

  private int findNumOfIslands(int[][] grid) {
    var numberOfIslands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          numberOfIslands++;
          dfsToCheckAdjacentIslands(grid, i, j);
        }
      }
    }
    return numberOfIslands;
  }

  private void dfsToCheckAdjacentIslands(int[][] grid, int row, int col) {
    grid[row][col] = 0;
    for (int d = 0; d < dr.length; d++) {
      int newRow = row + dr[d];
      int newCol = col + dc[d];
      if (0 <= newRow
          && newRow < grid.length
          && 0 <= newCol
          && newCol < grid[0].length
          && grid[newRow][newCol] == 1) {
        dfsToCheckAdjacentIslands(grid, newRow, newCol);
      }
    }
  }
}
