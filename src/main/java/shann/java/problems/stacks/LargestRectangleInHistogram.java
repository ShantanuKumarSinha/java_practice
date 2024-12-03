package shann.java.problems.stacks;

import java.util.Stack;

/*
Problem Description
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10000



Input Format
The only argument given is the integer array A.



Output Format
Return the area of the largest rectangle in the histogram.



Example Input
Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.
* */

public class LargestRectangleInHistogram {
  public static void main(String[] args) {
    var result1 = findLargestRectangle(new int[] {2, 1, 5, 6, 2, 3});
    System.out.println(result1);

    var result2 = findLargestRectangle(new int[] {2});
    System.out.println(result2);
  }

  private static int findLargestRectangle(int[] heights) {
    int maxArea = 0, area = 0;
    var nearestSmallIndexesOnLeft = getNearestSmallIndexesOnLeft(heights);
    var nearestSmallIndexesOnRight = getNearestSmallIndexesOnRight(heights);

    for (int i = 0; i < heights.length; i++) {
      // ((r-1)-(l-1)+1) == (r-l-1)
      area = heights[i] * (nearestSmallIndexesOnRight[i] - nearestSmallIndexesOnLeft[i] - 1);
      maxArea = Math.max(maxArea, area);
    }
    return maxArea;
  }

  private static int[] getNearestSmallIndexesOnLeft(int[] arr) {
    int[] result = new int[arr.length];
    result[0] = -1;
    Stack<Integer> stack = new Stack<>();
    for (int i = 1; i < arr.length; i++) {
      if (stack.isEmpty() && arr[i - 1] >= arr[i]) {
        result[i] = -1;
      } else if (arr[i - 1] < arr[i]) {
        stack.push(i - 1);
        result[i] = stack.peek();
      } else {
        while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
          stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
      }
    }
    return result;
  }

  // for nearest small om right use default value as n(array's length)
  private static int[] getNearestSmallIndexesOnRight(int[] arr) {
    int[] result = new int[arr.length];
    result[arr.length - 1] = arr.length;
    Stack<Integer> stack = new Stack<>();
    for (int i = arr.length - 2; i >= 0; i--) {
      if (stack.isEmpty() && arr[i + 1] >= arr[i]) {
        result[i] = arr.length;
      } else if (arr[i + 1] < arr[i]) {
        stack.push(i + 1);
        result[i] = stack.peek();
      } else {
        while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
          stack.pop();
        }
        result[i] = stack.isEmpty() ? arr.length : stack.peek();
      }
    }
    return result;
  }
}
