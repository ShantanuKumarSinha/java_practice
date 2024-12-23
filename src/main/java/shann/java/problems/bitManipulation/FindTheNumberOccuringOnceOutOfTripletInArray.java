package shann.java.problems.bitManipulation;

public class FindTheNumberOccuringOnceOutOfTripletInArray {
  public static void main(String[] args) {
    int[] A = {0,0,0,1};
    int ans =0;
    for(int i=0; i<32; i++){
      int count =0;
      for(int j=0; j<A.length;j++){
        if(checkBit(A[j],i))
          count++;
      }
      if(count%3==1)
        ans = ans|(1<<i);
    }
    System.out.println(ans);
    ;
  }
  private static boolean checkBit(int n, int i){
    if((n&(1<<i))>0) return true;
    return false;
  }
}
