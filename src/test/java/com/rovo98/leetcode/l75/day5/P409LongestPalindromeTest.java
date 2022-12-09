package com.rovo98.leetcode.l75.day5;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P409LongestPalindromeTest implements SolutionProviderFactory<P409LongestPalindrome> {
    @Override
    public P409LongestPalindrome createSolutionProvider() {
        return new P409LongestPalindrome();
    }

    @Test
    public void testcase1() {
        String s = "abccccdd";
        int expected = 7;
        assertEquals(expected, createSolutionProvider().longestPalindrome(s));
    }

    @Test
    public void testcase2() {
        String s = "a";
        int expected = 1;
        assertEquals(expected, createSolutionProvider().longestPalindrome(s));
    }

    @Test
    public void testcase3() {
        String s = "ccc";
        int expected = 3;
        assertEquals(expected, createSolutionProvider().longestPalindrome(s));
    }
}
