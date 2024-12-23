package shann.java.problems.binraySearch;

public class IsPaintPossible {
  public static void main(String[] args) {
    System.out.println(isPaintPossible(new int[] {5, 3, 6, 1, 9}, 7, 1, 2));
    System.out.println(isPaintPossible(new int[] {5, 3, 6, 1, 9}, 15, 1, 2));
    System.out.println(isPaintPossible(new int[] {5, 3, 6, 1, 9}, 10, 1, 2));
  }

  protected static boolean isPaintPossible(int arr[], long maxAllowedTime, int t, int painter) {
    int numberOfPainters = 1;
    long timetaken = 0;
    for (int i = 0; i < arr.length; i++) {
      if (maxAllowedTime < (long)arr[i] * t) return false;
      timetaken += (long)arr[i] * t;
      if (timetaken > maxAllowedTime) {
        numberOfPainters++;
        timetaken = arr[i] * t;
        if (numberOfPainters > painter) return false;
      }
    }
    return true;
  }
}
