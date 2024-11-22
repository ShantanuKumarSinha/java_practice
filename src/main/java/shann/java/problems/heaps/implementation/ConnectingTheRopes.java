package shann.java.problems.heaps.implementation;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description

You are given an array A of integers that represent the lengths of ropes.




You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.






Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 1000



Input Format

The only argument given is the integer array A.



Output Format

Return an integer denoting the minimum cost to connect these ropes into one rope.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 33
Output 2:

 182


Example Explanation

Explanation 1:

 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15

 So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
Explanation 2:

 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133

 So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
*/
public class ConnectingTheRopes {
  private int result;
  public static void main(String[] args) {
    ConnectingTheRopes theRopes = new ConnectingTheRopes();
    var result = theRopes.connectTheRopes(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
    System.out.println(result);
  }

  private int connectTheRopes(List<Integer> list) {
    if (list.size() == 1) return list.get(0);
    buildMinHeap(list);
    while (list.size() > 1) {
      var minCount =0;
      var firstTwoMinSum =0;
      while (minCount<2){
        firstTwoMinSum+=removeMinFromHeap(list);
        minCount++;
      }
      result += firstTwoMinSum;
      insertIntoHeap(list, firstTwoMinSum);
    }
    return result;
  }


  private void buildMinHeap(List<Integer> list){
    for(int i =list.size()/2-1;i>=0;i--){
      heapfiy(list,list.size(),i);
    }
  }

  private void insertIntoHeap(List<Integer> heap, int value) {
    if (heap.size()== 0) {
      heap.add(value);
      return;
    }
    heap.add(value);
    reverseHeapfiy(heap, heap.size()-1 );
  }

  private void reverseHeapfiy(List<Integer> heap, int i) {
    while (i > 0) {
      if (heap.get((i - 1) / 2) > heap.get(i)) {
        swap(heap, i, (i-1 )/ 2 );
        i = (i - 1) / 2;
      } else break;
    }
  }

  private int removeMinFromHeap(List<Integer> list) {
    if (list.size()== 0) return -1;
    swap(list, 0, list.size()-1);
    var removedItem = list.remove(list.size()-1);
    heapfiy(list,list.size(),0);
    return removedItem;
  }

  private void heapfiy(List<Integer> list, int size, int i) {
    while (2*i+1<size) {
      var minChild = 2*i+2<size?Math.min(list.get(2*i+1),list.get(2*i+2)):list.get(2*i+1);
      var min = Math.min(list.get(i),minChild);
      if(min==list.get(i)) break;
      else if(min ==list.get(2*i+1)){
        swap(list, i, 2*i+1);
        i = 2*i+1;
      } else {
        swap(list, i, 2*i+2);
        i = 2*i+2;
      }
    }
  }

  private void swap(List<Integer> list, int i, int j) {
    var temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
}
