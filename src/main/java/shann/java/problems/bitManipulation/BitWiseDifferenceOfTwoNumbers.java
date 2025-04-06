package shann.java.problems.bitManipulation;

/*
Find bitwise differences of two numbers
Ecample :
Input : A=2 and B = 4
Output : bit wise difference is 2
*/
public class BitWiseDifferenceOfTwoNumbers {
  public static void main(String[] args) {
    var result = bitwiseDifference(4, 2);
    System.out.println(result);
  }

  private static int bitwiseDifference(int a, int b) {
    var xor = a ^ b;
    int count = 0;
    while (xor != 0) {
      if ((xor & 1) == 1) {
        count++;
      }
      xor = xor >> 1;
    }
    return count;
    //    return Integer.bitCount(xor);
  }
}
