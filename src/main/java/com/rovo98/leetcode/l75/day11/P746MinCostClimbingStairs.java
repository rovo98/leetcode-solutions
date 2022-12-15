package com.rovo98.leetcode.l75.day11;

/** https://leetcode.com/problems/min-cost-climbing-stairs */
public class P746MinCostClimbingStairs {
    /*
    TC: O(n)
    SC: O(n)

    C(0) = C(1) = 0
    C(n) = min{C(n-2) + cost[n-1], C(n-1) + cost[i]}, n >= 3
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 1], dp[i - 1] + cost[i]);
        }
        return dp[n-1];
    }
}
