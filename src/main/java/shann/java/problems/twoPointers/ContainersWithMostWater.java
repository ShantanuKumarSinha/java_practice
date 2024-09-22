package shann.java.problems.twoPointers;

/*
Problem Description
Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water. You need to return this maximum area.

Note: You may not slant the container. It is guaranteed that the answer will fit in integer limits.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 105



Input Format
Single Argument representing a 1-D array A.



Output Format
Return single Integer denoting the maximum area you can obtain.



Example Input
Input 1:

A = [1, 5, 4, 3]
Input 2:

A = [1]


Example Output
Output 1:

 6
Output 2:

 0


Example Explanation
Explanation 1:

5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
So total area = 3 * 2 = 6
Explanation 2:

No container is formed.
*/
public class ContainersWithMostWater {
  public static void main(String[] args) {
    var result = totalWaterTrapped(new int[] {0, 1, 0, 2, 1, 0, 3, 2, 1, 2, 1});
    System.out.println(result);
  }

  private static int maxArea(int[] height) {
    int maxArea = 0, area = 0;

    return maxArea;
  }

  // total water trapped
  private static int totalWaterTrapped(int[] height) {
    var totalWaterTrapped = 0;
    var maxHeightIndex = 0;
    for (int i = 1; i < height.length; i++) {
      if (height[i] > height[maxHeightIndex]) {
        maxHeightIndex = i;
      }
    }
    var lMax = height[0];
    for (int i = 0; i < maxHeightIndex; i++) {
      lMax = Math.max(lMax, height[i]);
      totalWaterTrapped += lMax-height[i];
    }
    var rMax = height[height.length - 1];
    for (int i = maxHeightIndex-1; i> maxHeightIndex; i--) {
      rMax = Math.max(rMax, height[i]);
      totalWaterTrapped += rMax-height[i];
    }

    return totalWaterTrapped;
  }
}
