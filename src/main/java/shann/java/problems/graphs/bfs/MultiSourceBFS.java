package shann.java.problems.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
There are n number of nodes and multisource {S1, S2, S3}
Find the length of shortest path for given destination to any one of the sources
s1 = 11, s2 = 7, s3= 2
 graph = [[11],[3,5],[2,9,12],[5,8],[2,4,11],[11],[8,10],[4,7],[3,13],[7,13],[1,5,6],[3],[9,10]]
*/
public class MultiSourceBFS {
  public static void main(String[] args) {
    int[][] graph = {
      {},
      {11},
      {3, 5}, // s3
      {2, 9, 12},
      {5, 8},
      {2, 4, 11},
      {11},
      {8, 10}, //s2
      {4, 7},
      {3, 13},
      {7, 13},
      {1, 5, 6}, // s1
      {3},
      {9, 10}
    };
    // added dummy value at zero index to balance
    var sources = new int[] {11, 7, 2};
    var bfs = new MultiSourceBFS();
    System.out.println(bfs.findShortestPath(graph, sources, 9));
  }

  private int findShortestPath(int[][] graph, int[] sources, int destination) {
    boolean[] visited = new boolean[graph.length];
    Queue<PairShortestPath> queue = new LinkedList<>();
    for (int src : sources) {
      queue.add(new PairShortestPath(src, 0));
      visited[src] = true;
    }
    while (!queue.isEmpty()) {
      var pairShortestPath = queue.poll();
      if (destination == pairShortestPath.vertex) return pairShortestPath.distance;
      for (int neighbor : graph[pairShortestPath.vertex]) {
        if (!visited[neighbor]) {
          queue.add(new PairShortestPath(neighbor, pairShortestPath.distance + 1));
          visited[neighbor] = true;
        }
      }
    }
    return -1;
  }
}

class PairShortestPath {
  int vertex;
  int distance;

  PairShortestPath(int vertex, int distance) {
    this.vertex = vertex;
    this.distance = distance;
  }
}
