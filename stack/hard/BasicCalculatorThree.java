package Stack.Hard;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

/**
 * Problem: Acceptance: 23.5%
 *
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ) , the plus + or minus sign
 * - , non-negative integers and empty spaces .
 *
 * The expression string contains only non-negative integers, +, -, *, / operators, open ( and
 * closing parentheses ) and empty spaces . The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be
 * in the range of [-2147483648, 2147483647].
 *
 * Some examples:
 * "1 + 1"  = 2
 * "6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3" = -12
 *
 * Note : Do not use the eval built-in library function.
 *
 * @author rovo98
 * Date: 24/2/2018
 *
 */
public class BasicCalculatorThree {
   // Solution one: ^
   /*
   Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(n).
    */
   public int calculate(String s) {
       final String NUMBERS = "0123456789";
       final String OPERATIONS = "+-*/()";

       Stack<String> nums = new LinkedStack<>();
       Stack<Character> ops = new LinkedStack<>();

       s = s.concat("#");   // the end signal
       ops.push('#'); // the start signal
       int index = 0;

       while (s.charAt(index) != '#') {
           char c = s.charAt(index);
           if (NUMBERS.contains("" + c)) {
               String num = "" + c;
               while (NUMBERS.contains("" + s.charAt(++index))) {
                   num = num.concat("" + s.charAt(index));
               }
               nums.push(num);
           } else if (OPERATIONS.contains("" + c)) {
               switch (priority(ops.peek(), c)) {
                   case '>':                // if the top ops in stack's priority higher than c, deal with the ops.
                        int num_two = Integer.parseInt(nums.pop());
                        int num_one = Integer.parseInt(nums.pop());
                        nums.push("" + compute(ops.pop(), num_one, num_two));
                        break;
                   case '<':                 // if the top ops in stack's priority lower than c.
                       ops.push(c);
                       index++;
                       break;
                   case '=':
                       ops.pop();
                       index++;
                       break;
                   case '&':
                       throw new UnsupportedOperationException("This expression is invalid.");
               }
           } else if (c == ' '){            // Ignoring the empty space character.
               index++;
           }
       }
       while (ops.peek() != '#' && nums.size() >= 2) {
           int numB = Integer.parseInt(nums.pop());
           int numA = Integer.parseInt(nums.pop());
           nums.push("" + compute(ops.pop(), numA, numB));
       }
       return Integer.parseInt(nums.pop());
   }

    /**
     * Returns the priority of opA to opB.
     * @param opA the character representing one operation.
     * @param opB the character representing another operation.
     * @return  {@code '>'} if opA's priority is greater than opB's
     *          {@code '='} if opA's priority is equals to opB's
     *          {@code '<'} otherwise.
     */
    private char priority(char opA, char opB) {
       final String PM_greater = "+-)#";     // The ops that the minus and plus have greater priority to
       final String PM_less = "*/(";         // the ops that the minus and plus have lower priority to
       final String MD_greater = "+-*/)#";   // the ops that the multiply and division have greater priority to
       final String MD_less = "(";           // the ops that the mul and div have lower priority to
       final String LP_less = "+-*/(#";      // the ops that '(' has lower priority to
       final String LP_equals = ")";         // the ops that '(' has the same priority to
       final String RP_greater = "+-*/#";   // the ops that ')' has the greater priority to
       final String RP_equals = "(";        // the ops that ')' has the same priority to
       final String S_less = "+-*/(";       // the ops that '#' has the lower priority to
       final String S_equal = "#";          // the ops that '#' has the same priority to

        switch (opA) {
            case '+':
                if (PM_greater.contains("" + opB)) {
                    return '>';
                } else if (PM_less.contains("" + opB)) {
                    return '<';
                }
                break;
            case '-':
                if (PM_greater.contains("" + opB)) {
                    return '>';
                } else if (PM_less.contains("" + opB)) {
                    return '<';
                }
                break;
            case '*':
                if (MD_greater.contains("" + opB)) {
                    return '>';
                } else if (MD_less.contains("" + opB)) {
                    return '<';
                }
                break;
            case '/':
                if (MD_greater.contains("" + opB)) {
                    return '>';
                } else if (MD_less.contains("" + opB)) {
                    return '<';
                }
                break;
            case '(':
                if (LP_equals.contains("" + opB)) {
                    return '=';
                } else if (LP_less.contains("" + opB)) {
                    return '<';
                }
                break;
            case ')':
                if (RP_equals.contains("" + opB)) {
                    return '=';
                } else if (RP_greater.contains("" + opB)) {
                    return '>';
                }
                break;
            case '#':
                if (S_equal.contains("" + opB)) {
                    return '=';
                } else if (S_less.contains("" + opB)) {
                    return '<';
                }
                break;
        }
        return '&'; // It is the case that is not allowed.
    }

    /**
     * Returns the result of {@code numA} and {@code numB} for doing {@code op} operation.
     * @param op   A kind of operations.
     * @param numA the first calc num.
     * @param numB the second calc num.
     * @return the result of {@code numA} and {@code numB} for doing {@code op} operation.
     */
    private int compute(char op, int numA, int numB) {
        switch (op) {
            case '+':
                return numA + numB;
            case '-':
                return numA - numB;
            case '*':
                return numA * numB;
            case '/':
                if (numB != 0) {
                    return numA / numB;
                }
                break;
        }
        return 0;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        BasicCalculatorThree bct = new BasicCalculatorThree();
        String testStr = "1 + 1";
        String testStr2 = "6-4 / 2 ";
        String testStr3 = "2*(5+5*2)/3+(6/2+8)";
        String testStr4 = "(2+6* 3+5- (3*14/7+2)*5)+3";
        System.out.println("The result for expression " + testStr + " is " + bct.calculate(testStr) + ".");
        System.out.println("The result for expression " + testStr2 + " is " + bct.calculate(testStr2) + ".");
        System.out.println("The result for expression " + testStr3 + " is " + bct.calculate(testStr3) + ".");
        System.out.println("The result for expression " + testStr4 + " is " + bct.calculate(testStr4) + ".");
    }
}
