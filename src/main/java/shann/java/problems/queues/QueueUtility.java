package shann.java.problems.queues;

public class QueueUtility {
  public static void printELementsOfArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      if (i != arr.length - 1) System.out.print(", ");
    }
    System.out.println();
  }

  public static void printELementsOfArray(boolean[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      if (i != arr.length - 1) System.out.print(", ");
    }
    System.out.println();
  }
}
