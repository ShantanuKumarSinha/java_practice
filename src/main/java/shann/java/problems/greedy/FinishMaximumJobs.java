package shann.java.problems.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
Problem Description

There are N jobs to be done, but you can do only one job at a time.





Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish.







Problem Constraints

1 <= N <= 105

1 <= A[i] < B[i] <= 109



Input Format

The first argument is an integer array A of size N, denoting the start time of the jobs.
The second argument is an integer array B of size N, denoting the finish time of the jobs.



Output Format

Return an integer denoting the maximum number of jobs you can finish.



Example Input

Input 1:

 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]
Input 2:

 A = [3, 2, 6]
 B = [9, 8, 9]


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 We can finish the job in the period of time: (1, 7) and (7, 8).
Explanation 2:

 Since all three jobs collide with each other. We can do only 1 job.
*/
public class FinishMaximumJobs {
  public static void main(String[] args) {
    FinishMaximumJobs finishMaximumJobs = new FinishMaximumJobs();
    int[] start = {1, 5, 7, 1};
    int[] end = {7, 8, 8, 8};
    var result = finishMaximumJobs.findMaximumJobs(start, end);
    System.out.println(result);
  }

  private int findMaximumJobs(int[] startTime, int[] endTime) {
    int[][] pair = new int[endTime.length][2];
    for (int i = 0; i < endTime.length; i++) {
      pair[i][0] = startTime[i];
      pair[i][1] = endTime[i];
    }
    Arrays.sort(
        pair,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1], o2[1]);
          }
        });

    //Arrays.sort(pair, Comparator.comparingInt(o -> o[1]));
    int count = 1;
    var lastEndTime = pair[0][1];
    for (int i = 1; i < pair.length; i++) {
      if (pair[i][0] >= lastEndTime) {
        count++;
        lastEndTime = pair[i][1];
      }
    }
    return count;
  }
}
