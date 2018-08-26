package Stack.Easy;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem: Acceptance: 33.9%
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[', ']', determine
 * if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "([)]" are not.
 *
 * @author rovo98
 * Date: 08/2/2018
 */
public class ValidParentheses {
    private boolean isMatch(char charA, char charB) {
        if (charA == '(' && charB == ')') {
            return true;
        }
        else if (charA == '[' && charB == ']') {
            return true;
        }
        else if (charA == '{' && charB == '}') {
            return true;
        }
        else {
            return false;
        }
    }
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public boolean isValid(String s) {
        final String LEFT_PARENTHESES = "([{";
        final String RIGHT_PARENTHESES = ")]}";

        Stack<Character> pStack = new LinkedStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (LEFT_PARENTHESES.contains(""+c)) {
                pStack.push(c);
            } else if (RIGHT_PARENTHESES.contains(""+c)) {
                if (isMatch(pStack.peek(), c)) {
                    pStack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String testString1 = "({[]})";
        String testString2 = "([{]})";
        if (vp.isValid(testString1)) {
            System.out.println(testString1+" is valid.");
        } else {
            System.out.println(testString1+" is invalid.");
        }
        if (vp.isValid(testString2)) {
            System.out.println(testString2+" is valid.");
        } else {
            System.out.println(testString2+" is invalid.");
        }
    }
}
