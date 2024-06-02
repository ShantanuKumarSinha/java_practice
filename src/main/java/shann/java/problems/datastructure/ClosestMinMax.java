package shann.java.problems.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ClosestMinMax {

    public static void main(String[] args){
        ClosestMinMax closetMinMax = new ClosestMinMax();
        var list = new ArrayList<>(List.of(343,291,963,165,152));
        //var list = new ArrayList<>(List.of(4,4,4,4,4));
        var result = closetMinMax.solve(list);
        System.out.println(result);
    }

    public int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Integer i : A){
            if(min >i)
                min =i;
            if(max<i)
                max=i;
        }
        int currentIndexOfMin=-1, currentIndexOfMax =-1;
        int minSize =A.size();
        for(int i =0; i<A.size();i++){
            if(min == max)
                return 1;
            if(A.get(i).equals(min)){
                currentIndexOfMin=i;
            } else if(A.get(i).equals(max)){
                currentIndexOfMax=i;
            }
            if(currentIndexOfMin !=-1 && currentIndexOfMax!=-1){
                if(minSize>Math.abs(currentIndexOfMax-currentIndexOfMin)+1)
                    minSize =Math.abs(currentIndexOfMax-currentIndexOfMin)+1;
            }
        }
        return minSize;
    }

}
