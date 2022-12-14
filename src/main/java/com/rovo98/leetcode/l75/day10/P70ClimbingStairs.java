package com.rovo98.leetcode.l75.day10;

/**
 * https://leetcode.com/problems/climbing-stairs
 */
public class P70ClimbingStairs {
    /*
    TC: O(n)
    SC: O(n)

    C(n) = C(n-1) + C(n-2), n >= 3
     */
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }

    public int climbStairsOpt(int n) {
        if (n <= 3) return n;
        int a, b = 2, c = 3;

        for (int i = 0; i < n - 3; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
