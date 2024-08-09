package shann.java.problems.datastructure.arrays;

import java.util.Arrays;

public class PlusOne {
  public static void main(String[] args) {
    //    int[] A = {1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5};
    //    int[] A = {1, 9, 9, 9};
    int[] A = {0,0, 3, 7, 6, 4, 0, 5, 5, 5};

    int[] tmp = new int[A[0] == 0 ? A.length : A.length + 1];
    int carry = 0;
    if (A.length == tmp.length) {
      for (int i = A.length - 1; i >= 0; i--) {
        if (i == A.length - 1) {
          if (A[i] == 9) {
            tmp[i] = 0;
            carry = 1;
          } else {
            tmp[i] = ++A[i];
          }
        } else if (carry == 1) {
          if (A[i] == 9) {
            tmp[i] = 0;
            carry = 1;
          }
        } else {
          tmp[i] = A[i];
          carry = 0;
        }
      }
    } else {
      for (int i = A.length - 1; i >= 0; i--) {
        if (i == A.length - 1) {
          if (A[i] == 9) {
            tmp[i + 1] = 0;
            carry = 1;
          } else {
            tmp[i + 1] = ++A[i];
          }
        } else if (carry == 1) {
          if (A[i] == 9) {
            tmp[i + 1] = 0;
            carry = 1;
          } else {
            tmp[i + 1] = ++A[i];
            carry = 0;
          }
        } else {
          tmp[i + 1] = A[i];
        }
      }
    }
    if (carry == 1) {
      tmp[0] = 1;
    }
    int zeroCount = 0;
    for(int i=0; i<tmp.length; i++) {
      if (tmp[i] == 0) {
        zeroCount++;
      } else
        break;

    }
    int[] result = new int[tmp.length-zeroCount];
    for(int i=0; i<result.length; i++) {
      result[i] = tmp[i+zeroCount];
    }
    System.out.println(Arrays.stream(result).boxed().toList());
  }
}
