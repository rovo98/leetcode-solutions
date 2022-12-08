package com.rovo98.leetcode.l75.day4;

import com.rovo98.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list
 */
public class P876MiddleOfTheLinkedList {
    /*
    TC: O(n)
    SC: O(1)
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        return s;
    }
}
