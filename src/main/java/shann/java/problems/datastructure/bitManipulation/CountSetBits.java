package shann.java.problems.datastructure.bitManipulation;

public class CountSetBits {
  public static void main(String[] args) {
    Long A = 11L;
    int total_ones = 0;
    while (A != 0) {
      // rightmost set bit becomes unset
      A = A & (A - 1);
      total_ones++;
    }
    System.out.println(total_ones);
  }
  }