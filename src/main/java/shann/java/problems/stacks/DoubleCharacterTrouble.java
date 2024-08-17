package shann.java.problems.stacks;

import java.util.Objects;
import java.util.Stack;

/*
Problem Description
You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.


Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is string A.



Output Format
Return the final string.



Example Input
Input 1:

 A = "abccbc"
Input 2:

 A = "ab"


Example Output
Output 1:

 "ac"
Output 2:

 "ab"


Example Explanation
Explanation 1:

The Given string is "abccbc".

Remove the first occurrence of consecutive identical pairs of characters "cc".
After removing the string will be "abbc".

Again Removing the first occurrence of consecutive identical pairs of characters "bb".
After remvoing, the string will be "ac".

Now, there is no consecutive identical pairs of characters.
Therefore the string after this operation will be "ac".
Explanation 2:

 No removals are to be done.
 */
public class DoubleCharacterTrouble {
  public static void main(String[] args) {
    System.out.println(removeDoubleCharAndReturnFinalString("abccbc"));
  }

  private static String removeDoubleCharAndReturnFinalString(String input) {
    if (Objects.isNull(input) || input.isEmpty()) {
      return null;
    }
    Stack<Character> stack = new Stack<>();
    for (char c : input.toCharArray()) {
      if (stack.isEmpty()) stack.push(c);
      else if (stack.peek() == c) {
        stack.pop();
      } else stack.push(c);
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb = sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}
