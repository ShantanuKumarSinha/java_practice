package shann.java.problems.twoPointers;

import java.util.Arrays;

/*
Problem Description
Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.



Problem Constraints
1 <= N <= 104

0 <= A[i], B <= 105



Input Format
First argument is an one-dimensional integer array A of size N.

Second argument is an integer B.



Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.



Example Input
Input 1:

 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:

 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:

 A = [1, 1, 1, 2, 2]
 B = 0


Example Output
Output 1:

 2
Output 2:

 5
Output 3:

 2


Example Explanation
Explanation 1:

 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
Explanation 2:

 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
Explanation 3:

 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
*/
public class PairsWithGivenDifference {
  public static void main(String[] args) {
    var result1 = countPairWithDifferenceEqualsToNum(new int[] {1, 5, 3, 4, 2}, 3);
    System.out.println(result1);
    var result2 = countPairWithDifferenceEqualsToNum(new int[] {8, 12, 16, 4, 0, 20}, 4);
    System.out.println(result2);
    var result3 = countPairWithDifferenceEqualsToNum(new int[] {1, 1, 1, 2, 2}, 0);
    System.out.println(result3);
    var result4 =
        countPairWithDifferenceEqualsToNum(
            new int[] {
              8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9,
              6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3
            },
            3);
    System.out.println(result4);
    var result5 =
        countPairWithDifferenceEqualsToNum(
            new int[] {1, 8, 2, 8, 8, 8, 8, 4, 4, 6, 10, 10, 9, 2, 9, 3, 7}, 1);
    System.out.println(result5);
  }

  private static int countPairWithDifferenceEqualsToNum(int[] nums, int target) {
    Arrays.sort(nums);
    int i = 0, j = nums.length - 1, count = 0;
    while (i < j) {
      if (nums[j] - nums[i] == target) {
        count++;
        int countI = 0;
        for (int x = i; x <= j; x++) {
          if (nums[x] == nums[i]) countI++;
          else break;
        }
        i = i + countI;
        j = nums.length - 1;
      } else if (nums[j] - nums[i] > target) j--;
      else {
        int countI = 0;
        for (int x = i; x <= j; x++) {
          if (nums[x] == nums[i]) countI++;
          else break;
        }
        i = i + countI;
        j = nums.length - 1;
      }
    }
    return count;
  }
}
