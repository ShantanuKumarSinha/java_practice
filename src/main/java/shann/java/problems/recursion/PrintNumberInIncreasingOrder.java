package shann.java.problems.recursion;

public class PrintNumberInIncreasingOrder {
  public static void main(String[] args) {
    PrintNumberInIncreasingOrder printNumberInIncreasingOrder = new PrintNumberInIncreasingOrder();
    print(5);
  }

  private static void print(int n) {
    if (n == 1) {
      System.out.println(1);
      return;
    }
    print(n - 1);
    System.out.println(n);
  }
}
