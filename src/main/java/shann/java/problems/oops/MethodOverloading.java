package shann.java.problems.oops;

public class MethodOverloading {
  public static void main(String[] args) {
    MethodOverloading m = new MethodOverloading();
    System.out.println(m.add(2, 3));
    System.out.println(m.add(2.5, 3.5));
  }

  public int add(int a, int b) {
    return a + b;
  }

  public double add(double a, double b) {
    return a + b;
  }
}
