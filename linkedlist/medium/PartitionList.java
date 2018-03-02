package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 33.2%
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example:
 * Given 1->4->3->2->5->2 and x = 3.
 * return 1->2->2->4->3->5.
 *
 * @author rovo98
 * Date: 08/2/2018
 */
public class PartitionList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // This algorithm's time complexity is O(n). Like the problem OddEvenLinkedList.
    public ListNode partition(ListNode head, int x) {
        // use two pointer to store nodes less tha x and greater than or equal to x.
        /*
           input list: 1->4->3->2->5->2->NULL.
           lessList: 1->2->2->NULL.
           geList:   4->3->5->NULL.
           combine them to one list:
           1->2->2->4->3->5->NULL.
         */
        ListNode lessList = new ListNode(0);
        ListNode geList = new ListNode(0);
        ListNode lNode = lessList;
        ListNode geNode = geList;
        ListNode pNode = head;

        while (pNode.next != null) {
            pNode = pNode.next;
            if (pNode.val >= x) {
                geNode.next = pNode;
                geNode = geNode.next;
            } else {
                lNode.next = pNode;
                lNode = lNode.next;
            }
        }
        // combine them to one list.
        geNode.next = null;
        lNode.next = geList.next;
        return lessList;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
        // test list : 1->4->3->2->5->2->NULL. x = 3
        ListNode testList = new ListNode(-1);
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(4));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(5));
        testList.addNodeTail(new ListNode(2));

        System.out.println("The input list is the following:");
        testList.printList();
        ListNode resultList = pl.partition(testList, 3);
        System.out.println("The output result is the following:");
        resultList.printList();
    }
}
