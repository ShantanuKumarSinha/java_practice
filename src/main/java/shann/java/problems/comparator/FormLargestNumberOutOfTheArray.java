package shann.java.problems.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class FormLargestNumberOutOfTheArray {
  public static void main(String[] args) {
    int[] arr = {3, 30, 34, 5, 9};
    //int[] arr = {0, 0, 0, 0};
    var boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.sort(boxedArray, new CompareTwoNumbers().reversed());
    
    StringBuilder stringBuilder = new StringBuilder();
    Arrays.stream(boxedArray).forEach(stringBuilder::append);
    System.out.println(stringBuilder.toString());
  }
}

class CompareTwoNumbers implements Comparator<Integer> {

  @Override
  public int compare(Integer x, Integer y) {
    var digitInX = findNumberOfDigits(x);
    var digitInY = findNumberOfDigits(y);
    var xy = x * (int) Math.pow(10, digitInY) + y;
    var yx = y * (int) Math.pow(10, digitInX) + x;
    if (xy < yx) return -1;
    else if (xy > yx) return 1;
    return 0;
  }

  private int findNumberOfDigits(int n) {
    int count = 0;
    while (n > 0) {
      n = n / 10;
      count++;
    }
    return count;
  }
}
