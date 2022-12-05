package com.rovo98.leetcode.l75.day1;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class P1480RunningSumOf1dArrayTest
        implements SolutionProviderFactory<P1480RunningSumOf1dArray> {
    @Override
    public P1480RunningSumOf1dArray createSolutionProvider() {
        return new P1480RunningSumOf1dArray();
    }

    @Test
    public void testcase1() {
        int[] arr = {1, 2, 3, 4};
        int[] expected = {1, 3, 6, 10};

        int[] result = createSolutionProvider().runningSum(arr);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testcase2() {
        int[] arr = {1, 1, 1, 1, 1};
        int[] expected = {1, 2, 3, 4, 5};

        int[] result = createSolutionProvider().runningSum(arr);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testcase3() {
        int[] arr = {3, 1, 2, 10, 1};
        int[] expected = {3, 4, 6, 16, 17};

        int[] result = createSolutionProvider().runningSum(arr);
        assertArrayEquals(expected, result);
    }
}
