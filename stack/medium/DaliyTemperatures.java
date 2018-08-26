package Stack.Medium;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Acceptance: 53.8%
 *
 * Given a list of daily temperatures, produce a list that, for each in the input, tells
 * you how many days you would have to wait until a warmer temperature. If there is no
 * future day for which this is possible, put 0 instead.
 *
 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output
 * should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note : The length of temperatures will be in the range [1, 30000]. Each temperature will be
 * an integer in the range [30, 100].
 *
 * @author rovo98
 * Date: 22/2/2018
 */
public class DailyTemperatures {
    // Solution two: ^
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(n).
     */
    public int[] daliyTemperatures(int[] temperatures) {
        /*
        Using an idea learning from the "NextGreaterElementOne" problem that
        we use a map to store the index of the next greater temperature to each temperature.
        Then iterates them to find out the steps to their next greater temperature.
         */
        if (temperatures.length == 1) {
            return new int[] {0};
        }
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new LinkedStack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                map.put(stack.pop(), i);      // map each tp's index with its next greater tp's index.
            }
            stack.push(i);
        }

        int[]  result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int index = map.getOrDefault(i, 0);
            if (index > 0) {
                result[i] = index - i;
            }
        }
        return result;
    }
    // Solution one: ^  brute force approach.
    // This approach doesn't use the stack.
    /*
    Complexity Analysis:
        Time complexity: O(n^2).
        Space complexity: O(n).
     */
    public int[] dailyTemperaturesVersionOne(int[] temperatures) {
        /*
        Iterates all the temperatures in the array to find out whether there is a temperature
        after the temperature we iterated and greater than it.
         */
        if (temperatures.length == 1) {
            return new int[] {0};
        }
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            boolean flag = true;
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[i] = 0;
            }
        }
        return result;
    }


    // Driver the program to test method above.
    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[]  testTemperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("The input test temperatures is the following:");
        for (int t : testTemperatures) {
            System.out.print(t + " ");
        }
        System.out.println();
        int[] result = dt.dailyTemperaturesVersionOne(testTemperatures);
        int[] result_1 = dt.daliyTemperatures(testTemperatures);
        System.out.println("And the result of it using brute force the following:");
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
        System.out.println("And the result of it using stack is the following:");
        for (int r : result_1) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
