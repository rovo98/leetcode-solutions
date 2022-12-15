package com.rovo98.leetcode.l75.day11;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P746MinCostClimbingStairsTest
        implements SolutionProviderFactory<P746MinCostClimbingStairs> {
    @Override
    public P746MinCostClimbingStairs createSolutionProvider() {
        return new P746MinCostClimbingStairs();
    }

    @Test
    public void testcase1() {
        int[] cost = {10, 15, 20};
        int expected = 15;
        assertEquals(expected, createSolutionProvider().minCostClimbingStairs(cost));
    }

    @Test
    public void testcase2() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int expected = 6;
        assertEquals(expected, createSolutionProvider().minCostClimbingStairs(cost));
    }
}
