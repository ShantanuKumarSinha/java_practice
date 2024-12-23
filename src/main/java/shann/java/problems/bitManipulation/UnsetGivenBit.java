package shann.java.problems.bitManipulation;

public class UnsetGivenBit {
  public static void main(String[] args) {
    UnsetGivenBit unsetGivenBit = new UnsetGivenBit();
    var result = unsetGivenBit.unset(49, 0);
    System.out.println(result);
  }

  public int unset(int A, int B) {
    if (checkBit(A, B)) A = A ^ (1 << B);
    return A;
  }

  private boolean checkBit(int N, int i) {
    if ((N&(1<<i)) > 0) return true;
    else return false;
  }
}
