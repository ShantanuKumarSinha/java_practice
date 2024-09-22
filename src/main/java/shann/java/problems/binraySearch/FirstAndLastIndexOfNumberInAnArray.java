package shann.java.problems.binraySearch;

/*
* Problem Description
Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Your algorithm's runtime complexity must be in the order of O(log n).


Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].


Example Input
Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]


Example Explanation
Explanation 1:

 The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:

 There is no occurrence of 3 in the array.

* */

public class FirstAndLastIndexOfNumberInAnArray {
  public static void main(String[] args) {
    int[] arr1 = {5, 7, 7, 8, 8, 10};
    int searchItem1 = 8;
    var result1 = findFirstAndLastIndexOfNumberInAnArray(arr1, searchItem1);
    System.out.println(result1[0] + " " + result1[1]);

    int[] arr2 = {5, 17, 100, 111};
    int searchItem2 = 3;
    var result2 = findFirstAndLastIndexOfNumberInAnArray(arr2, searchItem2);
    System.out.println(result2[0] + " " + result2[1]);
  }

  private static int[] findFirstAndLastIndexOfNumberInAnArray(int[] arr, int searchItem) {
    int[] result = new int[2];
    result[0] = findFirstIndexOfNumberInAnArray(arr, searchItem);
    result[1] = findLastIndexOfNumberInAnArray(arr, searchItem);
    return result;
  }

  private static int findFirstIndexOfNumberInAnArray(int[] arr, int searchItem) {
    int start = 0;
    int end = arr.length - 1;
    int ans = -1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == searchItem) {
        ans = mid;
        end = mid - 1;
      } else if (arr[mid] > searchItem) end = mid - 1;
      else start = mid + 1;
    }
    return ans;
  }

  private static int findLastIndexOfNumberInAnArray(int[] arr, int searchItem) {
    int ans = -1;
    int start = 0, end = arr.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == searchItem) {
        ans = mid;
        start = mid + 1;
      } else if (arr[mid] > searchItem) end = mid - 1;
      else start = mid + 1;
    }
    return ans;
  }
}
