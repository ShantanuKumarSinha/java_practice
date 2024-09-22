package shann.java.problems.primeNumbers;

import java.util.Arrays;

/*
* Problem Description
Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003



Problem Constraints
1 <= |A| <= 1000



Input Format
First argument is a string A.



Output Format
Return an integer denoting the rank of the given string.



Example Input
Input 1:

A = "acb"
Input 2:

A = "a"


Example Output
Output 1:

2
Output 2:

1


Example Explanation
Explanation 1:

Given A = "acb".
The order permutations with letters 'a', 'c', and 'b' :
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.
Explanation 2:

Given A = "a".
Rank is clearly 1.
* */
public class SortedPermutationRank {
  public static void main(String[] args) {
    var rank = findSortedPermutationRank("ABab");
    System.out.println(rank);
  }

  private static int findSortedPermutationRank(String input) {
    int rank = 1;
    for(int i=0; i<input.length(); i++) {
      int count = countSmallNumbersOnRight(input.toCharArray(),i);
      rank +=count*generatePermutation(input.length()-1-i);
    }

    return rank;
  }

  private static int countSmallNumbersOnRight(char[] inputArray, int i) {
    int count = 0;
    for(int j=i+1; j<inputArray.length; j++) {
      if(inputArray[j] < inputArray[i])
        count++;
    }
    return count;
  }

  private static int generatePermutation(int n) {
    int permutation = 1;
    while (n > 0) {
      permutation *= n;
      n--;
    }
    return permutation;
  }

}
