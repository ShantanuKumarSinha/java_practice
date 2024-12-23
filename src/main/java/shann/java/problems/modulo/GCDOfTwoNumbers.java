package shann.java.problems.modulo;

public class GCDOfTwoNumbers {
    public static void main(String[] args){
        int result = calculateGCD(15,5);
    System.out.println(result);
    }
    public static int calculateGCD(int a, int b){
        if(b==0)
            return a;
        return calculateGCD(b,a%b);
    }
}
