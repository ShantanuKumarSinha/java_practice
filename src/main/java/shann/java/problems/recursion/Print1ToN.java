package shann.java.problems.recursion;

public class Print1ToN {
  public static void main(String[] args) {
    printNumbers(10);
  }

  private static void printNumbers(int i) {
    if (i == 0) return;
    printNumbers(i - 1);
    System.out.print(i + " ");
  }
}
