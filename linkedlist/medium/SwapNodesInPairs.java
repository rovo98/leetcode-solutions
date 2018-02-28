package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 38.9%
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1 -> 2 -> 3 -> 4, you should return the list as 2 -> 1 -> 4 ->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list,
 * only nodes itself can be changed.
 *
 * @author rovo98
 * Date: 09/2/2018
 */
public class SwapNodesInPairs {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // This algorithm's time complexity is O(n). like OddEvenLinkedList before.
    public ListNode swapPairs(ListNode head) {
        /*
         Divide list into two lists. one contains all odd nodes, and one contains all
         even nodes.
         finally, combine them up.
         */
        ListNode firstList = new ListNode(0);
        ListNode secondList = new ListNode(0);
        ListNode pNode = head;
        ListNode fNode = firstList;
        ListNode sNode = secondList;
        int count = 0;
        while (pNode.next != null) {
            pNode = pNode.next;
            count++;
            if (count % 2 == 0) {
                sNode.next = pNode;
                sNode = sNode.next;
            } else {
                fNode.next = pNode;
                fNode = fNode.next;
            }
        }
        fNode.next = null;
        sNode.next = null;
//        firstList.printList();
//        secondList.printList();
        ListNode result = new ListNode(0);
        ListNode rNode = result;
        firstList = firstList.next;
        secondList = secondList.next;
        while (firstList != null && secondList != null) {
            // insert the node from list1.
            rNode.next = secondList;
            secondList = secondList.next;
            rNode = rNode.next;
            // insert the node from list2.
            rNode.next = firstList;
            firstList = firstList.next;
            rNode = rNode.next;
        }
        while (firstList != null) { // only the firstList will have nodes left.
            rNode.next = firstList;
            firstList = firstList.next;
            rNode = rNode.next;
        }
        return result;
    }
    // Solution two: ^
    // This method's time complexity is O(n).
    public ListNode swapPairsVersionTwo(ListNode head) {
        /*
        reverse operation in linked list:
        example: p1 -> p2 -> p3 -> p4, and reverse p2 and p3.
        node = p2.next;
        p2.next = p3.next;
        p1.next = p3;
        p3.next = p2;

        And the key point to this problem is the start node of
        each reversing operation.
         */
        ListNode preNode = head;
        ListNode rNode = preNode.next;
        while (rNode != null) {
            ListNode node = rNode.next;
            rNode.next = node.next;
            preNode.next = node;
            node.next = rNode;

            // move forward to next reversing operation.
            preNode = rNode;
            rNode = rNode.next;
        }
        return head;
    }
    // Derive the program to test the method above.
    public static void main(String[] args) {
        SwapNodesInPairs snip = new SwapNodesInPairs();
        // test list : 1->2->3->4->5->NULL.
        ListNode testList = new ListNode(0);
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(4));
        testList.addNodeTail(new ListNode(5));
        // test list : 1->2->3->4->NULL.
        ListNode testList2 = new ListNode(0);
        for (int i = 1; i < 5; i++) {
            testList2.addNodeTail(new ListNode(i));
        }
        System.out.println("The input list1 is the following:");
        testList.printList();
        testList = snip.swapPairs(testList);
        System.out.println("The output is the following:");
        testList.printList();
        System.out.println("The input list2 is the following:");
        testList2.printList();
        testList2 = snip.swapPairs(testList2);
        System.out.println("And the output the following:");
        testList2.printList();
    }
}
