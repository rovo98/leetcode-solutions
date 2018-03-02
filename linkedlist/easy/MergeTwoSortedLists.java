package LinkedList.Easy;

import LinkedList.ListNode;

/**
 * Problem : Acceptance: 40.0%
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing
 * together the nodes of the first two lists.
 *
 * Example:
 *
 * Input : 1->2->4, 1->3->4
 * Output : 1->1->2->3->4->4
 *
 * @author rovo98
 * Date: 02/2/2018
 */
public class MergeTwoSortedLists {
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode newList = new ListNode(0);
        ListNode nNode = newList;
        while (l1 != null && l2 != null) {
          if (l1.val > l2.val) {
              System.out.println("test 1");
              nNode.next = l2;
              l2 = l2.next;
          } else {
              System.out.println("test 2");
              nNode.next = l1;
              l1 = l1.next;
          }
          nNode = nNode.next;
        }
        // If the l1 has nodes left.
        if (l1 != null) {
            nNode.next = l1;
        }
        // or if the l2 has nodes left.
        if (l2 != null) {
            nNode.next = l2;
        }
        return newList;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        // test list 1 : 1->2->4->NULL.
        ListNode testList1 = new ListNode(-1);
        // test list 2 : 1->3->4->6->NULL.
        ListNode testList2 = new ListNode(-1);
        testList1.addNodeTail(new ListNode(1));
        testList1.addNodeTail(new ListNode(2));
        testList1.addNodeTail(new ListNode(4));
        testList2.addNodeTail(new ListNode(1));
        testList2.addNodeTail(new ListNode(3));
        testList2.addNodeTail(new ListNode(4));
        testList2.addNodeTail(new ListNode(6));

        ListNode newList = mtsl.mergeTwoLists(testList1.next, testList2.next);
        System.out.println("The input lists is the following:");
        testList1.printList();
        testList2.printList();
        System.out.println("The output list is the following:");
        newList.printList();
    }
}
