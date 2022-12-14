package com.rovo98.leetcode.l75.day10;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P70ClimbingStairsTest implements SolutionProviderFactory<P70ClimbingStairs> {
    @Override
    public P70ClimbingStairs createSolutionProvider() {
        return new P70ClimbingStairs();
    }

    @Test
    public void testcase1() {
        int n = 2;
        int expected = 2;
        assertEquals(expected, createSolutionProvider().climbStairs(n));
        assertEquals(expected, createSolutionProvider().climbStairsOpt(n));
    }

    @Test
    public void testcase2() {
        int n = 3;
        int expected = 3;
        assertEquals(expected, createSolutionProvider().climbStairs(n));
        assertEquals(expected, createSolutionProvider().climbStairsOpt(n));
    }

    @Test
    public void testcase3() {
        int n = 10;
        int expected = 89;
        assertEquals(expected, createSolutionProvider().climbStairs(n));
        assertEquals(expected, createSolutionProvider().climbStairsOpt(n));
    }
}
