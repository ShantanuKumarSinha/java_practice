package shann.java.problems.datastructure.Numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an integer array list,
find if an integer p exists in the array
such that the number of integers greater than p in the array equals p.
1 <= |list| <= 2*105
-108 <= list[i] <= 108

Input Format
First and only argument is an integer arrayList list.

Output Format
Return 1 if any such integer p is present else, return -1.

Example Input
Input 1: list = [3, 2, 1, 3]
Input 2: list = [1, 1, 3, 3]

Example Output

Output 1: 1
Output 2: -1

Example Explanation
Explanation 1:  For integer 2, there are 2 greater elements in the array..
Explanation 2:  There exist no integer satisfying the required conditions.

*/

public class NobleInteger {

  public static void main(String[] args) {
    NobleInteger nobleInteger = new NobleInteger();
    var list = new ArrayList<>(List.of(-10,1,1,3,0));
    var result = nobleInteger.checkIfNobelInteger(list);
    System.out.println(result);
    var count = nobleInteger.countNobelInteger(list);
    System.out.println(count);
  }

  private int checkIfNobelInteger(ArrayList<Integer> list) {
    Collections.sort(list, Collections.reverseOrder());
    //    Collections.sort(list,(n1,n2)->n2.compareTo(n1));
    //    Collections.sort(list, (a,b)->b-a);
    //    Collections.sort(list, Comparator.reverseOrder());
    for (int i = 0; i < list.size(); i++) {
      if (i != 0 && list.get(i - 1).equals(list.get(i))) {
        continue;

      } else if (i == list.get(i)) return 1;
    }
    return -1;
  }
  //  3 3 2 1
  private int countNobelInteger(ArrayList<Integer> list) {
    Collections.sort(list, Collections.reverseOrder());
    //    Collections.sort(list,(n1,n2)->n2.compareTo(n1));
    //    Collections.sort(list, (a,b)->b-a);
    //    Collections.sort(list, Comparator.reverseOrder());
    int count = 0, index = 0;
    for (int i = 0; i < list.size(); i++) {
      if (i == 0 || !list.get(i - 1).equals(list.get(i))) {
        index = i;

      }
      if (index == list.get(i)) count++;
    }
    return count;
  }
}
