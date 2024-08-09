package shann.java.problems.sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 8, 3, 2, 6, 5, 3, 8};
        int max = Arrays.stream(arr).max().getAsInt();
        int[] freqArr = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            freqArr[arr[i]]++;
        }
        int[] countArr = new int[arr.length];
        int count = 0;
        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] > 0) {
                int j = freqArr[i];
                for (int k = 0; k < j; k++) {
                    countArr[count++] = i;
                }
            }
        }
        System.out.println(Arrays.stream(countArr).boxed().toList());
    }
//    // -ve scenario to be separately
//    public static void main(String[] args){
//        //int[] arr = new int[] {-3, 2, 2, 1, -4, 5, -3};
//    }
}
