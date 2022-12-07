package com.rovo98.leetcode.l75.day3;

import com.rovo98.leetcode.SolutionProviderFactory;
import com.rovo98.leetcode.common.ListNode;
import org.junit.Test;

import static com.rovo98.leetcode.Utils.isListsEq;
import static org.junit.Assert.assertTrue;

public class P21MergeTwoSortedListsTest implements SolutionProviderFactory<P21MergeTwoSortedLists> {

    @Override
    public P21MergeTwoSortedLists createSolutionProvider() {
        return new P21MergeTwoSortedLists();
    }


    @Test
    public void testcase1() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode expected =
                new ListNode(
                        1,
                        new ListNode(
                                1,
                                new ListNode(
                                        2, new ListNode(3, new ListNode(4, new ListNode(4))))));
        assertTrue(isListsEq(expected, createSolutionProvider().mergeTwoLists(list1, list2)));
    }

    @Test
    public void testcase2() {
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode expected = null;
        assertTrue(isListsEq(expected, createSolutionProvider().mergeTwoLists(list1, list2)));
    }

    @Test
    public void testcase3() {
        ListNode list1 = null;
        ListNode list2 = new ListNode(0);
        ListNode expected = new ListNode(0);
        assertTrue(isListsEq(expected, createSolutionProvider().mergeTwoLists(list1, list2)));
    }
}
