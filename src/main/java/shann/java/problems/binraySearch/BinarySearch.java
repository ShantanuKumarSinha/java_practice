package shann.java.problems.binraySearch;

/*
Problem Description

You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
Your solution should have a time complexity of O(log(N)).


Problem Constraints

1 <= N <= 105
1 <= A[i] <= 105
1 <= B <= 105



Input Format

The first argument is an integer array A of size N.
The second argument is an integer B.



Output Format

Return an integer denoting the index of target value.



Example Input

Input 1:

A = [1, 3, 5, 6]
B = 5
Input 2:

A = [1, 4, 9]
B = 3


Example Output

Output 1:

2
Output 2:

1


Example Explanation

Explanation 1:

The target value is present at index 2.
Explanation 2:

The target value should be inserted at index 1.

*/
public class BinarySearch {

  public static void main(String[] args) {

    var arr1 = new int[] {1, 3, 5, 6, 7, 22};
    var searchValue1 = 22;
    var result1 = findIndex2(arr1, 0, arr1.length - 1, searchValue1);
    System.out.println(result1);

    var arr2 = new int[] {1, 4, 9};
    var searchValue2 = 3;
    var result2 = findIndex2(arr2, 0, arr2.length - 1, searchValue2);
    System.out.println(result2);

    var arr3 = new int[] {1, 3, 5, 6};
    var searchValue3 = 7;
    var result3 = findIndex2(arr3, 0, arr3.length - 1, searchValue3);
    System.out.println(result3);

    var arr4 =
        new int[] {
          141, 144, 145, 154, 229, 235, 243, 266, 344, 351, 466, 499, 512, 565, 641, 675, 690, 726,
          805, 879, 978, 986
        };
    var searchValue4 = 65;
    var result4 = findIndex(arr4, 0, arr4.length - 1, searchValue4);
    System.out.println(result4);

    int[] arr5 = {1,2,5,7};
    var searchValue5 = 3;
    var result5 = findIndex(arr5, 0, arr5.length - 1, searchValue5);
    System.out.println(result5);
  }

  private static int findIndex(
      int[] nums, int startingIndex, int endingIndex, int numberToBeSearched) {
    if (startingIndex > endingIndex) return startingIndex;
    int mid = startingIndex + (endingIndex - startingIndex) / 2;

    if (numberToBeSearched == nums[mid]) {
      return mid;
    } else if (numberToBeSearched < nums[mid]) {
      return findIndex(nums, startingIndex, mid - 1, numberToBeSearched);
    } else {
      return findIndex(nums, mid + 1, endingIndex, numberToBeSearched);
    }
  }

  private static int findIndex2(
      int[] nums, int startingIndex, int endingIndex, int numberToBeSearched) {
    while (startingIndex <= endingIndex) {
      var mid = startingIndex + (endingIndex - startingIndex) / 2;
      if (numberToBeSearched == nums[mid]) return mid;
      else if (numberToBeSearched < nums[mid]) endingIndex = mid - 1;
      else startingIndex = mid + 1;
    }
    return startingIndex;
  }
}
