package com.rovo98.leetcode.slidingwidow;

/**
 * Given an array of integers `arr` and two integers `k` and `threshold`, return the number of
 * sub-arrays of size `k` and average greater than or equal to `threshold`.
 *
 * <p>Example 1:
 *
 * <p>Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4 Output: 3 Explanation: Sub-arrays
 * [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3
 * have averages less than 4 (the threshold).
 *
 * <p>Example 2: Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5 Output: 6
 * Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages
 * are not integers.
 *
 * <p>Constraints: - 1 <= arr.length <= 10^5 - 1 <= arr[i] <= 10^4 - 1 <= k <= arr.length - 0 <=
 * threshold <= 10^4
 *
 * @link
 *     https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold
 */
public class P1343_NumOfSubArraysOfSizeKAndAvgGreaterThanOrEq2Threshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        if (arr.length < k) return result;

        int ws = 0, we = ws + k;
        int windowSum = arr[ws];

        // first window
        for (int i = ws + 1; i < we; i++) {
            windowSum += arr[i];
        }
        if (windowSum / k >= threshold) result++;

        for (ws++, we++; we <= arr.length; ws++, we++) {
            windowSum = windowSum - arr[ws-1] + arr[we-1];
            if ((windowSum / k) >= threshold) result += 1;
        }
        return result;
    }
}
