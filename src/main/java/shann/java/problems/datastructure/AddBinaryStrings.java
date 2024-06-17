package shann.java.problems.datastructure;

public class AddBinaryStrings {

  public static void main(String[] args) {
    AddBinaryStrings addBinaryStrings = new AddBinaryStrings();
    var sb = addBinaryStrings.addBinary("100", "10");
    System.out.println(sb);
  }

  public String addBinary(String a, String b) {

    StringBuilder sb = new StringBuilder();
    StringBuilder aReverse = new StringBuilder(a).reverse();
    StringBuilder bReverse = new StringBuilder(b).reverse();

    int len = a.length() > b.length() ? a.length() : b.length();
    while (aReverse.length() < len) {
      aReverse.append(0);
    }
    while (bReverse.length() < len) {
      bReverse.append(0);
    }

    boolean carryFoward = false;
    for (int i = 0; i < len; i++) {
      var charInAReverse = aReverse.charAt(i);
      var charInBReverse = bReverse.charAt(i);
      if (charInAReverse == '0' && charInBReverse == '0') {
        if (carryFoward) sb.append(1);
        else sb.append(0);
        carryFoward = false;
      } else if ((charInAReverse == '0' && charInBReverse == '1')
          || (charInBReverse == '0' && charInAReverse == '1')) {
        if (carryFoward) {
          sb.append(0);
          carryFoward = true;
        } else {
          sb.append(1);
          carryFoward = false;
        }
      } else if (charInBReverse == '1' && charInAReverse == '1') {
        if (carryFoward) {
          sb.append(1);
          carryFoward = true;
        } else {
          sb.append(0);
          carryFoward = true;
        }
      }
    }
    if (carryFoward) sb.append(1);
    var result = sb.reverse();
    return result.toString();
  }

  public String addBinaryByTakingIntegerValue(String a, String b) {
    var aInteger = Integer.parseInt(a);
    var bInteger = Integer.valueOf(b);
    StringBuilder sb = new StringBuilder();
    boolean carryFoward = false;
    while (aInteger > 0 || bInteger > 0) {
      var charInAReverse = aInteger % 10;
      var charInBReverse = bInteger % 10;
      if (charInAReverse == 0 && charInBReverse == 0) {
        if (carryFoward) sb.append(1);
        else sb.append(0);
        carryFoward = false;
      } else if ((charInAReverse == 0 && charInBReverse == 1)
          || (charInBReverse == 0 && charInAReverse == 1)) {
        if (carryFoward) {
          sb.append(0);
          carryFoward = true;
        } else {
          sb.append(1);
          carryFoward = false;
        }
      } else if (charInBReverse == 1 && charInAReverse == 1) {
        if (carryFoward) {
          sb.append(1);
          carryFoward = true;
        } else {
          sb.append(0);
          carryFoward = true;
        }
      }
      aInteger = aInteger / 10;
      bInteger = bInteger / 10;
    }
    if (carryFoward) sb.append(1);
    var result = sb.reverse();
    return result.toString();
  }
}
