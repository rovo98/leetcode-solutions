package com.rovo98.leetcode.l75.day4;

import com.rovo98.leetcode.SolutionProviderFactory;
import com.rovo98.leetcode.common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class P142LinkedListCycle2Test implements SolutionProviderFactory<P142LinkedListCycle2> {
    @Override
    public P142LinkedListCycle2 createSolutionProvider() {
        return new P142LinkedListCycle2();
    }

    @Test
    public void testcase1() {
        ListNode n = new ListNode(2, new ListNode(0, new ListNode(-4)));
        ListNode list = new ListNode(1, n);
        ListNode p = n;
        while (p.next != null) {
            p = p.next;
        }
        p.next = n;

        assertSame(n, createSolutionProvider().detectCycle(list));
        assertSame(n, createSolutionProvider().detectCycle2(list));
    }

    @Test
    public void testcase2() {
        ListNode n = new ListNode(1, new ListNode(2));
        ListNode list = n;
        ListNode p = n;
        while (p.next != null) {
            p = p.next;
        }
        p.next = n;

        assertSame(n, createSolutionProvider().detectCycle(list));
        assertSame(n, createSolutionProvider().detectCycle2(list));
    }

    @Test
    public void testcase3() {
        ListNode list = new ListNode(1);
        assertNull(createSolutionProvider().detectCycle(list));
        assertNull(createSolutionProvider().detectCycle2(list));
    }
}
