package com.rovo98.leetcode.l75.day4;

import com.rovo98.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P142LinkedListCycle2 {
    /*
    TC: O(n)
    SC: O(n)
    naive approach: using hashmap
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p = head;

        Set<ListNode> visited = new HashSet<>();
        while (p != null) {
            if (visited.contains(p)) {
                return p;
            }
            visited.add(p);
            p = p.next;
        }
        return null;
    }

    /*
    TC: O(n)
    SC: O(1)
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                s = head;
                while (s != f) {
                    s = s.next;
                    f = f.next;
                }
                return s;
            }
        }
        return null;
    }
}
