package shann.java.problems.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ColorfulNumber {
  public static void main(String[] args) {
    int input = 3245;
    System.out.println(colorful(input));
  }

  public static int colorful(int A) {
    HashSet< Integer > hashSet = new HashSet < > ();
    ArrayList < Integer > numbers = new ArrayList< >();
    while (A != 0) {
      int num = A % 10;
      numbers.add(num);
      A /= 10;
    }
    Collections.reverse(numbers);
    int n = numbers.size();
    for (int i = 0; i < n; i++) {
      int prod = 1;
      for (int j = i; j < n; j++) {
        // prod stores the product of every digit in the range [i..j]
        prod *= numbers.get(j);
        // check if the product is unique
        if (hashSet.contains(prod))
          return 0;
        hashSet.add(prod);
      }
    }
    return 1;
  }

  private static int colorfulViaString(int input) {
    var inputInString = Integer.toString(input);
    var subArrayOfNumber = new ArrayList<Integer>();
    var productOfNumber = new ArrayList<Integer>();
    for (int si = 0; si < inputInString.length(); si++) {
      for (int ei = si+1; ei <= inputInString.length(); ei++) {
        subArrayOfNumber.add(Integer.parseInt(inputInString.substring(si, ei)));
      }
    }
    for(int i=0; i<subArrayOfNumber.size(); i++) {
      int n = subArrayOfNumber.get(i);
      int product = 1;
      while(n>0){
        product *=n%10;
        n=n/10;
      }
      if (productOfNumber.contains(product)) return 0;
      else productOfNumber.add(product);
    }
    return 1;
  }

}
