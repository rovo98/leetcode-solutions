package com.rovo98.leetcode;

import com.rovo98.leetcode.common.ListNode;

public final class Utils {

    public static boolean isListsEq(ListNode l1, ListNode l2) {
        if (l1 == null) return l2 == null;

        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
