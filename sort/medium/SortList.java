package Sort.Medium;

import LinkedList.ListNode;

import java.util.Random;

/**
 * Problem: Acceptance: 29.5%
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 *  @author rovo98
 *  Date: 13/2/2018
 *  Review.
 */
public class SortList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    // Solution one: ^
    /*
    Complexity Analysis:
        Time complexity: O(n log n).
        Space complexity: O(1).
     */
    public ListNode sortList(ListNode head) {
        /*
        use divide and conquer.
         */
        if (head == null || head.next == null) {
            return head;
        }
        // use slow-fast pointers to divide list into two parts.
        ListNode sNode = head;
        ListNode fNode = head;
        while (fNode.next != null && fNode.next.next != null) {
            fNode = fNode.next.next;
            sNode = sNode.next;
        }
        fNode = sNode.next;
        sNode.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(fNode);

        return merge(l1, l2);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode mergedList = new ListNode(0);
        ListNode mNode = mergedList;
        // merge two lists.
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                mNode.next = l2;
                l2 = l2.next;
            } else {
                mNode.next = l1;
                l1 = l1.next;
            }
            mNode = mNode.next;
        }
        // If l1 has nodes left.
        if (l1 != null) {
            mNode.next = l1;
        }
        // If l2 has nodes left.
        if (l2 != null) {
            mNode.next = l2;
        }
        return mergedList.next;
    }
    // Driver the program to test the method above.
    public static void main(String[] args) {
        SortList sl = new SortList();
        // test list randomly initialized with integer in range of [0, 99]
        ListNode testList = new ListNode(0);
        int testNum = 10;
        Random r = new Random();
        for (int i = 0; i < testNum; i++) {
            testList.addNodeTail(new ListNode(r.nextInt(100)));
        }
        System.out.println("The input test list is the following:");
        testList.printList();
        testList.next = sl.sortList(testList.next);
        System.out.println("After calling the sortList function, it becomes:");
        testList.printList();
    }
}
