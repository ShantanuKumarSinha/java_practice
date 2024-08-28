package shann.java.problems.stacks;

import java.util.Stack;

/*
Problem Description
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.



Problem Constraints
1 <= |A| <= 100000

-109 <= A[i] <= 109



Input Format
The only argument given is integer array A.



Output Format
Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.



Example Input
Input 1:

 A = [4, 5, 2, 10, 8]
Input 2:

 A = [3, 2, 1]


Example Output
Output 1:

 [-1, 4, -1, 2, 2]
Output 2:

 [-1, -1, -1]


Example Explanation
Explanation 1:

index 1: No element less than 4 in left of 4, G[1] = -1
index 2: A[1] is only element less than A[2], G[2] = A[1]
index 3: No element less than 2 in left of 2, G[3] = -1
index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
Explanation 2:

index 1: No element less than 3 in left of 3, G[1] = -1
index 2: No element less than 2 in left of 2, G[2] = -1
index 3: No element less than 1 in left of 1, G[3] = -1
*/
public class NearestSmaller {
  public static void main(String[] args) {
    var result1 = getNearestSmaller(new int[] {4, 5, 2, 10, 8});
    StackUtilityClass.printArrayItems(result1);

    var result2 = getNearestSmaller(new int[] {3, 2, 1});
    StackUtilityClass.printArrayItems(result2);

    var result3 = getNearestSmaller(new int[] {34, 35, 27, 42, 5, 28, 39, 20, 28});
    //    -1 34 -1 27 -1 5 28 5 20
    StackUtilityClass.printArrayItems(result3);

    var result4 =
        getNearestSmaller(
            new int[] {
              8, 23, 22, 16, 22, 7, 7, 27, 35, 27, 32, 20, 5, 1, 35, 28, 20, 6, 16, 26, 48, 34
            });
    // -1 8 8 8 16 -1 -1 7 27 7 27 7 -1 -1 1 1 1 1 6 16 26 26
    StackUtilityClass.printArrayItems(result4);
  }

  private static int[] getNearestSmaller(int[] arr) {
    int[] result = new int[arr.length];
    result[0] = -1;
    Stack<Integer> stack = new Stack<>();
    for (int i = 1; i < arr.length; i++) {
      if (stack.isEmpty() && arr[i - 1] < arr[i]) {
        stack.push(arr[i - 1]);
        result[i] = stack.peek();
      } else if (stack.isEmpty() && arr[i - 1] >= arr[i]) {
        result[i] = -1;
      } else if (!stack.isEmpty() && arr[i - 1] < arr[i]) {
        stack.push(arr[i - 1]);
        result[i] = stack.peek();
      } else if (!stack.isEmpty() && stack.peek() < arr[i]) {
        result[i] = stack.peek();
      } else {
        while (!stack.isEmpty() && stack.peek() >= arr[i]) {
          stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
      }
    }
    return result;
  }
}
