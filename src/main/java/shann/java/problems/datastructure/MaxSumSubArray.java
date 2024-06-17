package shann.java.problems.datastructure;

import java.util.ArrayList;
import java.util.List;

//You are given an integer array C of size A.
// Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
//But the sum must not exceed B.

public class MaxSumSubArray {
    public static void main(String[] args){
    MaxSumSubArray maxSumSubArray = new MaxSumSubArray();
    var list = new ArrayList<Integer>(List.of(3,8,8,9,7));
    var result = maxSumSubArray.maxSubarray(5,7,list);
    System.out.println(result);
    }

    public int maxSubarray(int A, int B, ArrayList<Integer> C) {
        int maxSum =0;
        for(int l =0; l<A; l++){
            int sum =0;
            for (int r=l; r<A; r++){
                sum +=C.get(r);
                if(maxSum<sum && sum<=B)
                    maxSum = sum;
            }
        }
        return maxSum;
    }
}
