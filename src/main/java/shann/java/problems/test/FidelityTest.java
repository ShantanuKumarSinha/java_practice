package shann.java.problems.test;

public class FidelityTest {
    //
    public static void main(String[] args){
      int[] arr = {3,4,6,5,9};
      var targetSum =11;
//      for(int i = 0 ; i < arr.length ; i++){
//          for(int j = i+1 ; j < arr.length ; j++){
//              if(arr[i] + arr[j] == targetSum){
//                  System.out.println(arr[i]);
//                  System.out.println(arr[j]);
//                  break;
//              }
//          }
//      }
      for(int i = 0 ; i < arr.length-1 ; i++){
          if((arr[i] + arr[i+1]) == targetSum){
              System.out.println(arr[i]);
              System.out.println(arr[i+1]);
          }
      }

    }
}
