package shann.java.problems.datastructure.arrays;

public class RainWaterTrappedWithSpaceComplexityOne {
  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 3, 2, 1, 2, 1};
    int result = trap(arr);
    System.out.println(result);
  }

  private static int trap(int[] height) {
    int totalWater = 0;
    int max = Integer.MIN_VALUE, maxValueIndex = -1;

    for (int i = 0; i < height.length; i++) {
      if (height[i] > max) {
        max = height[i];
        maxValueIndex = i;
      }
    }
    int lMax = height[0];
    for (int i = 0; i < maxValueIndex; i++) {
      lMax = Math.max(lMax, height[i]);
      // Math.min(lMax, max) will be lMax;
      totalWater += lMax - height[i];
    }
    int rMax = height[height.length - 1];
    for (int i = height.length - 1; i > maxValueIndex; i--) {
      rMax = Math.max(rMax, height[i]);
      // Math.min(rMax, max) will be rMax;
      totalWater += rMax - height[i];
    }
    return totalWater;
  }
}
