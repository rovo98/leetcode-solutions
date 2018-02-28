package LinkedList.Easy;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 46.5%
 * Reverse a singly linked list.
 *
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author rovo98
 * Date: 02/2/2018
 */
public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // This algorithm's time complexity is O(n) and its space complexity is also O(1).
    public ListNode reverseList(ListNode head) {
        // Initial the head node of the reversed list.
        // And the value of it represents the length of the list.
        ListNode reversedList = new ListNode(0);
        while (head.next != null) {
            // remove the node from the original list.
            ListNode rNode = head.next;
            head.next = head.next.next;

            // insert the node into the head of the list.
            rNode.next = reversedList.next;
            reversedList.next = rNode;
            // reset the length of the reversedList.
            reversedList.val += 1;
        }
        return reversedList;
    }
    // Solution two: ^&
    // This algorithm's time complexity is O(n) and its memory complexity is  O(1).
    public ListNode reverseListVersionTwo(ListNode head) {
        ListNode rNode = head.next;
        while (rNode.next != null) {
            ListNode node = rNode.next;
            rNode.next = node.next;
            node.next = head.next;
            head.next = node;
        }
        return head;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        // test list 1 : 1->2->3->4->5->NULL.
        ListNode testList = new ListNode(-1);
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(4));
        testList.addNodeTail(new ListNode(5));
        ListNode testList2 = new ListNode(0);
        for (int i = 1; i < 5; i++) {
            testList2.addNodeTail(new ListNode(i));
        }
        System.out.println("The input linked list1 is the following:");
        testList.printList();
        ListNode reversedList = rl.reverseList(testList);
        System.out.println("The reversed list of it is the following and its length is "+reversedList.val+".:");
        reversedList.printList();
        System.out.println("The input linked list 2 is the following:");
        testList2.printList();
        ListNode reversedList2 = rl.reverseListVersionTwo(testList2);
        System.out.println("And the output is the following:");
        reversedList2.printList();
    }
}
