package shann.java.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* Problem Description
Given an integer array A of size N.

You are also given an integer B, you need to find whether their exist a subset in A whose sum equal B.

If there exist a subset then return 1 else return 0.

Note : Sum of elements of an empty subset is 0.



Problem Constraints
1 <= N <= 17

-109 <= A[i] <= 109

-109 <= B <= 109



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return 1 if there exist a subset with sum B else return 0.



Example Input
Input 1:

 A = [3, 34, -3, 12, 5, 2]
 B = 9
Input 2:

 A = [-8, 34, 4, 0, -5, -2]
 B = -20


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 There is a subset (-3, 12) with sum 9.
Explanation 2:

 There is no subset that add up to -20.
* */
public class SubSetEqualsToGivenNumber {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();
    int[] nums = {3, 34, -3, 12, 5, 2};
    int target = 0;
    //   if (target == 0) System.out.println(resultList);
    findTheSubSetEqualsToNumber(nums, 0, target, list, resultList);
    System.out.println(resultList);
  }

  private static void findTheSubSetEqualsToNumber(
      int[] nums, int index, int target, List<Integer> result, List<List<Integer>> finalResult) {
    if (index == nums.length) {
      int sum = 0;
      for (int i = 0; i < result.size(); i++) {
        sum += result.get(i);
      }
      if (sum == target) finalResult.add(new ArrayList<>(result));
      return;
    }
    result.add(nums[index]);
    findTheSubSetEqualsToNumber(nums, index + 1, target, result, finalResult);
    result.remove(result.size() - 1);
    findTheSubSetEqualsToNumber(nums, index + 1, target, result, finalResult);
  }
}
