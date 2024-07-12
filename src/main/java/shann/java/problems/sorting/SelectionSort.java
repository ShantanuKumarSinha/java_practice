package shann.java.problems.sorting;

import java.util.ArrayList;
import java.util.List;
// you can sort either to find max or min element
public class SelectionSort {

  public static void main(String[] args) {
    SelectionSort selectionSort = new SelectionSort();
    var list = new ArrayList<Integer>(List.of(3, 8, 2, -1, 5, -3));
    var sortedList = selectionSort.sort(list);
    System.out.println(sortedList);
  }

// it will be like finding nth max element in the list
  private List<Integer> sort(ArrayList<Integer> list) {

    // find max element
    int k=1;
    while (k < list.size()) {
      int temp = 0, max = Integer.MIN_VALUE;
      for (int i = 0; i < list.size(); i++) {
        if (max < list.get(i)) {
          max = list.get(i);
        }
      }
      temp = list.get(list.size() - k );
  }
    return null;
  }
}
