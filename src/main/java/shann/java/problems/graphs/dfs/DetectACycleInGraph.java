package shann.java.problems.graphs.dfs;

import static shann.java.problems.graphs.dfs.utility.GraphUtility.generateAdjacencyList;

import java.util.Arrays;
import java.util.List;

public class DetectACycleInGraph {
  public static void main(String[] args) {
    int[][] edges = new int[][] {{0, 1}, {1, 2}, {1, 4}, {2, 3}, {3, 1}, {5, 6}, {7, 6}};
    var graph = generateAdjacencyList(edges);
    System.out.println(Arrays.toString(graph));
    var src = 0;
    var visited = new boolean[graph.length];
    DetectACycleInGraph detectACycleInGraph = new DetectACycleInGraph();
    var result = !detectACycleInGraph.checkIfGraphHasNoCycle(graph, src, visited);
    System.out.println(result);
  }

  private boolean checkIfGraphHasNoCycle(List<Integer>[] graph, int src, boolean[] visited) {
    visited[src] = true;
    var list = graph[src];
    for (var vertex : list) {
      if (visited[vertex]) return false;
      else return checkIfGraphHasNoCycle(graph, vertex, visited);
    }
    return true;
  }
}
