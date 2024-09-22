package shann.java.problems.combinatorics;

import java.util.HashMap;

/*
 Problem Description
Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB


Problem Constraints
1 <= A <= 109



Input Format
First and only argument of input contains single integer A



Output Format
Return a string denoting the corresponding title.



Example Input
Input 1:

A = 3
Input 2:


A = 27


Example Output
Output 1:

"C"
Output 2:

"AA"


Example Explanation
Explanation 1:


3 corrseponds to C.
Explanation 2:

    1 -> A,
    2 -> B,
    3 -> C,
    ...
    26 -> Z,
    27 -> AA,
    28 -> AB
*/
public class ExcelColumnTitle {
  public static void main(String[] args) {
    System.out.println(findExcelTitle(703));
    System.out.println(findExcelTitle(350));
    System.out.println(findExcelTitle(52));
  }

  private static String findExcelTitle(int num) {
    var stringMap = new HashMap<Integer, Character>();
    stringMap.put(1, 'A');
    stringMap.put(2, 'B');
    stringMap.put(3, 'C');
    stringMap.put(4, 'D');
    stringMap.put(5, 'E');
    stringMap.put(6, 'F');
    stringMap.put(7, 'G');
    stringMap.put(8, 'H');
    stringMap.put(9, 'I');
    stringMap.put(10, 'J');
    stringMap.put(11, 'K');
    stringMap.put(12, 'L');
    stringMap.put(13, 'M');
    stringMap.put(14, 'N');
    stringMap.put(15, 'O');
    stringMap.put(16, 'P');
    stringMap.put(17, 'Q');
    stringMap.put(18, 'R');
    stringMap.put(19, 'S');
    stringMap.put(20, 'T');
    stringMap.put(21, 'U');
    stringMap.put(22, 'V');
    stringMap.put(23, 'W');
    stringMap.put(24, 'X');
    stringMap.put(25, 'Y');
    stringMap.put(26, 'Z');
    StringBuilder stringBuilder = new StringBuilder();
    while (num > 0) {
      var rem = num % 26;
      num /= 26;
      if(rem ==0) {
        rem =26;
        num -=1;
      }
      stringBuilder.append(stringMap.get(rem));
    }

    return stringBuilder.reverse().toString();
  }
}
