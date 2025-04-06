package shann.java.problems.binraySearch;

/*
 */
public class MaximumHeightOfStairCase {
  public static void main(String[] args) {
    System.out.println(maxHeight(10));
    System.out.println(maxHeight(20));
    System.out.println(maxHeight(35234));
  }

  private static int maxHeight(int n) {
    if (n == 0 || n == 1) return n;
    long start = 1;
    long end = n - 1;
    long ans = 0;
    while (start <= end) {
      long mid = start + (end - start) / 2;
      if (mid * (mid + 1) / 2 <= n) {
        ans = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return (int) ans % 100000007;
  }
}
