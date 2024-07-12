package shann.java.problems.datastructure.Matrix;

import java.util.ArrayList;
import java.util.List;

public class TransposeOfAMatrix {

  public static void main(String[] args) {
    TransposeOfAMatrix transposeOfAMatrix = new TransposeOfAMatrix();
    var row1 = new ArrayList(List.of(1, 2, 3, 4));
    var row2 = new ArrayList(List.of(5, 6, 7, 8));
    ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    arrayList.add(row1);
    arrayList.add(row2);
    var resultMatrix = transposeOfAMatrix.solve(arrayList);
    System.out.println(resultMatrix);
  }

  public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
    System.out.println(A);
    ArrayList<ArrayList<Integer>> resultArrayList = new ArrayList<>();
    for (int row = 0; row < A.size(); row++) {

      for (int col = 0; col < A.get(row).size(); col++) {
        if (A.get(row).size() > resultArrayList.size()) {
          ArrayList<Integer> tempArrayList = new ArrayList<>();
          // add first item in each row
          tempArrayList.add(A.get(row).get(col));
          resultArrayList.add(tempArrayList);
        } else {
          // add items in rows now
          resultArrayList.get(col).add(row, A.get(row).get(col));
        }
      }
    }
    return resultArrayList;
  }
}
