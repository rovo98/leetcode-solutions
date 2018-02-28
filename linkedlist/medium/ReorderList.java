package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 26.4%
 *
 * Given a singly linked list L : L0 -> L1 -> ... -> Ln-1 -> Ln,
 * reorder it to : L0 -> Ln -> L1 -> Ln-1 -> L2 -> ...
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example:
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * @author rovo98
 * Date: 09/2/2018
 */
public class ReorderList {
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
    public void reorderList(ListNode head) {
        /*
        use two pointers (slow-fast pointers) to locate the middle node of
        the list.
        And then divide the list into two parts. reversing the second part and
        combining them to one list.
        example : 1->2->3->4->NULL.
        p1: 1->2->NULL. p2: 3->4->NULL. p2': 4->3->NULL.

        combination:
        cList: 1->4->2->3->NULL.
         */
        // locate the middle node of list and then divide list into two parts.
        ListNode sNode = head.next;
        ListNode fNode = head.next;
        while (fNode.next != null && fNode.next.next != null) {
            sNode = sNode.next;
            fNode = fNode.next.next;
        }
        ListNode hList = head;
        ListNode rList = new ListNode(0);
        rList.next = sNode.next;
        sNode.next = null;

        // reversing the second part.
//        rList.printList();
        ListNode rNode = rList.next;
        while (rNode.next != null) {
            ListNode node = rNode.next;
            rNode.next = node.next;
            node.next = rList.next;
            rList.next = node;
        }
//        rList.printList();
        // combination.
        rNode = rList; // the length of rList will never greater than hList's.
        while (rNode.next != null) {
             // remove node from reversedList (rList).
             ListNode rnNode = rNode.next;
             rNode.next = rNode.next.next;
             hList = hList.next;

             // insert the node into the original list.
             rnNode.next = hList.next;
             hList.next = rnNode;
             hList = hList.next;
        }
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
        // test list : 1->2->3->4->5->NULL.
        ListNode testList = new ListNode(0);
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(4));
        testList.addNodeTail(new ListNode(5));

        System.out.println("The input list is the following:");
        testList.printList();
        rl.reorderList(testList);
        System.out.println("After calling the function, it becomes:");
        testList.printList();
    }
}
