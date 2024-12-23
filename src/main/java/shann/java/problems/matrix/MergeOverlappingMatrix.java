package shann.java.problems.matrix;

public class MergeOverlappingMatrix {
  public static void main(String[] args) {
    MergeOverlappingMatrix matrix = new MergeOverlappingMatrix();
    int[][] A = {{1, 3}, {8, 10}};
    int[] B = {4, 6};
    var result = matrix.insert(A, B);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " " + result[i][0] + " , " + result[i][1]);
    }
  }

  // non overlapping scenario
  // {1,4} & {5,7} or {3,6} & {1,2}
  // overlapping {1,5}&{5,9} or {1,4}&{3,7} or {1,5}&{1,7} or {3,5}&{2,8}
  public int[][] insert(int[][] A, int[] B) {
    int[][] tmpResult = new int[A.length + 1][2];
    int left = B[0], right = B[1];
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      if (left > A[i][1]) {
        tmpResult[count][0] = A[i][0];
        tmpResult[count][1] = A[i][1];
        count++;
      } else if (right < A[i][0]) {
        tmpResult[count][0] = left;
        tmpResult[count][1] = right;
        left = A[i][0];
        right = A[i][1];
        count++;
      } else {
        if (left > A[i][0]) left = A[i][0];
        if (right < A[i][1]) right = A[i][1];
      }
    }
    tmpResult[count][0] = left;
    tmpResult[count][1] = right;
    count++;
    int[][] result = new int[count][2];
    for (int i = 0; i <count; i++) {
      result[i][0] = tmpResult[i][0];
      result[i][1] = tmpResult[i][1];
    }
    return result;
  }
}
