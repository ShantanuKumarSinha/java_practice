package shann.java.problems.datastructure.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubArrays {

    public static void main(String[] args){
        FindAllSubArrays findAllSubArrays = new FindAllSubArrays();
        var arrayList  = List.of(36,63,63,26,87,28,77,93,7);
        var result = findAllSubArrays.  solve(arrayList);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> solve(List<Integer> A) {
        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();
        for(int si =0; si<A.size();si++){
            for(int ei=si; ei<A.size();ei++){
                ArrayList<Integer> subArraysForSI = new ArrayList<>();
                for(int i =si; i<=ei; i++){
                    subArraysForSI.add(A.get(i));
                }
                subArrays.add(subArraysForSI);
            }
        }
        return subArrays;
    }

}
