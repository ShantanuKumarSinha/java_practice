package shann.java.problems.recursion;

public class CheckPalindrome {
  public static void main(String[] args) {
    String input = "strings";
    int i = 0, j = input.length() - 1;
    var result = checkPalindrome(input, i, j);
    System.out.println(result);
  }

  private static boolean checkPalindrome(String A, int i, int j) {
    if (i >= j) return true;
    if (A.charAt(i) != A.charAt(j)) {
      return false;
      }else
      return checkPalindrome(A, i + 1, j - 1);
  }
}
