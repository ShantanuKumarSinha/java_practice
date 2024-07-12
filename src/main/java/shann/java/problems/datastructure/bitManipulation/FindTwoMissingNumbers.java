package shann.java.problems.datastructure.bitManipulation;

// It's like find two numbers coming only once in an array where every other number has come twice
public class FindTwoMissingNumbers {
    public static void main(String[] args){
        int[] A = { 1, 3, 4, 5, 6, 8, 9, 10 };
        int xOrN=0, xOrNPlus2=0, xOROfMissingNumbers =0;
        for(int i=0; i<A.length;i++){
            xOrN = xOrN^A[i];
        }
        for(int i=1; i<= A.length+2;i++){
            xOrNPlus2 = xOrNPlus2^i;
        }
        xOROfMissingNumbers = xOrN^xOrNPlus2;
        int pos =0;
        for(int i =0; i<32; i++){
            if(checkBit(xOROfMissingNumbers,i)){
                pos = i;
                break;
            }
        }
        int group1 =0, group2 = 0;
        for(int i=1; i<=A.length+2; i++){
            if(checkBit(i,pos))
                group1 = group1^i;
            else
                group2 = group2^i;
        }
        for(int i=0; i<A.length; i++){
            if(checkBit(A[i],pos))
                group1 = group1^A[i];
            else
                group2 = group2^A[i];
        }
        int [] result = {group1, group2};
        System.out.println(group1);
        System.out.println(group2);
    }

    private static boolean checkBit(int n, int i){
        if((n&(1<<i))>0) return true;
        return false;
    }

}
