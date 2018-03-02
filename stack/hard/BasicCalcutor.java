package Stack.Hard;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

/**
 * Problem: Acceptance: 28.2%
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign
 * -, non-negative integers and empty spaces.
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2" = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 *
 * Note : Do not use the eval built-in library function.
 *
 * @author rovo98
 * Date: 23/2/2018
 *
 */
public class BasicCalculator {
    // Solution one: ^
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(n).
     */
    public int calculate(String s) {
        /*
        use one stack to store the numbers and one to store the operations.
        And in this case, we can just ignore the priority of the operations because plus and minus
        have the same calculating priority.
         */
        Stack<Integer> nums = new LinkedStack<>();
        Stack<Character> ops = new LinkedStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ' ' || c == ')') { }   // Ignoring the empty space, ( and ) characters.
            else if (c == '+' || c == '-') {
                if (!ops.isEmpty()) {
                    int num = nums.pop();
                    char op = ops.pop();
                    if (op == '+') {
                        nums.push(nums.pop() + num);
                    } else if (op == '-') {
                        nums.push(nums.pop() - num);
                    }

                }
                ops.push(c);
            } else {
                nums.push(Integer.parseInt("" + c));
            }
        }
        // compute the result.
        while (!ops.isEmpty()) {  // in this case, there is only one ops in the stack finally.
            int num = nums.pop();
            switch (ops.pop()) {
                case '+':
                    nums.push(nums.pop() + num);
                    break;
                case '-':
                    nums.push(nums.pop() - num);
                    break;
            }
        }
        return nums.pop();
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        String testExp = "1 + 1";
        String testExp1 = "2-1 + 2";
        String testExp2 = "(1+(4+5+2)-3)+(6+8))";
        System.out.println("The result for " + testExp + " is " + bc.calculate(testExp) + ".");
        System.out.println("The result for " + testExp1 + " is " + bc.calculate(testExp1) + ".");
        System.out.println("The result for " + testExp2 + " is " + bc.calculate(testExp2) + ".");
    }
}
