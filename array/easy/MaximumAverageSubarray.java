package Array.Easy;

/**
 * Problem : Acceptance: 37.8%
 * Given an array consisting of n integers, find the contiguous subarray of given length
 * k that has the maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 * Input : [1, 12, -5, -6, 50, 3], k = 4
 * Output : 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 12.75.
 *
 * Note :
 *    1. 1 <= k <= n <= 30000.
 *    2. Elements of the given array will be in the range[-10000, 10000].
 *
 * @author rovo98
 * Date: 12/2/2018
 */
public class MaximumAverageSubarray {
    // Solution one: ^
    // This algorithm's time complexity is O(n^2).
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i + k > nums.length) {
                break;
            }
            int sum = nums[i];
            for (int j = i+1; j < k+i; j++) {
                sum += nums[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return (double)maxSum / k;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        MaximumAverageSubarray mas = new MaximumAverageSubarray();
        int[] testArr = {1, 12, -5, -6, 50, 3};
        System.out.println("The input test array is the following:");
        for (int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
        System.out.println("And the maximum average is " + mas.findMaxAverage(testArr, 4));
    }
}
