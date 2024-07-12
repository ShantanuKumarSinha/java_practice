package shann.java.problems.numbers;

public class NumeratorAndDenominator {

    public static void main(String[] args) {
        int[] arr1 = {3,9};
        int[] arr2 = {2,7};
        int[] result = new int[arr1.length];
        var lcm = arr1[1]*arr2[1];
        var firstFactor = lcm/arr1[1];
        var secondFactor = lcm/arr2[1];
        var numeratorInit = (arr1[0]*firstFactor)+(arr2[0]*secondFactor);
        var denominatorInit = lcm;
        var max = numeratorInit>=denominatorInit?numeratorInit: denominatorInit;
        var min = numeratorInit<denominatorInit?numeratorInit: denominatorInit;
        int numerator =0, denominator =0;
        for (int i=2; i<=min; i++){
            if(max%i==0 && min%i==0){
                numerator = numeratorInit/i;
                denominator = denominatorInit/i;
            }
        }
        result[0]= numerator;
        result[1]= denominator;
        System.out.println(result[0]+" "+result[1]);
    }
}
