package shann.java.problems.stacks;

import java.util.*;


/*
Problem Description
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.


Problem Constraints
1 <= length of the string <= 500000



Input Format
The only argument given is string A.



Output Format
Return a string denoting the postfix conversion of A.



Example Input
Input 1:

 A = "x^y/(a*z)+b"
Input 2:

 A = "a+b*(c^d-e)^(f+g*h)-i"


Example Output
Output 1:
xy^az*'/'b+
/*
Output 2:

        "abcd^e-fgh*+^*+i-"


Example Explanation
Explanation 1:

Ouput dentotes the postfix expression of the given input.
1+2*3
123*+
 */
//TODO very important for revision
public class ConvertInfixExpressionToPostFix {
  public static void main(String[] args) {
    var result = getPostFixExpression("a+b*(c^d-e)^(f+g*h)-i");
    System.out.println(result);

    var result2 = getPostFixExpression("a*(r+o*h)");
    System.out.println(result2);
  }

  private static String getPostFixExpression(String expression) {

    if (Objects.isNull(expression) || expression.isEmpty()) return null;

    Stack<Character> operatorStack = new Stack<>();

    Map<Character, Integer> precedenceMap = new HashMap<>();
    precedenceMap.put('+', 1);
    precedenceMap.put('-', 1);
    precedenceMap.put('*', 2);
    precedenceMap.put('/', 2);
    precedenceMap.put('^', 3);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < expression.length(); i++) {
      if (i == 19) System.out.println("debug here");
      if (precedenceMap.containsKey(expression.charAt(i))) {
        if (operatorStack.empty()) {
          operatorStack.push(expression.charAt(i));
        } else if (operatorStack.peek() == '(') {
          operatorStack.push(expression.charAt(i));
        } else if (precedenceMap.get(operatorStack.peek())
            < precedenceMap.get(expression.charAt(i))) {
          operatorStack.push(expression.charAt(i));
        } else {
          while (!operatorStack.empty()
              && precedenceMap.containsKey(operatorStack.peek())
              && precedenceMap.get(operatorStack.peek())
                  >= precedenceMap.get(expression.charAt(i))) {
            sb.append(operatorStack.pop());
          }
          operatorStack.push(expression.charAt(i));
        }
      } else if (expression.charAt(i) == '(') {
        operatorStack.push(expression.charAt(i));
      } else if (expression.charAt(i) == ')') {
        while (operatorStack.peek() != '(') sb.append(operatorStack.pop());
        operatorStack.pop();
      } else sb.append(expression.charAt(i));
    }
    while (!operatorStack.isEmpty()) sb.append(operatorStack.pop());
    return sb.toString();
  }
}
