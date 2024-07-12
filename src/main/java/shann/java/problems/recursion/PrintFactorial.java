package shann.java.problems.recursion;

public class PrintFactorial {
  public static void main(String[] args) {
    PrintFactorial printFactorial = new PrintFactorial();
    int factorial = printFactorial.calucateFactorial(5);
    System.out.println(factorial);
  }

  private static int calucateFactorial(int n) {
    if (n == 1) return 1;
    return n * calucateFactorial(n - 1);
  }
}
