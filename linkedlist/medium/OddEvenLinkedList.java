package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 44.4%
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please
 * note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and
 * O(nodes) time complexity.
 *
 * Example:
 * Given 1->2->3->4->5->NULL
 * return 1->3->5->2->4->NULL.
 *
 * Note :
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on...
 *
 * @author rovo98
 * Date: 04/2/2018
 */
public class OddEvenLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // This algorithm is run in O(n) time complexity and O(1) space complexity.
    public ListNode oddEvenList(ListNode head) {
        // use two list pointer to store odd nodes and even nodes separately.
        ListNode evenNodes = new ListNode(0);
        ListNode oddNodes = new ListNode(0);
        ListNode eNode = evenNodes;         // the head of evenNodes.
        ListNode oNode = oddNodes;          // the head of oddNodes.
        ListNode pNode = head;
        int count = 0;

        while (pNode.next != null) {
            pNode = pNode.next;
            count++;
            if (count % 2 == 0) { // If meet even node.
                eNode.next = pNode;
                eNode = eNode.next;
            } else {
                oNode.next = pNode;
                oNode = oNode.next;
            }
        }
        // combine them to one list.
        eNode.next = null;
        oNode.next = evenNodes.next;
        return oddNodes;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        OddEvenLinkedList oel = new OddEvenLinkedList();
        // test list : 1->2->3->4->5->NULL.
        ListNode testList = new ListNode(-1);
        for (int i=1; i<6; i++) {
            testList.addNodeTail(new ListNode(i));
        }
        System.out.println("The input list is the following:");
        testList.printList();
        testList = oel.oddEvenList(testList);
        System.out.println("The output is the following:");
        testList.printList();
    }
}
