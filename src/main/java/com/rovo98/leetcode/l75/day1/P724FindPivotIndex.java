package com.rovo98.leetcode.l75.day1;

/**
 * https://leetcode.com/problems/find-pivot-index
 */
public class P724FindPivotIndex {
    /*
    TC: O(n)
    SC: O(1)
     */
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;

        int overallSum = 0;
        int len = nums.length;
        for (int num : nums) {
            overallSum += num;
        }

        int sumOfLeft = 0;
        int sumOfRight = overallSum - nums[0];
        for (int p = 0; p < len; p++) {
            if (sumOfLeft == sumOfRight) return p;

            sumOfLeft += nums[p];
            if ((p+1) == len) {
                sumOfRight = 0;
            } else {
                sumOfRight -= nums[p+1];
            }
        }
        return -1;
    }
}
