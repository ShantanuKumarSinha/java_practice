package shann.java.problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountNonNegativeProfit {
    public static void main(String[] args){
        CountNonNegativeProfit countNonNegativeProfit = new CountNonNegativeProfit();
        var a = new ArrayList<Integer>(List.of(6,6,5,-10,8,-1,-10,-1,-1,1));
        var b1 = new ArrayList<>(List.of(5,6));
        var b2 = new ArrayList<>(List.of(1,4));
        var b3 = new ArrayList<>(List.of(2,4));
        var b4 = new ArrayList<>(List.of(5,5));
        var b5 = new ArrayList<>(List.of(3,8));
        var b6 = new ArrayList<>(List.of(2,9));
        var b7 = new ArrayList<>(List.of(0,4));
        ArrayList<ArrayList<Integer>> b = new ArrayList<>(List.of(b1,b2,b3,b4,b5,b6,b7));
        System.out.println(countNonNegativeProfit.solve(a,b));
    }
        public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
            ArrayList<Integer> nonNegativeProfitCount = new ArrayList<>();
            ArrayList<Integer> resultProfit = new ArrayList<>();
            if(A.get(0)>=0)
                nonNegativeProfitCount.add(1);
            else
                nonNegativeProfitCount.add(0);
            for(int i=1; i<A.size();i++){
                if(A.get(i)>=0)
                    nonNegativeProfitCount.add(nonNegativeProfitCount.get(i-1)+1);
                else
                    nonNegativeProfitCount.add(nonNegativeProfitCount.get(i-1));
            }
            for(int i =0; i<B.size();i++){
                if(B.get(i).get(0).equals(0))
                    resultProfit.add(nonNegativeProfitCount.get(B.get(i).get(1)));
                else
                    resultProfit.add(nonNegativeProfitCount.get(B.get(i).get(1))-nonNegativeProfitCount.get(B.get(i).get(0)-1));
            }
            return resultProfit;
        }

}
