package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 31.2%
 *
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
 *
 *
 */
public class ReverseLinkedListTwo {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one : &
    // This algorithm's time complexity is O(n).
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /*
        reversing nodes in [m,n] in linked list :
        ex: p1 -> p2 -> p3 -> p4 reverse p2 and p3
        node = p2.next;
        p2.next = p3.next;
        p3.next = p2;
        p1.next = p3;
        key point : find the p1.
         */
        if (head.next == null) {
            return head;
        }
        ListNode preNode = head;
        // find the preNode of the node that starts reversing operation.
        int count = 1;
        while (count < m && preNode.next != null) {
            preNode = preNode.next;
            count++;
        }
        // because the m and n are always valid, rNode will never be null.
        ListNode rNode = preNode.next;  // the node starts reverse.
        for (int i = m; i < n; i++) {
            ListNode node = rNode.next;
            rNode.next = node.next;
            node.next = preNode.next;
            preNode.next = node;
        }
        return head;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        ReverseLinkedListTwo rlt = new ReverseLinkedListTwo();
        ListNode testList = new ListNode(0);
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(4));
        testList.addNodeTail(new ListNode(5));

        System.out.println("The input list is the following:");
        testList.printList();
        testList = rlt.reverseBetween(testList, 2, 4);
        System.out.println("And the output is the following:");
        testList.printList();
    }
}
