package shann.java.problems.graphs.bfs;

/*
Problem Description

You are given a 2D binary grid representing a map with 1s (land) and 0s (water). Your task is to implement a function that returns the number of islands.

An island is formed by connecting adjacent lands horizontally or vertically, surrounded by water. Assume all four edges of the grid are surrounded by water.



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

 3
Output 2:

 6


Example Explanation

Explanation 1:

 The 1's at position A[0][1] forms one island
  A[1][2] forms second island.
 Third is formed by A[2][0].

Explanation 2:

 There 6 island in total.
*/
public class NumbersOfIsland2 {
  private int[] dr = {-1, 0, 1, 0};
  private int[] dc = {0, -1, 0, 1};

  public static void main(String[] args) {
    int[][] graph1 = {
      {0, 1, 0},
      {0, 0, 1},
      {1, 0, 0}
    };
    int[][] graph2 = {
      {1, 1, 0, 0, 0},
      {0, 1, 0, 0, 0},
      {1, 0, 0, 1, 1},
      {0, 0, 0, 0, 0},
      {1, 0, 1, 0, 1}
    };
    NumbersOfIsland2 numbersOfIsland = new NumbersOfIsland2();
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
