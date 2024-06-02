package shann.java.problems;

public class Find3rdMax {

    public static void main(String[] args) {
        int[] numArr = {100,2,3,4,5,1000};
        int maxNum =0, secondMax =0, thirdMax=0;
        for (int i =0 ; i<numArr.length; i++)
            if(numArr[i]>maxNum){
                thirdMax= secondMax;
                secondMax = maxNum;
                maxNum= numArr[i];
            } else if (numArr[i]>secondMax && numArr[i]<maxNum) {
                thirdMax=secondMax;
                secondMax = numArr[i];
            } else if (numArr[i]>thirdMax && numArr[i]<secondMax) {
                thirdMax = numArr[i];
            }
        System.out.println("First max"+ maxNum);
        System.out.println("Second max"+ secondMax);
        System.out.println("Third max"+ thirdMax);

    }

}
