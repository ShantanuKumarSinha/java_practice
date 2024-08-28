package shann.java.problems.stacks;

import java.util.Stack;

/*
Problem Description
Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000



Input Format
The first and only argument given is the integer array A.



Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.



Example Input
Input 1:

 A = [1]
Input 2:

 A = [4, 7, 3, 8]


Example Output
Output 1:

 0
Output 2:

 26


Example Explanation
Explanation 1:

Only 1 subarray exists. Its value is 0.
Explanation 2:

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26
*/
public class MaxAndMinDiffOfSubArrays {
  public static void main(String[] args) {

    var result1 = maxAndMinDiff(new int[] {1});
    System.out.println(result1);

    var result2 = maxAndMinDiff(new int[] {4, 7, 3, 8});
    System.out.println(result2);

    var result3 = maxAndMinDiff(new int[] {992387,932142,971117,934674,988917,967890,948508,970347});
    System.out.println(result3);
    
  }

  public static int maxAndMinDiff(int[] nums) {
    var result = 0;
    var greatestMaxOnLeftIndexes = greatestMaxOnLeftIndexes(nums);
    var greatestMaxOnRightIndexes = greatestMaxOnRightIndexes(nums);
    var greatestMinOnLeftIndexes = greatestMinOnLeftIndexes(nums);
    var greatestMinOnRightIndexes = greatestMinOnRightIndexes(nums);
    for (int i = 0; i < nums.length; i++) {
      var k = greatestMaxOnRightIndexes[i];
      var j = greatestMaxOnLeftIndexes[i];
      var m = greatestMinOnRightIndexes[i];
      var n = greatestMinOnLeftIndexes[i];
      var numberOfSubArraysWhereIisMax = (k - i) * (i - j);
      var numberOfSubArraysWhereIisMin = (m - i) * (i - n);
      var contributionOfNum =
          nums[i] * (numberOfSubArraysWhereIisMax - numberOfSubArraysWhereIisMin);
      result += contributionOfNum;
    }
    return result;
  }

  private static int[] greatestMaxOnLeftIndexes(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = -1;
    Stack<Integer> stack = new Stack<>();
    for (int i = 1; i < nums.length; i++) {
      if (stack.isEmpty() && nums[i - 1] > nums[i]) {
        stack.push(i - 1);
        result[i] = stack.peek();
      } else if (stack.isEmpty() && nums[i - 1] <= nums[i]) {
        result[i] = -1;
      } else if (!stack.isEmpty() && nums[i - 1] > nums[i]) {
        stack.push(i - 1);
        result[i] = stack.peek();
      } else {
        while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
      }
    }
    return result;
  }

  private static int[] greatestMaxOnRightIndexes(int[] nums) {
    int[] result = new int[nums.length];
    result[nums.length - 1] = nums.length;
    Stack<Integer> stack = new Stack<>();
    for (int i = nums.length - 2; i >= 0; i--) {
      if (stack.isEmpty() && nums[i + 1] > nums[i]) {
        stack.push(i + 1);
        result[i] = stack.peek();
      } else if (stack.isEmpty() && nums[i + 1] <= nums[i]) {
        result[i] = nums.length;
      } else if (!stack.isEmpty() && nums[i + 1] > nums[i]) {
        stack.push(i + 1);
        result[i] = stack.peek();
      } else {
        while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
          stack.pop();
        }
        result[i] = stack.isEmpty() ? nums.length : stack.peek();
      }
    }
    return result;
  }

  private static int[] greatestMinOnLeftIndexes(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = -1;
    Stack<Integer> stack = new Stack<>();
    for (int i = 1; i < nums.length; i++) {
      if (stack.isEmpty() && nums[i - 1] < nums[i]) {
        stack.push(i - 1);
        result[i] = stack.peek();
      } else if (stack.isEmpty() && nums[i - 1] >= nums[i]) {
        result[i] = -1;
      } else if (!stack.isEmpty() && nums[i - 1] < nums[i]) {
        stack.push(i - 1);
        result[i] = stack.peek();
      } else if (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        result[i] = stack.peek();
      } else {
        while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
          stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
      }
    }
    return result;
  }

  private static int[] greatestMinOnRightIndexes(int[] nums) {
    int[] result = new int[nums.length];
    result[nums.length - 1] = nums.length;
    Stack<Integer> stack = new Stack<>();
    for (int i = nums.length - 2; i >= 0; i--) {
      if (stack.isEmpty() && nums[i + 1] < nums[i]) {
        stack.push(i + 1);
        result[i] = stack.peek();
      } else if (stack.isEmpty() && nums[i + 1] >= nums[i]) {
        result[i] = nums.length;
      } else if (!stack.isEmpty() && nums[i + 1] < nums[i]) {
        stack.push(i + 1);
        result[i] = stack.peek();
      } else if (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        result[i] = stack.peek();
      } else {
        while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
          stack.pop();
        }
        result[i] = stack.isEmpty() ? nums.length : stack.peek();
      }
    }
    return result;
  }

  // optimized brute force method using two pointers
  public static int maxAndMinDiffUsingTwoPointers(int[] nums) {
    var result = 0;
    for (int i = 0; i < nums.length; i++) {
      int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
      for (int j = i; j < nums.length; j++) {
        max = Math.max(max, nums[j]);
        min = Math.min(min, nums[j]);
        var diff = max - min;
        result += diff;
      }
    }
    return result;
  }
}
