package LinkedList.Medium;

import LinkedList.ListNode;

import java.util.Random;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * @author rovo98
 * Date: 10/2/2018
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
    // merge two lists.
    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode mergedList = new ListNode(0);
        ListNode pNode = mergedList;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pNode.next = l2;
                l2 = l2.next;
            } else {
                pNode.next = l1;
                l1 = l1.next;
            }
            pNode = pNode.next;
        }
        if (l1 != null) {
            pNode.next = l1;
        }
        if (l2 != null) {
            pNode.next = l2;
        }
        return mergedList.next;
    }
    // Solution one: &
    // This algorithm's time complexity is O(n log n).
    public ListNode sortList(ListNode head) {
        /*
        use divide and conquer. MergeSort linked list.
        use slow-fast pointers to divide list into two parts and do it recursively.
        finally, merges each two parts.
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sNode = head;
        ListNode fNode = head;
        while (fNode.next != null && fNode.next.next != null) {
            fNode = fNode.next.next;
            sNode = sNode.next;
        }
        fNode = sNode.next;
        sNode.next = null;
        ListNode l1 = sortList(head); // first part.
        ListNode l2 = sortList(fNode);// second part.

        return mergeList(l1, l2);
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        SortList sl = new SortList();
        // test list.
        ListNode testList = new ListNode(0);
        for (int i = 0; i < 10; i++) {
            testList.addNodeTail(new ListNode(new Random().nextInt(100)));
        }
        System.out.println("The input list is the following:");
        testList.printList();
        testList.next = sl.sortList(testList.next);
        System.out.println("\nAfter calling the function, the list becomes:");
        testList.printList();

    }
}
