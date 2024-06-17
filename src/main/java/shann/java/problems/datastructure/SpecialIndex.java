package shann.java.problems.datastructure;


import java.util.ArrayList;
import java.util.List;

public class SpecialIndex {
  public static void main(String[] args) {
      SpecialIndex specialIndex = new SpecialIndex();
      List<Integer> arr = List.of(1,2,3,7,1,2,3);
      var result = specialIndex.solve(arr);
    System.out.println(result);
  }
    public int solve(List<Integer> A) {
        int count =0;
        ArrayList<Integer> prefixEvenSum = new ArrayList<>();
        ArrayList<Integer> prefixOddSum = new ArrayList<>();
        for(int i =0 ;i<A.size();i++){
            if(i%2==0){
                if(i==0)
                    prefixEvenSum.add(A.get(i));
                else
                    prefixEvenSum.add(prefixEvenSum.get(i-1)+A.get(i));
            } else
                prefixEvenSum.add(prefixEvenSum.get(i-1));
        }
        for(int i =0 ;i<A.size();i++){
            if(i%2==0){
                if(i==0)
                    prefixOddSum.add(0);
                else
                    prefixOddSum.add(prefixOddSum.get(i-1));
            } else
                prefixOddSum.add(prefixOddSum.get(i-1)+A.get(i));
        }
        int specialIndex = 0;
        for(int i=0; i<A.size();i++){
            int sumOfEvenIndex = 0, sumOfOddIndex = 0;
            if(i==0){
                sumOfEvenIndex = prefixOddSum.get(prefixOddSum.size()-1)-prefixOddSum.get(0);
                sumOfOddIndex = prefixEvenSum.get(prefixEvenSum.size()-1)-prefixEvenSum.get(0);
            } else {    
            sumOfEvenIndex = prefixEvenSum.get(i)+prefixOddSum.get(A.size()-1)-prefixOddSum.get(i-1);
            sumOfOddIndex = prefixOddSum.get(i)+prefixEvenSum.get(A.size()-1)-prefixEvenSum.get(i-1);
            }
            if(sumOfEvenIndex == sumOfOddIndex)
                specialIndex++;
        }
        return specialIndex;
    }
}
