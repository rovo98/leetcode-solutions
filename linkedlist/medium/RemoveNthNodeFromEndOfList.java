package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem : Acceptance: 34.2%
 *
 * Given a linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note :
 *
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * @author rovo98
 * Date: 09/2/2018
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        use two pointers (slow-fast pointers) to locate the middle node and count a half
        of nodes(hLen). Then the hLen - 2-th from the middle node is the node we want to deleted.
         */
        ListNode sNode = head.next;
        ListNode fNode = head.next;
        int count = 1;
        while (fNode.next != null && fNode.next.next != null) {
            sNode = sNode.next;
            count++;
            fNode = fNode.next.next;
        }
        // get the length of list.
        int hLen = count;
        if (fNode.next != null) {
            hLen++;
            count *= 2;
        } else {
            count = count * 2 - 1;
        }
        if (hLen - n > 0) {
            for (int i = 1; i < hLen - n; i++) {
                sNode = sNode.next;
            }
            // delete the node.
            sNode.next = sNode.next.next;
        } else {
            ListNode hNode = head;
            for (int i = 0; i < count - n; i++) {
                hNode = hNode.next;
            }
            // delete the node.
            hNode.next = hNode.next.next;
        }
        return head;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList rnfeol = new RemoveNthNodeFromEndOfList();
        // test list : 1->2->3->4->5->NULL.
        ListNode testList = new ListNode(0);
        for (int i = 1; i < 6; i++) {
            testList.addNodeTail(new ListNode(i));
        }
        System.out.println("The input list is the following:");
        testList.printList();
        int n = 3;
        testList = rnfeol.removeNthFromEnd(testList, n);
        System.out.println("After delete the "+n+"th node from end of list:");
        testList.printList();
    }
}
