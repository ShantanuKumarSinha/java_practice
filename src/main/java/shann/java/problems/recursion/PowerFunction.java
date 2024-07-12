package shann.java.problems.recursion;

public class PowerFunction {
    public static void main(String[] args){
        int result = power(2,3);
        System.out.println(result);
    }
    private static int power(int x, int y) {
     int power = 1;
     if(y==0)
         return 1;
     power = x * power(x, y-1);
     return power;
    }
}
