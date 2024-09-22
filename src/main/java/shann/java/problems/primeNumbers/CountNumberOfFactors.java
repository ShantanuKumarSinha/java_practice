package shann.java.problems.primeNumbers;

import java.util.Arrays;

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
public class CountNumberOfFactors {
    public static void main(String[] args){
        var results = countOfFactors(new int[] {2,3,4,5});
        System.out.println(Arrays.toString(results));
    }

    private static int[] countOfFactors(int[] arr) {
        int[] result = new int[arr.length];
        var max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        int[] factors = new int[max + 1];

        for(int i = 1; i <=max; i++){
            factors[i]++;
            for(int j = 2*i; j <= max; j+=i){
                factors[j]++;
            }
        }
        for(int i = 0; i < arr.length; i++){
            result[i] = factors[arr[i]];
        }

        return result;
    }
}
