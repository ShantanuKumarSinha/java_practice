package shann.java.problems.hashMapAndHashSet;

import java.util.*;

public class KillEnemy {
  public static void main(String[] args) {
    var A =
        new ArrayList(
            List.of(
                47, 96, 35, 48, 92, 63, 25, 61, 49, 58, 36, 80, 98, 96, 71, 19, 29, 85, 40, 17, 58,
                49, 12, 76, 50, 97, 17, 47, 82, 25, 53, 79, 93, 27, 82, 93, 95, 62, 50, 40, 83, 26,
                62, 24, 26, 84, 74));
    int B = 293;
    int result = solve(A, B);
    System.out.println(result);
  }

  public static int solve(ArrayList<Integer> A, int B) {
    int sum = 0;
    Collections.sort(A, Collections.reverseOrder());
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < A.size(); i++) {
      sum += A.get(i);
      set.add(A.get(i));
      if (sum >= B) {
        break;
      }
    }
    return set.size();
  }
}
