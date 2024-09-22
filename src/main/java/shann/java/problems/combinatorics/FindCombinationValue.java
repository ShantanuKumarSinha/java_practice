package shann.java.problems.combinatorics;



public class FindCombinationValue {
    public static void main(String[] args){
//    System.out.println(generateComputation(5,2,11));
//    System.out.println(generateComputation(6,2,13));
    System.out.println(generateComputation(30,24,56));
    }

    private static int generateComputation(int n, int k, int modulo) {
        long numerator = 1;
        var numeratorTill  = n-k>k?n-k:k;
        var toBeDivided = k<n-k?k:n-k;
        while (n>numeratorTill){
            numerator *= n;
            n--;
        }
        long divisor =1;

        while(toBeDivided>1){
            divisor *= toBeDivided;
            toBeDivided--;
        }
        return (int)(numerator/divisor)%modulo;
    }


}
