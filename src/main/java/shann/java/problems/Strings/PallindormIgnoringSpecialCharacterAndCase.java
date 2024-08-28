package shann.java.problems.Strings;

public class PallindormIgnoringSpecialCharacterAndCase {

  public static void main(String[] args) {
    System.out.println(isPallindrome("raceR"));
    System.out.println(isPallindrome("niti$N"));
    System.out.println(isPallindrome("Rama"));
  }

  private static boolean isPallindrome(String input) {
    var clear = input.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
    var reverse = new StringBuilder(clear).reverse().toString();
    return clear.equals(reverse.toString());
  }
}
