package Stack.Medium;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Acceptance: 47.95
 *
 * Given a circular array (the next element of the last element is the first element of the
 * array), print the Next Greater Number for every element. The Next Greater Number of a
 * number x is the first greater number to its traversing-order next in the array, which
 * means you could search circularly to find its next greater number. If it doesn't exist.
 * output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The number 1's next greater number needs to search circularly, which is also 2.
 *
 * Note : The length of given array won't exceed 10000.
 *
 * @author rovo98
 * Date: 22/2/2018
 */
public class NextGreaterElementTwo {
    // Solution one: ^&
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(n).
     */
    public int[] nextGreaterElement(int[] nums) {
        /*
        Using an idea learning from "NextGreaterElementOne" problem which have the note that
        its two nums are unique. And here the solution is the same as before.
         */
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new LinkedStack<>();

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.getOrDefault(nums[i], -1);
        }
        return result;
    }


    // Driver the program to test the method above.
    public static void main(String[] args) {
        NextGreaterElementTwo nget = new NextGreaterElementTwo();
        int[] testArr = {1, 2, 1};
        System.out.println("The input test array is the following:");
        for (int elem : testArr) {
            System.out.print(elem + " ");
        }
        System.out.println();
        int[] result = nget.nextGreaterElement(testArr);
        System.out.println("And the result of it is the following:");
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
