package com.rovo98.leetcode.slidingwindow;

import com.rovo98.leetcode.slidingwidow.P1343_NumOfSubArraysOfSizeKAndAvgGreaterThanOrEq2Threshold;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P1343NumOfSubArraysOfSizeKAndAvgGreaterThanOrEq2ThresholdTest {

    private static P1343_NumOfSubArraysOfSizeKAndAvgGreaterThanOrEq2Threshold solutionProvider;

    @BeforeClass
    public static void init() {
        solutionProvider = new P1343_NumOfSubArraysOfSizeKAndAvgGreaterThanOrEq2Threshold();
    }

    @Test
    public void testcase1() {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        int expected = 3;

        int result = solutionProvider.numOfSubarrays(arr, k, threshold);
        assertEquals(expected, result);
    }


    @Test
    public void testcase2() {
        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k = 3;
        int threshold = 5;
        int expected = 6;

        int result = solutionProvider.numOfSubarrays(arr, k, threshold);
        assertEquals(expected, result);
    }
}