package shann.java.problems.binraySearch;

/*
* Problem Description
Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

Elements which are appearing twice are adjacent to each other.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the single element that appears only once.



Example Input
Input 1:

A = [1, 1, 7]
Input 2:

A = [2, 3, 3]


Example Output
Output 1:

 7
Output 2:

 2


Example Explanation
Explanation 1:

 7 appears once
Explanation 2:

 2 appears once
* */

public class SingleElementInAnArray {
  public static void main(String[] args) {
    int[] arr1 = {1, 1, 7};
    System.out.println(findSingleElement(arr1));

    int[] arr2 = {1, 1, 2, 2, 3, 3, 4, 5, 5};
    System.out.println(findSingleElement(arr2));

    int[] arr3 = {
      13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124,
      124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238,
      261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474,
      474, 493, 493
    };
    System.out.println(findSingleElement(arr3));
  }

  private static int findSingleElement(int[] arr) {
    int start = 0, end = arr.length - 1;
    int ans = -1;
    if (arr.length == 1) return arr[start];
    else if (arr[0] != arr[1]) return arr[0];
    else if (arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) return arr[mid];
      if (arr[mid] == arr[mid - 1]) mid = mid - 1;
      if (mid % 2 == 0) start = mid + 2;
      else end = mid - 1;
    }
    return ans;
  }
}
