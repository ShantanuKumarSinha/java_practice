package shann.java.problems.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format

The first argument given is the integer matrix A.



Output Format

Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input

Input 1:


A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]


Input 2:



A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]








Example Output

Output 1:

 4
Output 2:

 -1


Example Explanation

Explanation 1:

Minute 0: [ [2, 1, 1]
            [1, 1, 0]
            [0, 1, 1] ]
Minute 1: [ [2, 2, 1]
            [2, 1, 0]
            [0, 1, 1] ]
Minute 2: [ [2, 2, 2]
            [2, 2, 0]
            [0, 1, 1] ]
Minute 3: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 1] ]
Minute 4: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 2] ]
At Minute 4, all the oranges are rotten.
Explanation 2:

The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
*/
public class RottenOranges {
  int[] dr = {0, 1, 0, -1};
  int[] dc = {-1, 0, 1, 0};

  public static void main(String[] args) {
    int[][] graph1 = {
      {2, 1, 1},
      {1, 1, 0},
      {0, 1, 1}
    };

    int[][] graph2 = {
      {2, 1, 1},
      {0, 1, 1},
      {1, 0, 1}
    };
    RottenOranges rottenOranges = new RottenOranges();
    System.out.println(rottenOranges.findTimeTakenForRottenOranges(graph1));
    System.out.println(rottenOranges.findTimeTakenForRottenOranges(graph2));
  }

  private int findTimeTakenForRottenOranges(int[][] graph) {
    int timeRequiredForOrangesToRot = 0;
    Queue<TripletRottenOranges> queue = new LinkedList<>();
    for (int row = 0; row < graph.length; row++) {
      for (int col = 0; col < graph[row].length; col++) {
        if (graph[row][col] == 2) {
          queue.add(new TripletRottenOranges(row, col, 0));
        }
      }
    }
    while (!queue.isEmpty()) {
      var tripletRottenOranges = queue.poll();
      var row = tripletRottenOranges.row;
      var col = tripletRottenOranges.col;
      var time = tripletRottenOranges.time;
      timeRequiredForOrangesToRot = time;
      for (int i = 0; i < 4; i++) {
        int newRow = row + dr[i];
        int newCol = col + dc[i];
        if (0 <= newRow
            && newRow < graph.length
            && 0 <= newCol
            && newCol < graph[newRow].length
            && graph[newRow][newCol] == 1) {
          graph[newRow][newCol] = 2;
          queue.add(new TripletRottenOranges(newRow, newCol, time + 1));
        }
      }
    }
    for (int row = 0; row < graph.length; row++) {
      for (int col = 0; col < graph[row].length; col++) {
        if (graph[row][col] == 1) {
          return -1;
        }
      }
    }

    return timeRequiredForOrangesToRot;
  }
}

class TripletRottenOranges {
  int row;
  int col;
  int time;

  TripletRottenOranges(int row, int col, int time) {
    this.row = row;
    this.col = col;
    this.time = time;
  }
}
