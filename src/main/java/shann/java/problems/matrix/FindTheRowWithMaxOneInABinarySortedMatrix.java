package shann.java.problems.matrix;


public class FindTheRowWithMaxOneInABinarySortedMatrix {
  public static void main(String[] args) {
    FindTheRowWithMaxOneInABinarySortedMatrix findTheRowWithMaxOneInABinarySortedMatrix =
        new FindTheRowWithMaxOneInABinarySortedMatrix();
    int[][] matrix = {{0, 1, 1}, {0, 0, 1}, {0, 1, 1}};

    System.out.println(findTheRowWithMaxOneInABinarySortedMatrix.search(matrix));
  }

  private int search(int[][] matrix) {
    int col = matrix[0].length - 1, row = 0;
    int result = -1, currentRow = 0;
    while (col >= 0 && row < matrix.length) {
      if (matrix[row][col] == 1) {
        if (currentRow > result) currentRow = row;
        col--;

      } else {
        row++;
      }
    }
    return currentRow;
  }
}
