package shann.java.problems.primeNumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Problem Description
Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: The order of the resultant array should be the same as the input array.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106



Input Format
The only argument given is the integer array A.



Output Format
Return the count of divisors of each element of the array in the form of an array.



Example Input
Input 1:

 A = [2, 3, 4, 5]
Input 2:

 A = [8, 9, 10]


Example Output
Output 1:

 [2, 2, 3, 2]
Output 1:

 [4, 3, 4]


Example Explanation
Explanation 1:

 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].
*/
public class CountNumberOfFactorsUsingFactorMultiplication {
  public static void main(String[] args) {
    var results = countOfFactors(new int[] {8,9,10});
    System.out.println(Arrays.toString(results));
  }

  private static int[] countOfFactors(int[] arr) {
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      int[] spf = getSmallestPrimeFactors(arr[i]);
      var map = fillMap(spf,arr[i]);
      var count =1;
      for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        count *= entry.getValue()+1;
      }
      result[i] = count;
    }
    return result;
  }

  private static int[] getSmallestPrimeFactors(int num) {
    int[] spf = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      spf[i] = i;
    }
    for (int i = 2; i*i <= num; i++) {
      for (int j = i * i; j <= num; j += i) {
        if (spf[j] == j) {
          spf[j] = i;
        }
      }
    }
    return spf;
  }

  private  static Map<Integer,Integer> fillMap(int[] spf, int num){
    Map<Integer,Integer> map = new HashMap<>();
    while(num>1){
      if(map.containsKey(spf[num]))
        map.put(spf[num],map.get(spf[num])+1);
      else
        map.put(spf[num],1);
      num /=spf[num];
    }
    return map;
  }
}
