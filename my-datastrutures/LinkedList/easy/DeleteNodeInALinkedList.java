package LinkedList.Easy;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 47.2%
 * Write a function to delete a node (except the tail) in a singly linked list, given only
 * access to that node.
 *
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class DeleteNodeInALinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution: ^
    // This algorithm's time complexity is O(n).
    public void deleteNode(ListNode list, ListNode node) {
        ListNode pNode = list;
        while (pNode.next != null) {
            if (pNode.next.val == node.val) {
                pNode.next = pNode.next.next;
                return;
            }
            pNode = pNode.next;
        }
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        DeleteNodeInALinkedList dnial = new DeleteNodeInALinkedList();
        ListNode testList = new ListNode(-1);  // Initial the head node of the single-linked-list.
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(4));
        System.out.println("The input single-linked-list is the following:");
        testList.printList();
        dnial.deleteNode(testList, new ListNode(3));
        System.out.println("After deleting the node 3, it is now the following:");
        testList.printList();
    }
}
