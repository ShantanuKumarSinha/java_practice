package shann.java.problems.twoPointers;

/*
Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:

A = [1, 5, 7, 10]
B = 8


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 There are 3 pairs.
Explanation 2:

 There is only one pair, such that i = 0, and j = 2 sums up to 8.
* */
public class CountPairWithGivenSum {
  public static void main(String[] args) {
    var result1 = getPairWithGivenSum(new int[] {1, 1, 1}, 2);
    System.out.println(result1);
    var result2 = getPairWithGivenSum(new int[] {1,2,6,6,7,9,9}, 13);
    System.out.println(result2);
    var result3 = getPairWithGivenSum(new int[] {2,2,3,4,4,5,6,7,10}, 8);
    System.out.println(result3);
  }

  private static int getPairWithGivenSum(int[] arr, int sum) {
    int i = 0, j = arr.length - 1;
    int count = 0;
    while (i < j) {
      if (arr[i] + arr[j] == sum) {
        if(arr[i]==arr[j]) {
          int cnt = j-i+1;
          cnt = cnt*(cnt-1)/2;
          count += cnt;
          break;
        }
        int countI=0;
        for(int x=i; x<j; x++) {
          if(arr[i]==arr[x]) countI++;
          else break;
        }
        int countJ=0;
        for(int x=j; x>i; x--) {
          if(arr[x]==arr[j]) countJ++;
          else break;
        }
        count += countI*countJ;
        i += countI;
        j -= countJ;
      } else if (arr[i] + arr[j] < sum) i++;
      else j--;
    }
    return count;
  }
}
