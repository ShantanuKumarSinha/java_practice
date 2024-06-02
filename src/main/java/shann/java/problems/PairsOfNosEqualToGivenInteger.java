package shann.java.problems;

public class PairsOfNosEqualToGivenInteger {
    public static void main(String[] args){
        int [] a= {1,2,3,4,5};
        System.out.println("count : "+solve(a, 5));
    }
    public static int solve(int[] A, int B) {
        int count =0;
        for(int i=0; i<A.length-1;i++){
            for (int j=i+1; j<A.length;j++){
                if(A[i]+A[j]==B)
                    count++;
            }
        }
        return count;
    }
}
