package shann.java.problems.datastructure;

import java.util.ArrayList;
import java.util.List;

public class FindSumOfAllSubArrays {

    public static void main(String[] args){
        FindSumOfAllSubArrays findAllSubArrays = new FindSumOfAllSubArrays();
        //var arrayList  = List.of(3,2,5);
        var arrayList  = new ArrayList<>(List.of(36,63,63,26,87,28,77,93,7));
        var result1 = findAllSubArrays.subarraySum(arrayList);
        var result2 = findAllSubArrays.subarraySumByContributionMethod(arrayList);
        System.out.println(result1);
        System.out.println(result2);
    }
    // brute force
    // TC : O(N^3)
    // SC : O(1)
    public int solve(List<Integer> A) {
        int result = 0;
        for(int si =0; si<A.size();si++){
            for(int ei=si; ei<A.size();ei++){
                for(int i =si; i<=ei; i++){
                   result += A.get(i);
                }
            }
        }
        return result;
    }
    //brute force
    // TC : O(N^3)
    // SC : O(1)
    public int solveBySum(List<Integer> A) {
        int result = 0;
        for(int si =0; si<A.size();si++){
            for(int ei=si; ei<A.size();ei++){
                int sum =0;
                for(int i =si; i<=ei; i++){
                    sum += A.get(i);
                }
                result += sum;
            }
        }
        return result;
    }
    // carry forward way
    // TC : O(N^2)
    // SC : O(1)
    // taking array sum helps in adding sum of each sub array
    public Long subarraySum(ArrayList<Integer> A) {
        Long sum =0L;
        for (int l =0; l<A.size(); l++){
            long arraySum=0;
            for (int r=l; r<A.size(); r++){
                arraySum +=  (long)A.get(r);
                sum +=arraySum;
            }
        }
        return sum;
    }
    // contribution  formula : count of A[i] in sub array = (n-i)*(i+1);
    // TC : O(N)
    // SC : O(1)
    // taking array sum helps in adding sum of each sub array
    public Long subarraySumByContributionMethod(ArrayList<Integer> A) {
        Long sum =0L;
        for (int i =0; i<A.size(); i++){
            sum += (long)A.get(i)*(A.size()-i)*(i+1);
        }
        return sum;
    }

}
