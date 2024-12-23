package shann.java.problems.modulo;

public class DeleteOneElementToFindMaxGCD {
    public static void main(String[] args){
        int val =0, ans =0;
        int[] arr = {24,16,18,30,15};
        int[] prefixArray = new int[arr.length];
        int[] suffixArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(i==0)
                prefixArray[0]=arr[0];
            else
                prefixArray[i]= GCDOfTwoNumbers.calculateGCD(prefixArray[i-1], arr[i]);
        }
        for(int i = arr.length-1;i>=0;i--){
            if(i==arr.length-1)
                suffixArray[i]=arr[i];
            else
                suffixArray[i]=GCDOfTwoNumbers.calculateGCD(suffixArray[i+1],arr[i]);
        }
        for(int i = arr.length-1;i>=0;i--){
            int left =0;
            if(i>0)
                left = prefixArray[i-1];
            int right =0;
            if(i+1<arr.length)
                right = suffixArray[i+1];
            val = GCDOfTwoNumbers.calculateGCD(left, right);
            if(ans<val)
                ans=val;
        }
    System.out.println(ans);
    }
}
