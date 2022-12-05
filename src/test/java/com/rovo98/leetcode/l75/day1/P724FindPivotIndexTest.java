package com.rovo98.leetcode.l75.day1;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P724FindPivotIndexTest implements SolutionProviderFactory<P724FindPivotIndex> {
    @Override
    public P724FindPivotIndex createSolutionProvider() {
        return new P724FindPivotIndex();
    }

    @Test
    public void testcase1() {
        int[] arr = {1, 7, 3, 6, 5, 6};
        int expected = 3;
        int result = createSolutionProvider().pivotIndex(arr);
        assertEquals(expected, result);
    }

    @Test
    public void testcase2() {
        int[] arr = {1, 2, 3};
        int expected = -1;
        int result = createSolutionProvider().pivotIndex(arr);
        assertEquals(expected, result);
    }

    @Test
    public void testcase3() {
        int[] arr = {2, 1, -1};
        int expected = 0;
        int result = createSolutionProvider().pivotIndex(arr);
        assertEquals(expected, result);
    }
}
