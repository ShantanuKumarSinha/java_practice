package shann.java.problems.secure.random;

import java.security.SecureRandom;
import org.apache.commons.lang3.RandomStringUtils;

public class GenerateStringUsingSecureRandom {
  private static final String CHARACTERS =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  private static final int LENGTH = 16;

  public static void main(String[] args) {
    System.out.println(generateString());
    System.out.println(RandomStringUtils.random(16, 0, 0, true, true, null, new SecureRandom()));
  }

  public static String generateString() {
    StringBuilder sb = new StringBuilder(LENGTH);
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < LENGTH; i++) {
      var index = random.nextInt(CHARACTERS.length());
      sb.append(CHARACTERS.charAt(index));
    }
    return sb.toString();
  }
}
