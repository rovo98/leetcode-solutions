package com.rovo98.leetcode.l75.day2;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class P205IsomorphicStringsTest implements SolutionProviderFactory<P205IsomorphicStrings> {
    @Override
    public P205IsomorphicStrings createSolutionProvider() {
        return new P205IsomorphicStrings();
    }

    @Test
    public void testcase1() {
        String s = "egg";
        String t = "add";
        assertTrue(createSolutionProvider().isIsomorphic(s, t));
    }

    @Test
    public void testcase2() {
        String s = "foo";
        String t = "bar";
        assertFalse(createSolutionProvider().isIsomorphic(s, t));
    }

    @Test
    public void testcase3() {
        String s = "paper";
        String t = "title";
        assertTrue(createSolutionProvider().isIsomorphic(s, t));
    }

    @Test
    public void testcase4() {
        String s = "badc";
        String t = "baba";
        assertFalse(createSolutionProvider().isIsomorphic(s, t));
    }

    @Test
    public void testcase5() {
        String s = "13";
        String t = "42";
        assertTrue(createSolutionProvider().isIsomorphic(s, t));
    }
}
