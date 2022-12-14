package com.rovo98.leetcode.l75.day10;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P509FibonacciNumberTest implements SolutionProviderFactory<P509FibonacciNumber> {

    @Override
    public P509FibonacciNumber createSolutionProvider() {
        return new P509FibonacciNumber();
    }

    @Test
    public void testcase1() {
        int n = 2;
        int expected = 1;
        assertEquals(expected, createSolutionProvider().fib(n));
        assertEquals(expected, createSolutionProvider().fibOpt(n));
    }

    @Test
    public void testcase2() {
        int n = 3;
        int expected = 2;
        assertEquals(expected, createSolutionProvider().fib(n));
        assertEquals(expected, createSolutionProvider().fibOpt(n));
    }

    @Test
    public void testcase3() {
        int n = 4;
        int expected = 3;
        assertEquals(expected, createSolutionProvider().fib(n));
        assertEquals(expected, createSolutionProvider().fibOpt(n));
    }
}
