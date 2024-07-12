package shann.java.problems.datastructure.Strings;

public class ToogleCase {
  // Input : Hello Output : hELLO
  public static void main(String[] args) {
    String str = "Hello";
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch >= 'A' && ch <= 'Z') {
        ch += 32;
        stringBuilder.append((char) ch);
      } else if (ch >= 'a' && ch <= 'z') {
        ch -= 32;
        stringBuilder.append((char) ch);
      }
    }
    System.out.println(stringBuilder.toString());
  }
}
