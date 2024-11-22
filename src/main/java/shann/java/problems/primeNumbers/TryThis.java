package shann.java.problems.primeNumbers;
// TODO
public class TryThis {
  public static void main(String[] args) {
    TryThis t = new TryThis();
    System.out.println(t.solve(new int[] {3, 6, 15, 16}));
  }

  public int solve(int[] A) {
    int maxNum = Integer.MIN_VALUE;
    for (int i : A) {
      maxNum = Math.max(maxNum, i);
    }
    boolean[] primes = new boolean[maxNum + 1];
    for (int i = 0; i < primes.length; i++) {
      primes[i] = true;
    }
    primes[0] = false;
    primes[1] = false;
    for (int i = 2; i <= maxNum; i++) {
      if (primes[i]) {
        for (int j = i * i; j <= maxNum; j += i) {
          primes[j] = false;
        }
      }
    }

    int[] countOfPrimeFactors = new int[maxNum + 1];
    for (int i = 2; i <= maxNum; i++) {
      if (primes[i]) {
        countOfPrimeFactors[i]++;
      }
      for (int j = i * i; j <= maxNum; j += i) {
        countOfPrimeFactors[j]++;
      }
    }
    int maxPrimeFactor = 0;
    for (int i : A) {
      maxPrimeFactor = Math.max(maxPrimeFactor, countOfPrimeFactors[i]);
    }
    return maxPrimeFactor;
  }
}
