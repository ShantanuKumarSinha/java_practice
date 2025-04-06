package shann.java.problems.graphs.dfs.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphUtility {
    public static List<Integer>[] generateAdjacencyList(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int[] edge : edges) {
            set.add(edge[0]);
            set.add(edge[1]);
        }
        var adjacencyListLength = set.size();
        List<Integer>[] adjacencyList = new ArrayList[adjacencyListLength];
        // Initialize each ArrayList in the array
        for (int i = 0; i < adjacencyListLength; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i].length != 0) {
                var u = edges[i][0];
                var v = edges[i][1];
                adjacencyList[u].add(v);
            }
        }
        return adjacencyList;
    }

    public static List<List<Integer>> generateAdjacencyList(int[][] edges, int nodes) {
        List<List<Integer>>adjacencyList = new ArrayList<>();
        // Initialize each ArrayList in the array
        for (int i = 0; i <=nodes ; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i].length != 0) {
                var u = edges[i][0];
                var v = edges[i][1];
                adjacencyList.get(u).add(v);
            }
        }
        return adjacencyList;
    }
}
