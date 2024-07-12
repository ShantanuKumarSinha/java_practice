package shann.java.problems.datastructure.arrays;

import java.util.ArrayList;
import java.util.List;

public class ContinuosSumQuery {
  ContinuosSumQuery continuosSumQuery = new ContinuosSumQuery();

  public static void main(String[] args) {
    int A =5;
    ArrayList<ArrayList<Integer>> lists =
        new ArrayList(
            List.of(
                new ArrayList<Integer>(List.of(1, 2, 10)),
                new ArrayList<Integer>(List.of(2, 3, 20)),
                new ArrayList<Integer>(List.of(2, 5, 25))));
    var prefixSummedList = new ArrayList<Integer>();
    for(int i =0; i<A; i++)
        prefixSummedList.add(0);
    for (int i = 0; i < lists.size(); i++) {
        int si = lists.get(i).get(0);
        int ei = lists.get(i).get(1);
        int val = lists.get(i).get(2);
        prefixSummedList.set(si-1,prefixSummedList.get(si-1)+val);
        if(ei-1<A-1)
            prefixSummedList.set(ei,prefixSummedList.get(ei)-val);
    }
    for(int i =1; i<A; i++){

        prefixSummedList.set(i, prefixSummedList.get(i)+prefixSummedList.get(i-1));
    }
    System.out.println(prefixSummedList);
  }
}
