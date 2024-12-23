package shann.java.problems.arrays;

public class LongestDecreasingSubArray {
    public static void main(String[] args){
        int[] A ={20,13,10};
        int maxCount =1, count =1;
        for(int si =0; si<A.length;si++){
            for(int ei =si+1; ei<A.length;ei++){
                if(A[ei]<A[ei-1])
                    count++;
                else
                    break;
            }
            if(maxCount<count)
                maxCount =count;
            count =1;
        }
        System.out.println(maxCount);
    }
}
