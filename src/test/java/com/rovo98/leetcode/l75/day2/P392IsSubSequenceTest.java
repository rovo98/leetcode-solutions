package com.rovo98.leetcode.l75.day2;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class P392IsSubSequenceTest implements SolutionProviderFactory<P392IsSubSequence> {
    @Override
    public P392IsSubSequence createSolutionProvider() {
        return new P392IsSubSequence();
    }

    @Test
    public void testcase1() {
        String s = "axc";
        String t = "ahbgdc";
        assertFalse(createSolutionProvider().isSubSequence(s, t));
    }

    @Test
    public void testcase2() {
        String s = "abc";
        String t = "ahbgdc";
        assertTrue(createSolutionProvider().isSubSequence(s, t));
    }

    @Test
    public void testcase3() {
        String s = "aaaaaa";
        String t = "bbaaaa";
        assertFalse(createSolutionProvider().isSubSequence(s, t));
    }

}
