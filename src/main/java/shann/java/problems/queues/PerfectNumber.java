package shann.java.problems.queues;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Problem Description
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints
1 <= A <= 100000



Input Format
The only argument given is an integer A.



Output Format
Return a string that denotes the Ath Perfect Number.



Example Input
Input 1:

 A = 2
Input 2:

 A = 3


Example Output
Output 1:

 22
Output 2:

 1111


Example Explanation
Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 2nd Perfect number.
Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 3rd Perfect number.
* */

public class PerfectNumber {
  public static void main(String[] args) {
    System.out.println(findNthPerfectNumber(8));
    System.out.println(findNthPerfectNumber(11));
  }

  private static String findNthPerfectNumber(int n) {
    Deque<String> deque = new ArrayDeque<>();
    deque.addLast("1");
    deque.addLast("2");
    var i = 0;
    while (i <= n) {
      var num = deque.removeFirst();
      var perfectNumber = num + findReverse(num);
      i++;
      if (i == n) return perfectNumber;
      deque.addLast(num + "1");
      deque.addLast(num + "2");
    }
    return null;
  }

  private static String findReverse(String num) {
    StringBuilder sb = new StringBuilder();
    for (int i = num.length() - 1; i >= 0; i--) {
      sb.append(num.charAt(i));
    }
    return sb.toString();
  }
}
