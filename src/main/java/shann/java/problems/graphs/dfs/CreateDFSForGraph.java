package shann.java.problems.graphs.dfs;

import java.util.*;

import static shann.java.problems.graphs.dfs.utility.GraphUtility.generateAdjacencyList;

public class CreateDFSForGraph {
  public static void main(String[] args) {
    int[][] edges = new int[][] {{0, 1}, {1, 2}, {1, 4}, {2, 3}, {3, 1}, {5, 6}, {7, 6}};
    CreateDFSForGraph createDFSForGraph = new CreateDFSForGraph();
    var adjacencyList = generateAdjacencyList(edges);
    System.out.println(Arrays.toString(adjacencyList));
    var src = 0;
    var visited = new boolean[adjacencyList.length];
    generateDFS(adjacencyList, src, visited);
    System.out.println(Arrays.toString(visited));
  }

  private static void generateDFS(List<Integer>[] adjacencyList, int src, boolean[] visited) {
    visited[src] = true;
    var list = adjacencyList[src];
    for (var edge : list) {
      if (!visited[edge]) generateDFS(adjacencyList, edge, visited);
    }
  }

}
