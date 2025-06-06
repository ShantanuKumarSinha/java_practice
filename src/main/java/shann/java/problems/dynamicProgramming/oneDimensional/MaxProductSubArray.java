package shann.java.problems.dynamicProgramming.oneDimensional;

/*
Problem Description

Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.

Return an integer corresponding to the maximum product possible.

NOTE: Answer will fit in 32-bit integer value.



Problem Constraints

1 <= N <= 5 * 105

-100 <= A[i] <= 100



Input Format

First and only argument is an integer array A.



Output Format

Return an integer corresponding to the maximum product possible.



Example Input

Input 1:

 A = [4, 2, -5, 1]
Input 2:

 A = [-3, 0, -5, 0]


Example Output

Output 1:

 8
Output 2:

 0


Example Explanation

Explanation 1:

 We can choose the subarray [4, 2] such that the maximum product is 8.
Explanation 2:

 0 will be the maximum product possible.

*/
public class MaxProductSubArray {
  public static void main(String[] args) {
    int[] input = {4, 2, -5, -1,-2,0,5,7,-2,2,-1,0};
    MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
    var output = maxProductSubArray.getMaxProductOfSubArray(input);
    System.out.println(output);
  }

  private int getMaxProductOfSubArray(int[] nums) {
    int maxProduct = 1, maxProductSoFar = 1,minProductSoFar = 1;
    for (int i = 0; i < nums.length; i++) {
      if(nums[i]<0){
        maxProductSoFar = minProductSoFar+maxProductSoFar;
        minProductSoFar= maxProductSoFar-minProductSoFar;
        maxProductSoFar =maxProductSoFar-minProductSoFar;
      }
      maxProductSoFar= Math.max(nums[i],maxProductSoFar*nums[i]);
      minProductSoFar= Math.min(nums[i],minProductSoFar*nums[i]);
      if (maxProductSoFar > maxProduct) {
        maxProduct = maxProductSoFar;
      }
    }
    return maxProduct;
  }
}
