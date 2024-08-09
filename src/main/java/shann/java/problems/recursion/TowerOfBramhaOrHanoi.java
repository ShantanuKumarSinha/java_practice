package shann.java.problems.recursion;

// Tower Of Hanoi or Bramha
public class TowerOfBramhaOrHanoi {

  private static int n = 3;
  private static int rows = (int) Math.pow(2, n) - 1;
  private static int[][] result = new int[rows][n];

  public static void main(String[] args) {

    towerOfHanoi(n, 1, 2, 3);

    towerOfBramha(n, 1, 2, 3, 0);
    for (int[] row : result) {
      for (int num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }

  private static void towerOfHanoi(int n, int start, int host, int end) {
    if (n == 0) return;
    towerOfHanoi(n - 1, start, end, host);
    System.out.println("Move Disk " + n + " from " + start + " to " + end);
    towerOfHanoi(n - 1, host, start, end);
  }

  // TODO
  private static void towerOfBramha(int n, int start, int host, int end, int rowCount) {
    if (n == 0) {
      return;
    }

    towerOfBramha(n - 1, start, end, host, rowCount);
    result[rowCount++] = new int[] {n, start, host};

    towerOfBramha(n - 1, host, start, end, ++rowCount);

    result[rowCount++] = new int[] {n, host, end};
  }
}
