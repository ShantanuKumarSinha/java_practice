package shann.java.problems.datastructure.bitManipulation;

// find the int value for the set bit of A & B
// ex if A = 3 b = 4 , set bit = 1 0 0
public class SetBit {
    public static void main(String[] args){
        int A =4, B=3;
        var result = (int)Math.pow(2,A)+(int)Math.pow(2,B);
        System.out.println(result);
    }
}
