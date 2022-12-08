package com.rovo98.leetcode.l75.day4;

import com.rovo98.leetcode.SolutionProviderFactory;
import com.rovo98.leetcode.common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P876MiddleOfTheLinkedListTest
        implements SolutionProviderFactory<P876MiddleOfTheLinkedList> {
    @Override
    public P876MiddleOfTheLinkedList createSolutionProvider() {
        return new P876MiddleOfTheLinkedList();
    }

    @Test
    public void testcase1() {
        ListNode list =
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int expected = 3;
        assertEquals(expected, createSolutionProvider().middleNode(list).val);
    }

    @Test
    public void testcase2() {
        ListNode list =
                new ListNode(
                        1,
                        new ListNode(
                                2,
                                new ListNode(
                                        3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        int expected = 4;
        assertEquals(expected, createSolutionProvider().middleNode(list).val);
    }
}
