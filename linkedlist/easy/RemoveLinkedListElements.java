package LinkedList.Easy;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 33.1%
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example :
 * Given: 1->2->6->3->4->5->6, val = 6
 * Return : 1->2->3->4->5
 *
 * @author rovo98
 * Date: 02/2/2018
 */
public class RemoveLinkedListElements {
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode pNode = head;
        while (pNode.next != null) {
            if (pNode.next.val == val) {
                pNode.next = pNode.next.next;
                continue;
            }
            pNode = pNode.next;
        }
        return head;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        RemoveLinkedListElements rle = new RemoveLinkedListElements();
        ListNode testList = new ListNode(-1);
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(6));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(4));
        testList.addNodeTail(new ListNode(5));
        testList.addNodeTail(new ListNode(6));
        System.out.println("The input single-linked-list is the following:");
        testList.printList();
        testList = rle.removeElements(testList, 6);
        System.out.println("After calling the function, it becomes:");
        testList.printList();
    }
}
