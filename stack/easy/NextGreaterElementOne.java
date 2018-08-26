package Stack.Easy;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Acceptance: 56.7%
 *
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1's elements
 * are subset of nums2. Find all the next greater numbers for nums1's elements in the
 * corresponding places of nums2.
 *
 * The next Greater Number of a number x in nums1 is the first greater number to its
 * right in nums2. If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it
 * in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array
 * is 3.
 * For number 2 in the first array, there is not next greater number for it in the
 * second array, so output -1.
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second
 * array is 3.
 * For number 4 in the first array, there is no next greater number for it in the
 * second array, so output -1.
 *
 * Note:
 *    1. All elements in nums1 and nums2 are unique.
 *    2. The length of both nums1 and nums would not exceed 1000.
 *
 * @author rovo98
 * Date: 22/2/2018
 */

public class NextGreaterElementOne {
    // Solution one : && From discussion on leetcode.
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(nums2.length).
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
        For example : [9, 8, 7, 3, 2, 1, 6]
        The stack will first contain [9, 8, 7, 3, 2, 1] and then we will see 6 which is greater than 1, 2, 3
        so we pop 1, 2, 3 whose next greater element is 6.
         */
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new LinkedStack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
    // Solution one Improved: &&&
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(findNums.length).
     */
    public int[] nextGreaterElementImproved(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new LinkedStack<>();
        // Initializes each element in findNums's next greater element. default : -1.
        for (int num : findNums) {
            map.put(num, -1);
        }

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            if (map.containsKey(num)) {     // Only push the elements in both findNums and nums.
                stack.push(num);
            }
        }

        int[] result = new int[findNums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(findNums[i]);
        }
        return result;
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        NextGreaterElementOne ngeo = new NextGreaterElementOne();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println("The input test nums1 and nums2 is the following:");
        for (int aNum1 : nums1) {
            System.out.print(aNum1 + " ");
        }
        System.out.println();
        for (int aNum2 : nums2) {
            System.out.print(aNum2 + " ");
        }
        System.out.println("\nAnd the result is the following:");
        int[] result = ngeo.nextGreaterElement(nums1, nums2);
        int[] result_2 = ngeo.nextGreaterElementImproved(nums1, nums2);
        for (int ar : result) {
            System.out.print(ar + " ");
        }
        System.out.println();
        System.out.println("And the result got from the improved function is the following:");
        for (int ar : result_2) {
            System.out.print(ar + " ");
        }
        System.out.println();
    }
}
