package shann.java.problems.numbers;

public class FactorsCount {
  public static void main(String[] args) {
    var result = factorsCount(8);
    System.out.println(result);
  }

  public static int factorsCount(int n) {
    int count = 0;
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        if (i == n / i) count++;
        else count += 2;
      }
    }
    return count;
  }
}
