package shann.java.problems.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Problem Description

You are given an array B of meeting time intervals where each interval is represented as [start, end] (with start < end). You need to find the minimum number of conference rooms required to host all the meetings.


Problem Constraints

1 <= B.length <= 104
0 <= start < end <= 106


Input Format

The first line contains an integer n, the number of meetings.
The next n lines each contain two space-separated integers start and end representing the start and end times of the meetings.


Output Format

Output a single integer representing the minimum number of conference rooms required.


Example Input

Input 1:
A = 3
B = [ [0, 30],
      [5, 10],
      [15, 20] ]
Input 2:
A = 1
B = [ [0, 1] ]


Example Output

Output 1:
2
Output 2:
1


Example Explanation

Explanation 1:
We need two rooms:

Room 1: [0, 30]

Room 2: [5, 10], [15, 20]
Explanation 2:
Since there is only one meeting, we need one room
*/
//TODO
// redo it
public class MeetingRoomsII {
  public static void main(String[] args) {
    MeetingRoomsII meetingRooms = new MeetingRoomsII();
    var numberOfMeetings = 3;
    int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
    var count = meetingRooms.countNumberOfMeetingRooms(numberOfMeetings, intervals);
    System.out.println(count);
  }

  public int countNumberOfMeetingRooms(int A, int[][] intervals) {

    if (intervals.length == 0) {
      return 0;
    }

    // Sort the intervals by start time
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // Min-heap to track the earliest ending meeting
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Add the end time of the first meeting
    minHeap.add(intervals[0][1]);

    // Iterate over the remaining meetings
    for (int i = 1; i < intervals.length; i++) {
      // If the current meeting starts after the earliest ending meeting, reuse that room
      if (intervals[i][0] >= minHeap.peek()) {
        minHeap.poll();
      }

      // Add the current meeting's end time to the heap
      minHeap.add(intervals[i][1]);
    }

    // The size of the heap is the number of rooms required
    return minHeap.size();
  }
}
