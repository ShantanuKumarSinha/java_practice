package shann.java.problems.bitManipulation;

public class BinaryOfANumber {
  public static void main(String[] args) {
    int a = 8;
    int binaryValue = 0;
    String binaryInString="";
    int power = 0;
//    while (a > 0) {
//      binaryValue = a % 2 * (int)Math.pow(10,power) + binaryValue;
//      power++;
//      a = a / 2;
//    }
    while (a > 0) {
      binaryInString = a%2+binaryInString;
      a = a / 2;
    }
    System.out.println(binaryValue);
    System.out.println(binaryInString);
  }
}
