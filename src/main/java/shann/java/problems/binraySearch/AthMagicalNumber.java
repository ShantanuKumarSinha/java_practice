package shann.java.problems.binraySearch;

/*
* You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.



Problem Constraints
1 <= A <= 109

2 <= B, C <= 40000



Input Format
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.



Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


Example Output
Output 1:

 2
Output 2:

 6


Example Explanation
Explanation 1:

 1st magical number is 2.
Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.

* */

public class AthMagicalNumber {

  public static void main(String[] args) {
    System.out.println(findAthMagicalNumber(12, 5, 7, 0));
    var result2 = findAthMagicalNumber(807414236, 3788, 38141, 0);
    var modulo = 1000000007;
    System.out.println(result2 % modulo);
  }

  private static long findAthMagicalNumber(int n, int firstFactor, int secondFactor, long ans) {
    long start = 1, end = (long) n * (long) Math.min(firstFactor, secondFactor);
    while (start <= end) {
      long mid = start + (end - start) / 2;
      var magicalNumber = countMagical(mid, firstFactor, secondFactor);
      if (magicalNumber > n) {
        end = mid - 1;
      } else if (magicalNumber < n) start = mid + 1;
      else {
        ans = mid;
        end = mid - 1;
      }
    }
    return ans;
  }

  private static long countMagical(long mid, int firstFactor, int secondFactor) {
    return mid / firstFactor + mid / secondFactor - mid / findLCM(firstFactor, secondFactor);
  }

  private static int findLCM(int a, int b) {
    var hcf = findGCD(a, b);
    return a * b / hcf;
  }

  private static int findGCD(int a, int b) {
    if (a == 0) return b;
    return findGCD(b % a, a);
  }
}
