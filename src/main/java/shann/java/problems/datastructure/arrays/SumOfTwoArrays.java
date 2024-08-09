package shann.java.problems.datastructure.arrays;

public class SumOfTwoArrays {
    public static void main(String[] args){
        var result =solve(new int[]{9,4,8,0,7}, new int[]{5,2,0,1,5,9});
    System.out.println(result);
    }
    public static long solve(int[] A, int[] B) {
        long ans =0, finalAns =0;
        int length = Math.max(A.length, B.length);
        if(A.length== B.length){
            int carryForward =0;
            for(int i =length-1; i>=0; i--){
                carryForward =  (B[i]+A[i])/10;
                ans = ans*10 + ((B[i]+A[i])%10) +carryForward;
            }
        } else if(A.length<length){
            int[] newA = new int[length];
            int count =0;
            int index = length-count-A.length;
            for(int i =0; i<length;i++){

                if(i<length-A.length){
                    newA[i]=0;
                    count++;
        } else {
          newA[i] = A[index];
          index++;
                    }
            }
            int carryForward =0;
            for(int i =length; i>length; i--){
                carryForward =  (B[i]+newA[i])/10;
                ans = ans*10 + ((B[i]+newA[i])%10) +carryForward;
            }
        } else{
            int[] newB = new int[length];
            int count =0;
            for(int i =0; i<length;i++){
                if(i<length-B.length){
                    newB[i]=0;
                    count++;
                } else
                    newB[i]=B[length-count-B.length];
            }
            int carryForward =0;
            for(int i =length-1; i>=0; i--){
                carryForward =  (A[i]+newB[i])/10;
                ans = ans*10 + ((A[i]+newB[i])%10) +carryForward;
            }
        }
        while(ans>0){
            finalAns = finalAns*10+(ans%10);
            ans = ans/10;
        }
        return finalAns;

    }
}

