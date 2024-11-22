package shann.java.problems.datastructure.bitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem Description

Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.



Problem Constraints

2 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format

First and only argument of input contains an integer array A.



Output Format

Return a single integer denoting minimum xor value.



Example Input

Input 1:

 A = [0, 2, 5, 7]
Input 2:

 A = [0, 4, 7, 9]


Example Output

Output 1:

 2
Output 2:

 3


Example Explanation

Explanation 1:

 0 xor 2 = 2
*/
public class MinXORValue {
  public static void main(String[] args) {
    MinXORValue minXORValue = new MinXORValue();
    var result = minXORValue.findMinXor(new ArrayList<>(List.of(0, 2, 5, 7)));
    System.out.println(result);
  }

  public int findMinXor(List<Integer> list) {
    // sort the array A in ascending order
    Collections.sort(list);
    // the answer will be the min of XOR of each adjacent elements
    int ans = list.get(0) ^ list.get(1);
    for (int i = 1; i < list.size(); i++) {
      ans = Math.min(list.get(i) ^ list.get(i - 1), ans);
    }
    return ans;
  }
}
