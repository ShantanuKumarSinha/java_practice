package shann.java.problems.heaps;

import java.util.PriorityQueue;

/*
Problem Description

Misha loves eating candies. She has been given N boxes of Candies.


She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?

NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).

NOTE 2: The same box will not be chosen again.




Problem Constraints

1 <= N <= 105

1 <= A[i] <= 105

1 <= B <= 106



Input Format

The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
The second argument is B, the maximum number of candies Misha like in a box.



Output Format

Return an integer denoting the number of candies Misha will eat.



Example Input

Input 1:


 A = [3, 2, 3]
 B = 4
Input 2:

 A = [1, 2, 1]
 B = 2



Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
 She will not eat from the 3rd box as now it has candies greater than B.
 So the number of candies Misha eat is 2.
Explanation 2:

 1st time Misha will eat from 1st box, i.e she can't eat any and will put the remaining 1 candy in the 3rd box.
 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 1 candies in the 2nd box.
 She will not eat from the 2nd box as now it has candies greater than B.
 So the number of candies Misha eat is 1.
*/
// TODO Heaps1 - Additional Question - 2
public class MishaAndCandies {
  public static void main(String[] args) {
    MishaAndCandies mishaAndCandies = new MishaAndCandies();
    //    int[] candies1 = {3, 2, 3};
    //    int thresholdValue1 = 4;
    //    var result1 = mishaAndCandies.findNumbersOfCandiesThatMishaCanEat(candies1,
    // thresholdValue1);
    //    System.out.println(result1);

    //    int[] candies2 = {705};
    //    int thresholdValue2 = 895;
    //    var result2 = mishaAndCandies.findNumbersOfCandiesThatMishaCanEat(candies2,
    // thresholdValue2);
    //    System.out.println(result2);

    int[] candies3 = {
      110, 289, 585, 135, 314, 259, 238, 798, 954, 399, 492, 282, 311, 177, 804, 769, 191, 539, 830,
      806, 854, 50, 373, 329, 549, 202, 399, 542, 166, 986, 446, 346, 58, 269, 103, 267, 547, 171,
      713, 408, 847, 988, 704, 162, 850, 493, 59, 584, 588, 117, 639, 310, 615, 871, 977, 136, 973,
      324, 450, 737, 778, 139, 606, 98, 968, 275, 911, 558, 849, 62, 495, 512, 106, 682, 980, 9,
      517, 104, 80, 540, 689, 696, 396, 681, 541, 468, 12, 482, 459, 438, 924, 507, 725, 388, 579,
      754, 421, 30, 151
    };
    int thresholdValue3 = 80;
    var result3 = mishaAndCandies.findNumbersOfCandiesThatMishaCanEat(candies3, thresholdValue3);
    System.out.println(result3);
  }

  private int findNumbersOfCandiesThatMishaCanEat(int[] candiesJar, int thresholdValue) {
    var numbersOfCandies = 0;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (Integer candies : candiesJar) {
      priorityQueue.add(candies);
    }
    while (!priorityQueue.isEmpty() && priorityQueue.peek() < thresholdValue) {
      var candies = priorityQueue.poll();
      numbersOfCandies += candies / 2;
      var remainingCandies = candies - candies / 2;
      if (priorityQueue.size() > 0) {
        var jarToBeUpdated = priorityQueue.poll();
        jarToBeUpdated += remainingCandies;
        priorityQueue.add(jarToBeUpdated);
      }
    }
    return numbersOfCandies;
  }
}
