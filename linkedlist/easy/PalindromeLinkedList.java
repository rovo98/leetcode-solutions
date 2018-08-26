package LinkedList.Easy;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 33.3%
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up :
 * Could you do it in O(n) time and O(1) space?
 *
 * @author rovo98
 * Date: 10/2/2018
 */
public class PalindromeLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // This method's time complexity is O(n).
    public boolean isPalindrome(ListNode head) {
        /*
        use slow-fast pointers to locate the middle node of list.
        Divide the list into two parts.
        And the reverse the second part of list.
        example : 1 -> 2 -> 3 -> 2 -> 1 -> NULL.
        first part : 1->2->3->NULL.
        second part : 2->1->NULL.

        reversePart: 1->2->NULL.
        original : 1->2->3->NULL.
        Output: true
         */
        ListNode sNode = head.next;
        ListNode fNode = head.next;
        while (fNode.next != null && fNode.next.next != null) {
            sNode = sNode.next;
            fNode = fNode.next.next;
        }
        ListNode reversePart = new ListNode(0);
        reversePart.next = sNode.next;
        sNode.next = null;
        // reverses the second part of list.
        ListNode preNode = reversePart;
        ListNode rNode = preNode.next;
        while (rNode.next != null) {
            ListNode node = rNode.next;
            rNode.next = node.next;
            node.next = preNode.next;
            preNode.next = node;
        }
        // compare this two parts.
        while (head.next != null && reversePart.next != null) {
            head = head.next;
            reversePart = reversePart.next;
            if (head.val != reversePart.val) {
                return false;
            }
        }
        return true;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        PalindromeLinkedList pl = new PalindromeLinkedList();
        // test list : 1->2->3->2->1->NULL.
        ListNode testList = new ListNode(0);
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(1));

        System.out.println("The input list is the following:");
        testList.printList();
        if (pl.isPalindrome(testList)) {
            System.out.println("And it is a palindrome linked list.");
        } else {
            System.out.println("And it is not a palindrome linked list.");
        }
    }
}
