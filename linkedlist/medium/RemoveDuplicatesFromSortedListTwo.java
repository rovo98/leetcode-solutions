package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 29.8%
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 * numbers from the original list.
 *
 * For example:
 * Given 1->2->3->3->4->4->5, return 1->2->5
 * Given 1->1->1->2->3, return 2->3
 *
 * @author rovo98
 * Date: 09/2/2018
 */
public class RemoveDuplicatesFromSortedListTwo {
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode pNode = head.next;
        ListNode preNode = head;
        while (pNode.next != null) {
            if (pNode.val == pNode.next.val) { // If meet the duplicates.
                int val = pNode.val;
                ListNode nNode = pNode.next;
                while (nNode.val == val) {         // iterate through the duplicates occur before.
                    nNode = nNode.next;
                }
                // remove the duplicates.
                preNode.next = nNode;
                pNode = nNode;
            } else {                          // If doesn't meet the duplicate, move forward.
                preNode = pNode;
                pNode = pNode.next;
            }
        }
       return head;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListTwo rdfslt = new RemoveDuplicatesFromSortedListTwo();
        // test list 1 : 1->2->3->3->4->4->5->NULL.
        ListNode testList1 = new ListNode(0);
        testList1.addNodeTail(new ListNode(1));
        testList1.addNodeTail(new ListNode(2));
        testList1.addNodeTail(new ListNode(3));
        testList1.addNodeTail(new ListNode(3));
        testList1.addNodeTail(new ListNode(4));
        testList1.addNodeTail(new ListNode(4));
        testList1.addNodeTail(new ListNode(5));
        // test list 2 : 1->1->1->2->3->NULL.
        ListNode testList2 = new ListNode(0);
        testList2.addNodeTail(new ListNode(1));
        testList2.addNodeTail(new ListNode(1));
        testList2.addNodeTail(new ListNode(1));
        testList2.addNodeTail(new ListNode(2));
        testList2.addNodeTail(new ListNode(3));

        System.out.println("The test list 1 is the following:");
        testList1.printList();
        ListNode result1 = rdfslt.deleteDuplicates(testList1);
        System.out.println("And the output is the following:");
        result1.printList();
        System.out.println("The test list 2 is the following:");
        testList2.printList();
        ListNode result2 = rdfslt.deleteDuplicates(testList2);
        System.out.println("And the output is the following:");
        result2.printList();
    }
}
