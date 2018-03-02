package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 24.4%
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 * @author rovo98
 * Date: 10/2/2018
 */
public class RotateList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // This algorithm's time complexity is o(n).
    public ListNode rotateRight(ListNode head, int k) {
        /*
        Get the length of list firstly.
        Then to find the node which starts reversing.
        example: 1->2->3->4->5->NULL.
        length we got is 5.
        rNode is 4.
        two parts:
        1->2->3->NULL.      4->5->NULL.
        combine them as the following:
        4->5->1->2->3->NULL.
         */
        // Get the length of the list.
        ListNode cNode = head;
        int length = 0;
        while (cNode.next != null) {
            cNode = cNode.next;
            length++;
        }
        // Find the node which starts to reverse and divide list into two parts.
        ListNode pNode = head;
        int count = 0;
        while (true) {
            count++;
            if ((count + k - length) == 1) {
                break;
            }
            pNode = pNode.next;
        }

        ListNode rNode = pNode.next;
        pNode.next = null;
        // Exchange this two parts.
        pNode = head.next;
        head.next = rNode;
        while (rNode.next != null) {
            rNode = rNode.next;
        }
        rNode.next = pNode;
        return head;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        RotateList rl = new RotateList();
        // test list : 1->2->3->4->5->NULL.
        ListNode testList = new ListNode(0);
        for (int i = 1; i < 6; i++) {
            testList.addNodeTail(new ListNode(i));
        }
        System.out.println("The input list is the following:");
        testList.printList();
        ListNode result = rl.rotateRight(testList, 3);
        System.out.println("And the output is the following:");
        result.printList();
    }
}
