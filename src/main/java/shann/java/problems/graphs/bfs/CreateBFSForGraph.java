package shann.java.problems.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a graph adjacency list

Input {{1},{2,4},{3},{1},{}}
*/
public class CreateBFSForGraph {
  public static void main(String[] args) {
    var adjacencyList =
        new ArrayList<>(
            List.of(new int[] {1}, new int[] {2, 4}, new int[] {3}, new int[] {1}, new int[] {}));
    var bfsForGraph = new CreateBFSForGraph();
    bfsForGraph.findBFS(adjacencyList,0);
  }

  private void findBFS(List<int[]> adjacencyList, int source) {
    var visited = new boolean[adjacencyList.size()];
    var queue = new LinkedList<Integer>();
    queue.add(source);
    visited[source] = true;
    while (!queue.isEmpty()) {
      var node = queue.poll();
      System.out.println(node);
      for (var nbr : adjacencyList.get(node)) {
        if (!visited[nbr]) {
          visited[nbr] = true;
          queue.add(nbr);
        }
      }
    }
  }
}
