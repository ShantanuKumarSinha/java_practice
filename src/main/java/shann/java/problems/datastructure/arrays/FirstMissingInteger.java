package shann.java.problems.datastructure.arrays;

public class FirstMissingInteger {
  public static void main(String[] args) {
    // int[] arr = {2,3,1,2};
    int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,20};
    FirstMissingInteger problem = new FirstMissingInteger();
    System.out.println(problem.firstMissingPositive(arr));
  }

  public int firstMissingPositive(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        arr[i] = arr.length + 2;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      var value = Math.abs(arr[i]);
      if (value >= 1 && value <= arr.length) {
        arr[value - 1] = -1 * Math.abs(arr[value - 1]);
      }
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) return i + 1;
    }
    return arr.length+1;
  }
}
