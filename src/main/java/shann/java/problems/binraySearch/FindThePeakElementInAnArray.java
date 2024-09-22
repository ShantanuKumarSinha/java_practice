package shann.java.problems.binraySearch;

/*
* Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
* */

public class FindThePeakElementInAnArray {

  public static void main(String[] args) {
    FindThePeakElementInAnArray findThePeakElementInAnArray = new FindThePeakElementInAnArray();
    System.out.println(findThePeakElementInAnArray.findThePeakElement(new int[] {1, 2, 3, 4, 5}));
    System.out.println(findThePeakElementInAnArray.findThePeakElement(new int[] {5, 17, 100, 11}));
    System.out.println(findThePeakElementInAnArray.findThePeakElement(new int[] {1,1000000000,1000000000}));
  }

  public int findThePeakElement(int[] nums) {
    if (nums.length == 1) return nums[0];
    else if (nums[0] >= nums[1]) return nums[0];
    else if (nums[nums.length - 1] >= nums[nums.length - 2]) return nums[nums.length - 1];
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return nums[mid];
      else if (nums[mid] < nums[mid + 1]) start = mid + 1;
      else end = mid - 1;
    }
    return -1;
  }
}
