package com.rovo98.leetcode.l75.day3;

import com.rovo98.leetcode.SolutionProviderFactory;
import com.rovo98.leetcode.common.ListNode;
import org.junit.Test;

import static com.rovo98.leetcode.Utils.isListsEq;
import static org.junit.Assert.assertTrue;

public class P206ReverseLinkedListTest implements SolutionProviderFactory<P206ReverseLinkedList> {
    @Override
    public P206ReverseLinkedList createSolutionProvider() {
        return new P206ReverseLinkedList();
    }

    @Test
    public void testcase1() {
        ListNode list =
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expected =
                new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        assertTrue(isListsEq(expected, createSolutionProvider().reverseList(list)));
    }

    @Test
    public void testcase2() {
        ListNode list = new ListNode(1, new ListNode(2));
        ListNode expected = new ListNode(2, new ListNode(1));
        assertTrue(isListsEq(expected, createSolutionProvider().reverseList(list)));
    }

    @Test
    public void testcase3() {
        ListNode list = null;
        ListNode expected = null;
        assertTrue(isListsEq(expected, createSolutionProvider().reverseList(list)));
    }
}
