package shann.java.problems.recursion;

public class PrintDecreasingThenIncreasing {
  // pattern like this : - 5432112345
  public static void main(String[] args) {
    print(5);
  }

  private static void print(int number) {
    if (number == 0) return;
    System.out.print(number);
    print(number - 1);
    System.out.print(number);
  }
}
