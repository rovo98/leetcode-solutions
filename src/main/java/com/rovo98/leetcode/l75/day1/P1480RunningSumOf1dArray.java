package com.rovo98.leetcode.l75.day1;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class P1480RunningSumOf1dArray {
    /*
    TC: O(n)
    SC: O(n)
     */
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = nums[0];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }
}
