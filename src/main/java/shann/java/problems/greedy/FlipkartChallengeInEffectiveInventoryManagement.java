package shann.java.problems.greedy;

/*
Problem Description

In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management. Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays, A and B of size N. A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit margin for the ith item. To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.

The objective is to identify a method to strategically buy certain items, ensuring they are sold before their expiration date, thereby maximizing overall profit. Can you assist Flipkart in developing an innovative approach to optimize their grocery inventory and enhance profitability?

Your task is to find the maximum profit one can earn by buying groceries considering that you can only buy one grocery item at a time.

NOTE:

You can assume that it takes 1 minute to buy a grocery item, so you can only buy the ith grocery item when the current time <= A[i] - 1.
You can start buying from day = 0.
Return your answer modulo 109 + 7.

Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109
0 <= B[i] <= 109

Input Format

The first argument is an integer array A represents the deadline for buying the grocery items.
The second argument is an integer array B represents the profit obtained after buying the grocery items.

Output Format

Return an integer denoting the maximum profit you can earn.

Example Input

Input 1:

 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]

Input 2:

 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]

Example Output

Output 1:

 20
Output 2:

 30

Example Explanation

Explanation 1:
 At time 0, buy item with profit 5.
 At time 1, buy item with profit 6.
 At time 2, buy item with profit 9.
 At time = 3 or after , you can't buy any item, as there is no item with deadline >= 4.
 So, total profit that one can earn is 20.

Explanation 2:
 At time 0, buy item with profit 3.
 At time 1, buy item with profit 1.
 At time 2, buy item with profit 7.
 At time 3, buy item with profit 19.
 We are able to buy all items within their deadline. So, total profit that one can earn is 30.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//TODO
public class FlipkartChallengeInEffectiveInventoryManagement {
  public static void main(String[] args) {
    FlipkartChallengeInEffectiveInventoryManagement fm =
        new FlipkartChallengeInEffectiveInventoryManagement();
    int[] time1 = {1, 3, 2, 3, 3};
    int[] profit1 = {5, 6, 1, 3, 9};
    var result1 = fm.calculateMaximumProfit(time1, profit1);
    System.out.println(result1);

    int[] time2 = {1, 7, 6, 2, 8, 4, 4, 6, 8, 2};
    int[] profit2 = {8, 11, 7, 7, 10, 8, 7, 5, 4, 9};
    var result2 = fm.calculateMaximumProfit(time2, profit2);
    System.out.println(result2);
  }

  private int calculateMaximumProfit(int[] time, int[] profit) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int[][] pair = new int[time.length][2];
    for (int i = 0; i < time.length; i++) {
      pair[i][0] = time[i];
      pair[i][1] = profit[i];
    }
    Arrays.sort(
        pair,
        new Comparator<int[]>() {

          @Override
          public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[0], o2[0]);
          }
        });
    int t = 0;
    int sum = 0;
    for (int i = 0; i < pair.length; i++) {
      if (t < pair[i][0]) {
        priorityQueue.add(pair[i][1]);
        sum += pair[i][1];
        t++;
      } else {
        if (pair[i][1] > priorityQueue.peek()) {
          sum -= priorityQueue.poll();
          priorityQueue.add(pair[i][1]);
          sum += pair[i][1];
        }
      }
    }
    return sum;
  }
}
