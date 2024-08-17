package shann.java.problems.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/*
* Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.



Problem Constraints
1 <= |A| <= 100



Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.



Output Format
Return 0 if the parenthesis sequence is not balanced.

Return 1 if the parenthesis sequence is balanced.



Example Input
Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[]


Example Output
Output 1:

 1
Output 2:

 0
Output 3:

 1
 * */
public class BalancedParanthesis {
  public static void main(String[] args) {
    System.out.println(isBalanced(")))))"));
  }

  public static boolean isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    if (Objects.isNull(s) || s.isEmpty()) return true;

    for (int i = 0; i < s.length(); i++) {
      if (List.of('(', '{', '[').contains(s.charAt(i))) stack.push(s.charAt(i));
      else if (stack.isEmpty()) return false;
      else if (s.charAt(i) == ')') {
        if (stack.peek() == '(') stack.pop();
        else return false;
      } else if (s.charAt(i) == ')') {
        if (stack.peek() == '(') stack.pop();
        else return false;
      } else if (s.charAt(i) == '}') {
        if (stack.peek() == '{') stack.pop();
        else return false;
      } else if (s.charAt(i) == ']') {
        if (stack.peek() == '[') stack.pop();
        else return false;
      }
    }
    if (stack.isEmpty()) return true;
    return false;
  }
}
