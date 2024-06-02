package shann.java.problems.sorting;

public class InsertionSort {


  int[] array = {12, 11, 13, 5, 6};

  public void sort(){
    var n = array.length;
    for (int i =1; i<n; ++i) {
        var key = array[i];
        var j =i-1;
      while(j>=0 && array[j]>key){
        array[j+1]=array[j];
        j = j-1;
      }
      array[j+1]=key;
    }
  }

  public void getArray() {
    for (Integer i : array)
      System.out.println(i);
  }

  public static void main(String[] args) {
    InsertionSort insertionSort = new InsertionSort();
    insertionSort.sort();
    insertionSort.getArray();
  }
}
