package com.rovo98.leetcode.l75.day5;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P121BestTimeToBuyAndSellStockTest implements SolutionProviderFactory<P121BestTimeToBuyAndSellStock> {
    @Override
    public P121BestTimeToBuyAndSellStock createSolutionProvider() {
        return new P121BestTimeToBuyAndSellStock();
    }

    @Test
    public void testcase1() {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        assertEquals(expected, createSolutionProvider().maxProfit(arr));
    }

    @Test
    public void testcase2() {
        int[] arr = {7, 6, 4, 3, 1};
        int expected = 0;
        assertEquals(expected, createSolutionProvider().maxProfit(arr));
    }

    @Test
    public void testcase3() {
        int[] arr = {1, 2};
        int expected = 1;
        assertEquals(expected, createSolutionProvider().maxProfit(arr));
    }

}
