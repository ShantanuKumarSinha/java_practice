package shann.java.problems.datastructure.arrays;

public class RainWaterTrappedUsingArray {
  private static int[] right;

  public static void main(String[] args) {

    int[] arr1 = {1, 0, 2, 3, 1};
    var result1 = trap(arr1);
    System.out.println(result1);

    int[] arr2 = {0, 1, 0, 2, 1, 0, 3, 2, 1, 2, 1};
    var result2 = trap(arr2);
    System.out.println(result2);
  }

  private static int trap(int[] height) {
    int totalWater = 0;
    int[] water = new int[height.length];
    int[] left = new int[height.length];
    int[] right = new int[height.length];
    for (int i = 1; i < height.length; i++) {
      if (height[i - 1] > left[i - 1]) left[i] = height[i - 1];
      else left[i] = left[i - 1];
    }
    for (int i = height.length - 2; i >= 0; i--) {
      if (height[i + 1] > right[i + 1]) right[i] = height[i + 1];
      else right[i] = right[i + 1];
    }
    for (int i = 0; i < height.length; i++) {
      water[i] = Math.min(left[i], right[i]) - height[i];
    }
    //    i =0 & i = height.length-1 does not contribute
    for (int i = 1; i < height.length - 1; i++) {
      if (water[i] > 0) totalWater = totalWater + water[i];
    }
    return totalWater;
  }
}
