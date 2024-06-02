package shann.java.problems.datastructure;


import java.util.ArrayList;
import java.util.List;

public class PrefixSum {
  public static void main(String[] args) {
      PrefixSum rangeSumQuery = new PrefixSum();
      List<Integer> arr = List.of(7,3,1,5,5,5,1,2,4,5);
      List<List<Integer>>two_dimension= List.of(List.of(6,9),List.of(2,9),List.of(2,4),List.of(0,9));
      var result = rangeSumQuery.rangeSum(arr, two_dimension);
    System.out.println(result);
  }
    public ArrayList<Long> rangeSum(List<Integer> A, List<List<Integer>> B) {
        ArrayList<Long> sumArray = new ArrayList<>();
        ArrayList<Long> prefixSum = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
      if (i == 0) prefixSum.add((long) A.get(i));
      else prefixSum.add((long) A.get(i) + prefixSum.get(i-1));
        }
        int l =0, r=0;
        for(int i=0; i<B.size();i++){
            l = B.get(i).get(0);
            r = B.get(i).get(1);
            if(l==0)
                sumArray.add(prefixSum.get(r));
            else
                sumArray.add(prefixSum.get(r)-prefixSum.get(l-1));
        }
        return sumArray;
    }
}
