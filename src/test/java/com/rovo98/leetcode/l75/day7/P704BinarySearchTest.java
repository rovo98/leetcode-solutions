package com.rovo98.leetcode.l75.day7;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P704BinarySearchTest implements SolutionProviderFactory<P704BinarySearch> {
    @Override
    public P704BinarySearch createSolutionProvider() {
        return new P704BinarySearch();
    }

    @Test
    public void testcase1() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int expected = 4;
        assertEquals(expected, createSolutionProvider().search(nums, target));
    }

    @Test
    public void testcase2() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int expected = -1;
        assertEquals(expected, createSolutionProvider().search(nums, target));
    }

    @Test
    public void testcase3() {
        int[] nums = {5};
        int target = 5;
        int expected = 0;
        assertEquals(expected, createSolutionProvider().search(nums, target));
    }
}
