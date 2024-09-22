package shann.java.problems.binraySearch;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.List;

/*
* Problem Description
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.


Problem Constraints
1 <= N + M <= 2*106



Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.



Output Format
Return a decimal value denoting the median of two sorted arrays.



Example Input
Input 1:

 A = [1, 4, 5]
 B = [2, 3]
Input 2:

 A = [1, 2, 3]
 B = [4]


Example Output
Output 1:

 3.0
Output 2:

 2.5


Example Explanation
Explanation 1:

 The median of both the sorted arrays will be 3.0.
Explanation 2:

 The median of both the sorted arrays will be (2+3)/2 = 2.5.
* */
//TODO
public class FindTheMedianOfSortedArray {
  public static void main(String[] args) {
    var list1 = List.of(1, 4, 5);
    var list2 = List.of(2, 3);
    FindTheMedianOfSortedArray findTheMedianOfSortedArray = new FindTheMedianOfSortedArray();
    System.out.println(findTheMedianOfSortedArray.findMedian(list1, list2));

    System.out.println(
        findTheMedianOfSortedArray.findMedian(List.of(-49, 33, 35, 42), List.of(-26)));

    System.out.println(
        findTheMedianOfSortedArray.findMedian(
            List.of(-37, -10, -5, 5, 17, 34, 39), List.of(-30, -27, -21, -21, 41)));
  }

  private double findMedian(List<Integer> list1, List<Integer> list2) {
    if (list1.size() > list2.size()) return findMedian(list2, list1);
    int left = 0, n = list1.size(), m = list2.size(), right = list1.size();
    if (n == 0) {
      if (m % 2 == 0) return ((double) list1.get(m / 2) + list2.get(m / 2 - 1)) / 2;
      else return list2.get(m / 2);
    } else if (m == 0) {
      if (n % 2 == 0) return ((double) list2.get(n / 2) + list1.get(n / 2 - 1)) / 2;
      else return list1.get(n / 2);
    }
    while (left <= right) {
      var cut1 = left + (right - left) / 2;
      var cut2 = (n + m + 1) / 2 - cut1;
      var l1 = cut1 == 0 ? Integer.MIN_VALUE : list1.get(cut1 - 1);
      var l2 = cut2 == 0 ? Integer.MIN_VALUE : list2.get(cut2 - 1);
      var r1 = cut1 == n ? Integer.MAX_VALUE : list1.get(cut1);
      var r2 = cut2 == m ? Integer.MAX_VALUE : list2.get(cut2);
      if (l1 <= r2 && l2 <= r1) {
        if ((n + m) % 2 == 0) return ((double) (max(l1, l2) + min(r1, r2)) / 2);
        else return max(l1, l2);
      } else if (l1 > r2) right = cut1 - 1;
      else left = cut1 + 1;
    }
    throw new IllegalArgumentException("Input arrays are not sorted.");
  }
}
