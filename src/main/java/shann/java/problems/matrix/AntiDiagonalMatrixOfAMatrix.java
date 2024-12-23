package shann.java.problems.matrix;

import java.util.ArrayList;
import java.util.List;

public class AntiDiagonalMatrixOfAMatrix {

  public static void main(String[] args) {
    AntiDiagonalMatrixOfAMatrix antiDiagonalMatrixOfAMatrix = new AntiDiagonalMatrixOfAMatrix();
    var row1 = new ArrayList(List.of(1, 2, 3, 4));
    var row2 = new ArrayList(List.of(5, 6, 7, 8));
    var row3 = new ArrayList(List.of(9, 10, 11, 12));
    ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    arrayList.add(row1);
    arrayList.add(row2);
    arrayList.add(row3);
    var result = antiDiagonalMatrixOfAMatrix.diagonal(arrayList);
    System.out.println(result);
  }

  public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
    var size = A.size() < A.get(0).size() ? A.size() : A.get(0).size();
    ArrayList<ArrayList<Integer>> diagonalArrayList = new ArrayList<>();
    for (int col = 0; col < A.get(0).size(); col++) {
      ArrayList<Integer> tmpArrayList = new ArrayList<>();
      int row = 0, newCol = col;
      while (row < A.size() && newCol >= 0) {
        tmpArrayList.add(A.get(row).get(newCol));
        row++;
        newCol--;
      }
      int count = size - tmpArrayList.size();
      while (count > 0) {
        tmpArrayList.add(0);
        count--;
      }
      diagonalArrayList.add(tmpArrayList);
    }
    for (int row = 1; row < A.size(); row++) {
      int newRow = row, col = A.get(row).size() - 1;
      ArrayList<Integer> tmpArrayList = new ArrayList<>();
      while (newRow < A.size() && col >= 0) {
        tmpArrayList.add(A.get(newRow).get(col));
        newRow++;
        col--;
      }
      int count = size - tmpArrayList.size();
      while (count > 0) {
        tmpArrayList.add(0);
        count--;
      }
      diagonalArrayList.add(tmpArrayList);
    }
    return diagonalArrayList;
  }
}
