package shann.java.problems.datastructure.modulo;

public class CountPairWithModuloEqualToZero {
  public static void main(String[] args) {
    int[] arr = {4, 3, 6, 3, 8, 12};
    int b = 6;
    // (a+b)%m = a%m+b%m;

    int count = 0, pair =0;
    int[] frequencyArray = new int[b];
    for (int i = 0; i < arr.length; i++) {
          int rem = arr[i]%b;
          if(rem == 0)
              pair = 0;
          else pair = b-rem;
          count += frequencyArray[pair];
          frequencyArray[rem]++;
    }
    System.out.println(count);
  }
}
