package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 33.6%
 *
 * Sort a linked list using insertion sort
 *
 * @author rovo98
 * Date: 02/2/2018
 *
 */
public class InsertionSortList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // This algorithm's time complexity is O(n^2).
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Divide list nodes into two parts. Considering one as unsorted list
        // , and one is considered as sorted list.
        // Iterate all the nodes in unsorted list, then insert them into sorted list
        // one by one with ascending order.
        ListNode unSorted = head.next.next;
        ListNode sorted = head;
        ListNode remain;
        ListNode qNode;
        // Initial the sorted list contained only the first node.
        sorted.next.next = null;

        while (unSorted != null) {
            remain = unSorted.next;
            qNode = sorted;

            // To find the right position for newNode to insert into.
            while (qNode.next != null && unSorted.val > qNode.next.val) {
                qNode = qNode.next;
            }
            // insert the node into the right position.
            unSorted.next = qNode.next;
            qNode.next = unSorted;

            // refresh the unSorted list.
            unSorted = remain;
        }
        return sorted;
    }

    // Driver the program to test the method above.

    public static void main(String[] args) {
        InsertionSortList isl = new InsertionSortList();
        ListNode testList = new ListNode(-1);
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(4));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(7));
        testList.addNodeTail(new ListNode(6));
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(5));

        System.out.println("The input list is the following:");
        testList.printList();
        testList = isl.insertionSortList(testList);
        System.out.println("After calling the function, it becomes:");
        testList.printList();
    }
}
