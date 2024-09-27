package shann.java.problems.twoPointers;

import java.util.Arrays;

/*
Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 [-1]


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
* */
public class SubArraysSumEqualsToNum {
  public static void main(String[] args) {
    var result1 = findSubArraySum(new int[] {1, 2, 3, 4, 5}, 5);
    System.out.println(Arrays.toString(result1));
    var result2 = findSubArraySum(new int[] {5, 10, 20, 100, 105}, 110);
    System.out.println(Arrays.toString(result2));
  }

  // brute force
  private static int[] findSubArraySumEqualToNum(int[] num, int target) {
    for (int i = 0; i < num.length - 1; i++) {
      int sum = num[i];
      for (int j = i + 1; j < num.length; j++) {
        sum += num[j];
        if (sum == target) {
          int[] result = new int[j - i + 1];
          result = Arrays.copyOfRange(num, i, j + 1);
          return result;
        }
      }
    }
    return new int[] {-1};
  }

  private static int[] findSubArraySum(int[] num, int target) {
    int i = 0, j = 0, sum = num[0];
    while (j < num.length) {
      if (sum == target) return Arrays.copyOfRange(num, i, j + 1);
      else if (sum < target) {
        j++;
        if (j < num.length) sum += num[j];
      } else {
        sum -= num[i];
        i++;
      }
    }
    return new int[] {-1};
  }
}
