package shann.java.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* Problem Description

Given a set of distinct integers A, return all possible subsets that can be formed from the elements of array A.



Problem Constraints
1 ≤ |A| ≤ 16

INT_MIN ≤ A[i] ≤ INT_MAX

Array A is given in increasing order.

All elements of array A are distinct.



Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a vector of vectors denoting the answer in any order.



Example Input
Input 1:

A = [1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]
* */
public class GenerateSubSetOfAnArray {
  public static void main(String[] args) {
    List<List<Integer>> result = new ArrayList<>();
    generateSubSetOfAnArray(new int[] {1, 2, 3}, 0, new ArrayList<Integer>(), result);
    System.out.println(result);
  }

  private static void generateSubSetOfAnArray(
      int[] nums, int index, List<Integer> subSet, List<List<Integer>> result) {
    if (index == nums.length) {
      result.add(new ArrayList<>(subSet));
      return;
    }
    subSet.add(nums[index]);
    generateSubSetOfAnArray(nums, index + 1, subSet, result);
    subSet.remove(subSet.size() - 1);
    generateSubSetOfAnArray(nums, index + 1, subSet, result);
  }
}
