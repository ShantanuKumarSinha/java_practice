package shann.java.problems.recursion;

//
public class ValueOfMoneyAfterDepreceation {
  public static void main(String[] args) {
    int money = 15000000;
    int depreceation = 6;
    int tenuer = 15;
    int deprecatedValue = 0;
    var effectiveMoney = findDepreceatedValue(money, depreceation, tenuer);
    System.out.println(effectiveMoney);
  }

  private static int findDepreceatedValue(int money, int depreceation, int tenuer) {
    if (tenuer == 0) return money;
    money = money - (money * depreceation / 100);
    return findDepreceatedValue(money, depreceation, tenuer - 1);
  }
}
