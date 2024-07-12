package shann.java.problems.recursion;

public class AllIndicesOfArray {
  public static void main(String[] args){
    var result =allIndices(new int[]{1,5,4,19,5,7,17,49,5},5);
    for(Integer i : result){
      System.out.println(i);
    }
  }

  private static  int[] allIndices(int[] A, int B) {
    int size = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == B) size++;
    }
    int[] result = new int[size];
    return run(result, 0, A, B, 0);
  }

  private static int[] run(int[] result, int index, int[] A, int B, int count) {
    if (index == A.length) return result;
    if (A[index] == B) {
      result[count] = index;
      count++;
    }
    return run(result, index + 1, A, B, count);
  }
}
