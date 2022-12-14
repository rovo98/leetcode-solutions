package com.rovo98.leetcode.l75.day10;

/** https://leetcode.com/problems/fibonacci-number */
public class P509FibonacciNumber {
    /*
    dp approach
    TC: O(n)
    SC: O(n)
    F(0) = 0, F(1) = 1
    F(n) = F(n-1) + F(n-2), n > 1
     */
    public int fib(int n) {
        if (n == 0) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fibOpt(int n) {
        if (n == 0) return n;
        int a, b = 1, c = 1;
        for (int i = 0; i < n - 2; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
