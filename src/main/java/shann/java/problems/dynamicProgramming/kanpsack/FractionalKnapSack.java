package shann.java.problems.dynamicProgramming.kanpsack;

import java.util.Arrays;
import java.util.Comparator;

/*
Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

NOTE:

You can break an item for maximizing the total value of the knapsack



Problem Constraints

1 <= N <= 105

1 <= A[i], B[i] <= 103

1 <= C <= 103




Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.


Output Format

Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 24000
Output 2:

 2105


Example Explanation

Explanation 1:

Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
Explanation 2:

Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.

*/
public class FractionalKnapSack {
  public static void main(String[] args) {
    FractionalKnapSack fractionalKnapSack = new FractionalKnapSack();
    int[] values = {60, 100, 120};
    int[] weights = {10, 20, 30};
    int capacity = 50;
    var result1 = fractionalKnapSack.findMaxValue(values, weights, capacity);
    System.out.println(result1);
  }

  private int findMaxValue(int[] values, int[] weights, int capacity) {
    Pair[] pairs = new Pair[values.length];
    for (int i = 0; i < weights.length; i++) {
      pairs[i] = new Pair(values[i], weights[i]);
    }
    Arrays.sort(
        pairs,
        new Comparator<Pair>() {
          @Override
          public int compare(Pair p1, Pair p2) {
            if ((double)p1.value / p1.weight < (double) p2.value / p2.weight) return 1;
            else if ((double)p1.value / p1.weight > (double) p2.value / p2.weight) return -1;
            else return 0;
          }
        });
    double valueSum = 0;
    for (Pair pair : pairs) {
      if (capacity - pair.weight < 0) {
        valueSum += (double)capacity / pair.weight * pair.value;
        capacity = 0;
      } else {
        capacity -= pair.weight;
        valueSum += pair.value;
      }
    }
    return (int)Math.floor(valueSum*100);
  }

  class Pair {
    int value;
    int weight;

    public Pair(int value, int weight) {
      this.value = value;
      this.weight = weight;
    }
  }
}
