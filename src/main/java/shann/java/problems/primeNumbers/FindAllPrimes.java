package shann.java.problems.primeNumbers;

/*
Problem Description
Given an integer A. Find the list of all prime numbers in the range [1, A].


Problem Constraints
1 <= A <= 106



Input Format
Only argument A is an integer.



Output Format
Return a sorted array of prime number in the range [1, A].



Example Input
Input 1:
A = 7
Input 2:
A = 12


Example Output
Output 1:
[2, 3, 5, 7]
Output 2:
[2, 3, 5, 7, 11]


Example Explanation
For Input 1:
The prime numbers from 1 to 7 are 2, 3, 5 and 7.
For Input 2:
The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.
*/
public class FindAllPrimes {
  public static void main(String[] args) {
    var result = findAllPrimes(30);
    PrintItemsInArray.printItemsInArray(result);
  }

  private static int[] findAllPrimes(int n) {
    boolean[] isPrime = new boolean[n + 1];

    for (int i = 0; i < isPrime.length; i++) {
      isPrime[i] = true;
    }
    isPrime[0] = false;
    isPrime[1] = false;
    int nonPrimeCount = 2;
    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= n; j += i) {
          if (isPrime[j]) {
            nonPrimeCount++;
            isPrime[j] = false;
          }
        }
      }
    }
    int[] primes = new int[n + 1 - nonPrimeCount];
    int index = 0;
    for (int i = 2; i < isPrime.length; i++) {
      if (isPrime[i]) primes[index++] = i;
    }
    return primes;
  }
}
