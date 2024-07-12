package shann.java.problems.Strings;

import java.util.*;

public class ShowTheCharacterOfAStringAccordingToTheirCount {

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
    var countList = new ArrayList<Integer>();
    characterIntegerMap.values().forEach(value -> countList.add(value));
    Collections.sort(countList);
    for (Integer count : countList) {
      for (Map.Entry<Character, Integer> mapEntry : characterIntegerMap.entrySet()) {
        if (mapEntry.getValue() == count) {
          sb.append(mapEntry.getKey());
        }
      }
    }
    System.out.println(sb.toString());
  }
}
