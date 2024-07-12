package shann.java.problems.datastructure.arrays;

import java.util.ArrayList;
import java.util.List;

// Sliding window problem
public class FindMaxSumOfSubArraysOfFixedLength {

    public static void main(String[] args){
        FindMaxSumOfSubArraysOfFixedLength findMaxSumOfSubArraysOfFixedLength = new FindMaxSumOfSubArraysOfFixedLength();
        //var arrayList  = List.of(3,2,5);
        var arrayList  = new ArrayList<>(List.of(36,63,63,26,87,28,77,93,7));
        var result = findMaxSumOfSubArraysOfFixedLength.subArraySumBySlidingWindow(arrayList, 4);
        System.out.println(result);
    }



    // SlidingWindow  :  L : 0 -> N-K, R : -> K-1 to N-1; R = L+K-1;
    // TC : O(N)
    // SC : O(1)
    // taking array sum helps in adding sum of each sub array
    public Long subArraySumBySlidingWindow(ArrayList<Integer> A, int k) {
        Long maxSum = 0L;
        Long sum =0L;
        for (int i =0; i<k; i++){
            sum += (long)A.get(i);
        }
        for(int l =1; l<=A.size()-k;l++){
            int r = l+ k-1;
            sum += (long)A.get(r)-A.get(l-1);
            if(sum > maxSum)
                maxSum= sum;
        }
        return maxSum;
    }

}
