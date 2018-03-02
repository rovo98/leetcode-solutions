package Stack.Easy;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

/**
 * Problem: Acceptance: 58.6%
 *
 * You're now a baseball game point recorder.
 *
 * Given a list of strings, each string can be one of the 4 following types:
 *
 *   1. Integer (one round's score): Directly represents the number of points you get in this round.
 *   2. "+" (one round's score): Represents that the points you get in this round are the sum
 *   of the last two valid round's points.
 *   3. "D" (one round's score): Represents that the points you get in this round are
 *   doubled data of the last valid round's points.
 *   4. "C" (an operation, which isn't round's score): Represents the last valid
 *   round's points you get were invalid and should be removed.
 *
 * Each round's operation is permanent and could have an impact on the round before
 * and the round after.
 * You need to return the sum of the points you could get in all the rounds.
 *
 * Example 1:
 * Input: ["5", "2", "C", "D", "+"]
 * Output: 30
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.
 * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 *
 * Example 2:
 * Input: ["5", "-2", "4", "C", "D", "9", "+", "+"]
 * Output: 27
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get -2 points. The sum is: 3.
 * Round 3: You could get 4 points. The sum is: 7.
 * Operation 1: The round 3's data is invalid. The sum is: 3.
 * Round 4: You could get -4 points. The sum is: -1.
 * Round 5: You could get 9 points. The sum is: 8.
 * Round 6: You could get -4 + 9 = 5 points. The sum is 13.
 * Round 7: You could get 9 + 5 = 14 points. The sum is: 27.
 *
 * Note :
 *     1. The size of the input list will be between 1 and 1000.
 *     2. Every integer represented in the list will be between -30000 and 30000.
 *
 * @author rovo98
 * Date: 13/2/2018
 */
public class BaseballGame {
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new LinkedStack<>();
        for (String op : ops) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int num = stack.pop();
                    int point = stack.peek() + num;
                    stack.push(num);
                    stack.push(point);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        // compute the result.
        while (stack.size() > 1) {
            stack.push(stack.pop() + stack.pop());
        }
        return stack.pop();
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        BaseballGame bbg = new BaseballGame();
        String[] testOps = {"5", "2", "C", "D", "+"};
        String[] testOps1 = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        System.out.println("The input ops is the following:");
        for (String ops : testOps) {
            System.out.print(ops + " ");
        }
        System.out.println("\nAnd the result of it is " + bbg.calPoints(testOps) + ".");
        System.out.println("The input test ops 2 is the following:");
        for (String ops : testOps1) {
            System.out.print(ops + " ");
        }
        System.out.println("\nAnd its result is " + bbg.calPoints(testOps1) + ".");
    }
}
