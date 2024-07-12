package shann.java.problems.Strings;

import java.util.*;

public class ArrangeTheLetterOfStringAsPerCount {

  //    Given text: "aaaaaaammdddddkkkkx"
  //    Sorted result: "xmmkkkkdddddaaaaaaa"

  public static void main(String[] args) {
    String text = "aaaaaaammdddddkkkkx";
    Map<Character, Integer> characterIntegerMap = new HashMap<>();
    for (Character character : text.toCharArray()) {
      if (characterIntegerMap.containsKey(character)) {
        characterIntegerMap.put(character, characterIntegerMap.get(character) + 1);
      } else {
        characterIntegerMap.put(character, 1);
      }
    }
    StringBuilder sb = new StringBuilder();
    List<Integer> counts = (List<Integer>) characterIntegerMap.values();
    Collections.sort(counts);
    for (Integer count : counts) {
      for (Map.Entry<Character, Integer> mapEntry : characterIntegerMap.entrySet()) {
        if (mapEntry.getValue().equals(count)) {
          sb.append(mapEntry.getKey());
        }
      }
    }
    System.out.println(sb.toString());
  }
}
