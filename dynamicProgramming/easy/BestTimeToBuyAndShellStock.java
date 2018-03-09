package DynamicProgramming.Easy;

/**
 * Problem : Acceptance: 42.4%
 * Say you have an array for which the i^th element is the price of a given stock
 * on day i.
 * If you were only permitted to complete at most one transaction(ie, buy one and sell
 * one share of the stock), design an algorithm to find the maximum profit.
 *
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 *
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger
 * than buying price)
 *
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 *
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author rovo98
 * Date: 7/3/2018
 */
public class BestTimeToBuyAndSellStock {
    // solution one: ^ brute force.
    /*
    Complexity Analysis:
        Time complexity: O(n^2).
        Space complexity: O(1).
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        if (prices.length <= 1) {
            return maxProfit;
        }

        for (int i = 0;  i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i];
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
        }
        return maxProfit;
    }

    // solution two : ^& dynamic programming.

    /*
     Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(1).
     */
    public int maxProfitVersionTwo(int[] prices) {

        if (prices.length <= 1)
            return 0;

        int minShell = prices[0];               // record the min profit in array.
        int maxProfit = prices[1] - prices[0];  // record the max profit we can get.

        for (int i = 2; i < prices.length; i++) {
            minShell = Math.min(minShell, prices[i-1]);
            maxProfit = Math.max(maxProfit, prices[i] - minShell);
        }

        if (maxProfit < 0) {
            return 0;
        }
        return maxProfit;
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bttbass = new BestTimeToBuyAndSellStock();
        int[] testStocks = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println("The input test stocks are the following:");
        for (int stock : testStocks)
            System.out.print(stock + " ");
        System.out.println();
        int result = bttbass.maxProfit(testStocks);
        int result1 = bttbass.maxProfitVersionTwo(testStocks);
        System.out.println("The max profit is " + result + ".");
        System.out.println("The max profit(using dp method) is " + result1 + ".");
    }
}
