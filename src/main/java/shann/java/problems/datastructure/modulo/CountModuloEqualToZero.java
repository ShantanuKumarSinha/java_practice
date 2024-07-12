package shann.java.problems.datastructure.modulo;

public class CountModuloEqualToZero {
  public static void main(String[] args) {
    int[] arr = {4, 3, 6, 3, 8, 12};
    int b = 6;
    // (a+b)%m = a%m+b%m;
    int[] moduloArray = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      moduloArray[i] = arr[i] % b;
    }
    int count = 0;
    int[] frequencyArray = new int[arr.length];
    for (int i = 0; i < moduloArray.length; i++) {
      frequencyArray[moduloArray[i]]++;
      count += frequencyArray[(b - moduloArray[i])%b];
    }
    System.out.println(count);
  }
}
