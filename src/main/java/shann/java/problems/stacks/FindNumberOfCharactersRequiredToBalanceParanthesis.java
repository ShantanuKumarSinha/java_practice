package shann.java.problems.stacks;

import java.util.Stack;

/*
 Given A String only containing paranthesises '(' & ')'
 Find the number of character required to balance out the given string
 We require 1 '(' and 2 '))' to balance out the paranthesises
Example :
    Input 1 : "(()))"
    Output1 : 1
    Input 2 : "())"
    Output 2 : 0
    Input 3 : "))())("
    Output3 : 3
Explanation :
    Input 1 : There is two opening paranthesis and 3 closing paranthesis we need to add one.
    Input 2 : There is one opening and two closing paranthesis, which makes it balanced so required paranthesis is 0.
    Input 3 : There is two closing paranthesis in the beginning we require 1 oepning parantheis to close it and
    for one opening parantheis at the end we require two closing paranthesies so Count become 3 here
 */
public class FindNumberOfCharactersRequiredToBalanceParanthesis {
  public static void main(String[] args) {
    String s1 = "(()))";
    String s2 = "())";
    String s3 = "))())(";
    String s4 = "((())";
    var result1 = findNumberOfCharactersRequiredToBalanceParanthesis(s1);
    System.out.println(result1);
    var result2 = findNumberOfCharactersRequiredToBalanceParanthesis(s2);
    System.out.println(result2);
    var result3 = findNumberOfCharactersRequiredToBalanceParanthesis(s3);
    System.out.println(result3);
    var result4 = findNumberOfCharactersRequiredToBalanceParanthesis(s4);
    System.out.println(result4);
  }

  private static int findNumberOfCharactersRequiredToBalanceParanthesis(String s) {
    Stack<Character> stack = new Stack<>();
    var count = 0;
    boolean halfClosingFound = false, fullClosingFound = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') stack.push(s.charAt(i));
      else if (stack.isEmpty() && !halfClosingFound) {
        halfClosingFound = true;
        count += 2;
      } else if (stack.isEmpty() && halfClosingFound) {
        // fullClosingFound = true;
        halfClosingFound = false;
        count -= 1;
      } else if (!halfClosingFound) halfClosingFound = true;
      else if (halfClosingFound) {
        // fullClosingFound = true;
        halfClosingFound = false;
        stack.pop();
      }
    }
    count += halfClosingFound ? stack.size() * 2 - 1 : stack.size() * 2;
    return count;
  }
}
