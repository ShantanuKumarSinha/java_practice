package shann.java.problems.binraySearch;

import java.util.Arrays;

/*
Problem Description

Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.



Problem Constraints

1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the maximum value of K (sub array length).



Example Input

Input 1:

A = [1, 2, 3, 4, 5]
B = 10
Input 2:

A = [5, 17, 100, 11]
B = 130


Example Output

Output 1:

 2
Output 2:

 3
*/
public class FindMaxKForWhichThereIsNoSubarrayWithSumGreaterThanB {
  public static void main(String[] args) {
    FindMaxKForWhichThereIsNoSubarrayWithSumGreaterThanB findMaxK =
        new FindMaxKForWhichThereIsNoSubarrayWithSumGreaterThanB();
    var ans1 = findMaxK.findMaxK(new int[] {1, 2, 3, 4, 5}, 10);
    System.out.println(ans1);
    var ans2 = findMaxK.findMaxK(new int[] {5, 17, 100, 11}, 130);
    System.out.println(ans2);
    var ans3 = findMaxK.findMaxK(new int[] {2,24,38,25,35,33,43,12,49,35,45,47,5,33}, 249);
    System.out.println(ans3);

  }

  public int findMaxK(int[] nums, int maxAllowedSum) {
    int ans = 0;
    int start = 0;
    int end = nums.length;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (isAValidNumberSlidingWindow(nums, mid, maxAllowedSum)) {
        ans = mid;
        start = mid + 1;
      } else end = mid - 1;
    }
    return ans;
  }

  private boolean isAValidNumberSlidingWindow(int[] arr, int k, int maxAllowedSum) {
    var currSum =0;
    for(int i=0; i<k;i++){
      currSum += arr[i];
    }
    if(currSum > maxAllowedSum)
      return false;
    for(var i =k; i<arr.length; i++ ){
      currSum += arr[i];
      currSum -= arr[i-k];
      if(currSum > maxAllowedSum)
        return false;
    }
    return true;
  }
}
