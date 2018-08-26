package Stack.Medium;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

/**
 * Problem: Acceptance: 28.0%
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operations are + , - , * , / . Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> ((4 + (13 / 5)) -> 6
 *
 * @author rovo98
 * Date: 22/2/2018
 */
public class EvaluateReversePolishNotation {
    // Solution one : ^
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(1).
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new LinkedStack<>();

        for (String token : tokens) {
            int num;
            switch (token) {
                case "+":
                    num = Integer.parseInt(stack.pop());
                    stack.push((Integer.parseInt(stack.pop()) + num) + "");
                    break;
                case "-":
                    num = Integer.parseInt(stack.pop());
                    stack.push((Integer.parseInt(stack.pop()) - num) + "");
                    break;
                case "*":
                    num = Integer.parseInt(stack.pop());
                    stack.push((Integer.parseInt(stack.pop()) * num) + "");
                    break;
                case "/":
                    num = Integer.parseInt(stack.pop());
                    stack.push((Integer.parseInt(stack.pop()) / num) + "");
                    break;
                default:
                    stack.push(token);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
        String[] testTokens = {"2", "1", "+", "3", "*"};
        String[] testTokens_1 = {"4", "13", "5", "/", "+"};
        System.out.println("The input test tokens one is the following:");
        for (String token : testTokens) {
            System.out.print(token + " ");
        }
        System.out.println();
        System.out.println("And its result is " + erpn.evalRPN(testTokens) + ".");
        System.out.println("The input test tokens two is the following:");
        for (String token : testTokens_1) {
            System.out.print(token + " ");
        }
        System.out.println();
        System.out.println("And its result is " + erpn.evalRPN(testTokens_1) + ".");
    }
}
