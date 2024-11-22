package shann.java.problems.hashMapAndHashSet;

import java.util.*;

/*
Problem Description

Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.

If there is no subarray which sums to zero then return 0.



Problem Constraints

1 <= N <= 105
-109 <= A[i] <= 109


Input Format

Single argument which is an integer array A.


Output Format

Return an integer.


Example Input

Input 1:

 A = [1, -2, 1, 2]
Input 2:

 A = [3, 2, -1]


Example Output

Output 1:

3
Output 2:

0


Example Explanation

Explanation 1:

 [1, -2, 1] is the largest subarray which sums up to 0.
Explanation 2:

 No subarray sums up to 0.
*/
public class LongestSubArrayZeroSum {
  public static void main(String[] args) {
   // int[] arr = {1, -2, 1, 2};
    int[] arr = {9,20,-11,-8,-4,2,-12,14,1};
    //int [] arr = {-16,16,2};
    LongestSubArrayZeroSum longestSubArrayZeroSum = new LongestSubArrayZeroSum();
    var result = longestSubArrayZeroSum.longestSubArrayZeroSum(arr);
    System.out.println(result);
  }

  public int longestSubArrayZeroSum(int[] nums) {
    int[] prefixSum = new int[nums.length];
    int maxDiff =0, currDiff = 0;
    prefixSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    Map<Integer, Integer> map = new HashMap<>();
    map.put(-1, 0);
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(prefixSum[i])) {
        currDiff = i-map.get(prefixSum[i]) ;
        if (currDiff > maxDiff) maxDiff = currDiff;
      } else{
        map.put(prefixSum[i], i);
      }
    }
    long a = 1;


    return maxDiff;
  }
}


