package shann.java.problems.graphs;

import java.util.*;

/*
Problem Description

There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.



Problem Constraints

0 <= x , y, R <= 100

1 <= N <= 1000

Center of each circle would lie within the grid



Input Format

1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle



Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).



Example Input

Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]
Input 2:

 x = 3
 y = 3
 N = 1
 R = 1
 A = [0]
 B = [3]


Example Output

Output 1:

 NO
Output 2:

 YES


Example Explanation

Explanation 1:

 There is NO valid path in this case
Explanation 2:

 There is many valid paths in this case.
 One of the path is (0, 0) -> (1, 0) -> (2, 0) -> (3, 0) -> (3, 1) -> (3, 2) -> (3, 3).
*/
public class PathThroughRectangle {
    // Directions for moving to 8 neighbors
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static boolean[][] visited;
    private static boolean[][] memo;
    private static int x, y, R, N;
    private static List<int[]> circles;

    public static String canReach(int xMax, int yMax, int n, int r, int[] A, int[] B) {
        x = xMax;
        y = yMax;
        N = n;
        R = r;

        visited = new boolean[x + 1][y + 1];
        memo = new boolean[x + 1][y + 1];
        circles = new ArrayList<>();

        // Populate circle centers
        for (int i = 0; i < n; i++) {
            circles.add(new int[]{A[i], B[i]});
        }

        if (isInsideAnyCircle(0, 0)) {
            return "NO";
        }

        return dfs(0, 0) ? "YES" : "NO";
    }

    private static boolean dfs(int cx, int cy) {
        if (cx == x && cy == y) return true;

        if (visited[cx][cy]) return memo[cx][cy];
        visited[cx][cy] = true;

        for (int i = 0; i < 8; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (isValid(nx, ny) && !isInsideAnyCircle(nx, ny)) {
                if (dfs(nx, ny)) {
                    memo[cx][cy] = true;
                    return true;
                }
            }
        }

        memo[cx][cy] = false;
        return false;
    }

    private static boolean isValid(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx <= x && ny <= y;
    }

    private static boolean isInsideAnyCircle(int px, int py) {
        for (int[] circle : circles) {
            int cx = circle[0], cy = circle[1];
            if (Math.pow(px - cx, 2) + Math.pow(py - cy, 2) <= R * R) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test case 1
        int x1 = 2, y1 = 3, N1 = 1, R1 = 1;
        int[] A1 = {2};
        int[] B1 = {3};
        System.out.println(canReach(x1, y1, N1, R1, A1, B1)); // Output: NO

        // Test case 2
        int x2 = 3, y2 = 3, N2 = 1, R2 = 1;
        int[] A2 = {0};
        int[] B2 = {3};
        System.out.println(canReach(x2, y2, N2, R2, A2, B2)); // Output: YES
    }
}
