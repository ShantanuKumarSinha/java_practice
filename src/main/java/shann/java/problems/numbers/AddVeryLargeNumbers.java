package shann.java.problems.numbers;

public class AddVeryLargeNumbers {
  //        Add two large numbers
  //        Example:
  //        var a = "123456789098765432123456789";
  //        var b  = "12345678909876543256789876543212345678765";

  // TODO
  public static void main(String[] args) {
//    var a = "123456789098765432123456789";
//    var b = "12345678909876543256789876543212345678765";
    var a = "999999";
    var b = "1";
    sum(a, b);
  }

  public static String sum(String a, String b) {

    var result = new StringBuilder();
    var residue = 0;
    int length = Math.max(b.length(), a.length());

    for (int i = 0; i < length; i++) {
      var firstArray = b.length() > a.length() ? b.toCharArray() : a.toCharArray();
      var smallArray = b.length() > a.length() ? a.toCharArray() : b.toCharArray();
      var charSum = 0;

      if (i < smallArray.length) {
        charSum = getIntValueForAsci((int) firstArray[i]) + getIntValueForAsci((int) smallArray[i]);
        if (residue != 0) charSum += residue;
        var placeHolder = charSum % 10;
        residue = charSum / 10;
        result.append(placeHolder);
      } else {
        charSum = getIntValueForAsci((int) firstArray[i]) + residue;
        var placeHolder = charSum % 10;
        residue = charSum / 10;
        result.append(placeHolder);
      }
    }

    if (residue != 0) {
      result.append(residue);
    }
    return result.reverse().toString();
  }

  private static Integer getIntValueForAsci(Integer ch) {
    return ch - 48;
  }
}
