package shann.java.problems.dynamicProgramming.oneDimensional;
/**
 * Problem Description
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
 *
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 *
 *
 *
 * Problem Constraints
 * 1 <= A * B <= 106
 *
 * 1 <= B <= A
 *
 * 1 <= C <= 106
 *
 *
 *
 * Input Format
 * The first argument given is integer A ( = n).
 * The second argument given is integer B ( = r).
 * The third argument given is integer C ( = m).
 *
 *
 * Output Format
 * Return the value of nCr % m.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = 2
 *  C = 13
 * Input 2:
 *
 *  A = 6
 *  B = 2
 *  C = 13
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The value of 5C2 % 11 is 10.
 * Explanation 2:
 *
 *  The value of 6C2 % 13 is 2.
 */

public class FindCombinationValueDynamicProgramming {

    public static void main(String[] args){
    System.out.println(generateComputation(5,2,11));
    System.out.println(generateComputation(6,2,13));
    System.out.println(generateComputation(30,24,56));
    }

//    private static int generateComputationRecurssion(int n, int k, int modulo){
//        if(k==0)
//            return 1;
//        if(k==n)
//            return 1;
//        return ((generateComputationRecurssion(n-1,k-1,modulo)%modulo)+(generateComputationRecurssion(n-1,k,modulo)%modulo))%modulo;
//    }

    public static int generateComputation(int n, int k, int modulo) {
        int[][] result = new int[n+1][k+1];
        result[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=Math.min(i,k); j++) {
                if(j==0||j==i)
                    result[i][j] = 1;
                else {
                    result[i][j] = (result[i-1][j-1]%modulo + result[i-1][j]%modulo)%modulo;
                }
            }
        }
        return result[n][k];
    }


}
