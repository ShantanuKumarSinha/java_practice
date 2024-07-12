package shann.java.problems.patterns;

import java.util.Scanner;

public class Triangle {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        System.out.print(0 + " ");
      }

      for (int j = n - 1 - i; j <= n - 1 + i; j++) {
        System.out.print((j+2-n+i) * (n - i)+" ");
      }
      for (int j = 0; j < n - i - 1; j++) {
        System.out.print(0+" ");
      }
      System.out.println();
    }
    for (int i = 1; i < 2 * n; i++) System.out.print(i + " ");
    System.out.println();
  }
}
