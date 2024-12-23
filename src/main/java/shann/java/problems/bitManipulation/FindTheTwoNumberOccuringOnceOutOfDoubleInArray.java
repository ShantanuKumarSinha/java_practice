package shann.java.problems.bitManipulation;

public class FindTheTwoNumberOccuringOnceOutOfDoubleInArray {
  public static void main(String[] args) {
    //int[] A = {186, 256, 102, 377, 186, 377};
    int[] A =  {2308, 1447, 1918, 1391, 2308, 216, 410, 1021, 537, 1825, 1021, 1729, 669, 216,1825,537, 1995, 805, 410, 805, 602, 1918, 1447,90, 1995,880,1391,669,602,90};
    int xOrA = 0;
    for (int i = 0; i < A.length; i++) {
      xOrA = xOrA ^ A[i];
    }

    System.out.println(Integer.toBinaryString(xOrA));
    int pos = 0;
    for (int i = 0; i < 32; i++) {
      if (checkBit(xOrA, i)) {
        pos = i;
        break;
      }
    }
    int group1 = 0, group2 = 0;
    for (int i = 0; i < A.length; i++) {
      if (checkBit(A[i], pos)) group1 = group1 ^ A[i];
      else group2 = group2 ^ A[i];
    }
    System.out.println(group1);
    System.out.println(group2);
  }

  private static boolean checkBit(int n, int i) {
    if ((n & (1 << i)) > 0) return true;
    return false;
  }
}
