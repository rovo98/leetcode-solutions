package com.rovo98.leetcode.l75.day5;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class P121BestTimeToBuyAndSellStock {
    /*
    TC: O(n)
    SC: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int len = prices.length;

        int maxProfit = 0;
        int bestBuyDay = 0;

        for (int i = 1; i < len; i++) {
            int profit = prices[i] - prices[bestBuyDay];
            if (maxProfit < profit) {
                maxProfit = profit;
            }
            if (prices[i] < prices[bestBuyDay]) {
                bestBuyDay = i;
            }
        }
        return maxProfit;
    }
}
