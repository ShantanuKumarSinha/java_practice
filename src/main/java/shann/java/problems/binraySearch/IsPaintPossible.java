package shann.java.problems.binraySearch;

public class IsPaintPossible {
  public static void main(String[] args) {
    System.out.println(isPaintPossible(new int[] {5, 3, 6, 1, 9}, 7, 1, 2));
    System.out.println(isPaintPossible(new int[] {5, 3, 6, 1, 9}, 15, 1, 2));
    System.out.println(isPaintPossible(new int[] {5, 3, 6, 1, 9}, 10, 1, 2));
  }

  protected static boolean isPaintPossible(int arr[], int maxAllowedTime, int t, int painter) {
    int numberOfPainters = 1, timetaken = 0;
    for (int i = 0; i < arr.length; i++) {
      if (maxAllowedTime < arr[i] * t) return false;
      timetaken += arr[i] * t;
      if (timetaken > maxAllowedTime) {
        numberOfPainters++;
        timetaken = arr[i] * t;
        if (numberOfPainters > painter) return false;
      }
    }
    return true;
  }
}
