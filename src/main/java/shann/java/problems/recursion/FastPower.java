package shann.java.problems.recursion;
// TODO recursion -2
public class FastPower {
    public static void main(String[] args){
    var result = calculate(2,5);
    System.out.println(result);
    }
    private static int calculate(int a, int b){
        if(a ==0)
            return 0;
        if (b == 0)
            return 1;
        int ans = calculate(a,b/2);
        if(b%2==0)
             ans = ans*ans;
        else
            ans =  ans*ans*a;
        return ans;
    }
}
