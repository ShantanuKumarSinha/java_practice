package shann.java.problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RainWaterTrapped {
  public static void main(String[] args) {
    RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
    System.out.println(rainWaterTrapped.trap(List.of(0,1,0,2,1,0,1,3,2,1,2,1)));
  }

  public int trap(List<Integer> heights) {
    int ans = 0;
    List<Integer> lMax = new ArrayList<>();
    List<Integer> rMax = new ArrayList<>();
    lMax.add(0);
    for (int i = 1; i < heights.size(); i++) {
      if (heights.get(i - 1) > lMax.get(i - 1)) lMax.add(heights.get(i - 1));
      else lMax.add(lMax.get(i - 1));
    }
    rMax.add(0);
    for (int i = heights.size() - 2; i >= 0; i--) {
      if (i == heights.size() - 2) rMax.add(heights.get(i + 1));
      else if (heights.get(i + 1) > rMax.get(rMax.size()-1)) rMax.add(heights.get(i + 1));
      else rMax.add(rMax.get(rMax.size()-1));
    }
    Collections.reverse(rMax);
 
    int water = 0;
    for (int i = 1; i <= heights.size() - 2; i++) {
      if (lMax.get(i) > rMax.get(i)) water = rMax.get(i) - heights.get(i);
      else water = lMax.get(i) - heights.get(i);
      if (water > 0) ans += water;
    }

    return ans;
  }
}
