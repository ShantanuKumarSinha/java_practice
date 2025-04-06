package shann.java.problems.graphs.dfs;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Use Hint
Problem Description

You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.

Problem Constraints

1 <= N <= 100000

Input Format

First argument is vector A

Second argument is integer B

Third argument is integer C

Output Format

Return 1 if reachable, 0 otherwise.

Example Input

Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2

Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:

 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
*/
public class FirstDepthFirstSearchUsingQueue {
  public static void main(String[] args) {
    //    int[] vector = {1, 1, 2};
    //    var src = 1;
    //    var dst = 2;
    int[] vector = {1, 1, 1, 3, 3, 2, 2, 7, 6};
    int length = vector.length;
    for (Integer v : vector) {
      length = max(length, v);
    }
    var src = 8;
    var dst = 2;
    List<Integer>[] graph = new ArrayList[length + 1];
    for (int i = 0; i <= length; i++) {
      graph[i] = new ArrayList<>();
    }

    List<List<Integer>> graphList = new ArrayList<>();

    for (int i = 1; i < vector.length; i++) {
      var u = vector[i];
      var v = i + 1;
      graph[u].add(v);
    }

    boolean[] visited = new boolean[graph.length + 1];
    Queue<Integer> queue = new LinkedList<>();
    FirstDepthFirstSearchUsingQueue firstDepthFirstSearch = new FirstDepthFirstSearchUsingQueue();
    var result = firstDepthFirstSearch.findIfPathExistUsingQueue(graph, src, dst, visited, queue);
    System.out.println(result);
  }

  private int findIfPathExistUsingQueue(
      List<Integer>[] graph, int src, int dest, boolean[] visited, Queue<Integer> queue) {
    if (src < graph.length) {
      visited[src] = true;
      queue.add(src);
      while (!queue.isEmpty()) {
        int removed = queue.remove();
        if (removed == dest) return 1;
        for (int node : graph[removed]) {
          if (node < graph.length && !visited[node])
            findIfPathExistUsingQueue(graph, node, dest, visited, queue);
        }
      }
    }
    return 0;
  }
}
