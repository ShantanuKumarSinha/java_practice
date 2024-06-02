package shann.java.problems.sorting;

public class BubbleSort {
  int[] array = {12, 11, 13, 5, 6};

  public void sort() {
    int i, j, temp = 0;
    boolean swapped = false;
    for (i = 0; i < array.length - 1; ++i) {
      swapped = false;
      for (j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          temp = array[j];
          array[j] = array[i];
          array[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) break;
    }
  }

  public void getArray() {
    for (Integer i : array) System.out.println(i);
  }

  public static void main(String[] args) {
    InsertionSort insertionSort = new InsertionSort();
    insertionSort.sort();
    insertionSort.getArray();
  }
}
