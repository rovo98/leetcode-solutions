package LinkedList.Hard;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 28.0%
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
 * complexity.
 *
 * @author rovo98
 * Date: 02/2/2018
 */
public class MergeKSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    // merge two list.
    public ListNode merge2List(ListNode l1, ListNode l2) {
        ListNode pNode = l1;
        ListNode qNode = l2;
        ListNode mergedList = new ListNode(0); //The value of the head node represents the length.
        while (pNode.next != null && qNode.next != null) {
            if (pNode.next.val > qNode.next.val) {
                mergedList.addNodeTail(new ListNode(qNode.next.val));
                qNode = qNode.next;
            } else {
                mergedList.addNodeTail(new ListNode(pNode.next.val));
                pNode = pNode.next;
            }
            mergedList.val++;
        }
        // If the l1 has nodes left.
        while (pNode.next != null) {
            pNode = pNode.next;
            mergedList.addNodeTail(new ListNode(pNode.val));
            mergedList.val++;
        }
        // If the l2 has nodes left.
        while (qNode.next != null) {
            qNode = qNode.next;
            mergedList.addNodeTail(new ListNode(qNode.val));
            mergedList.val++;
        }
        return mergedList;
    }
    // Solution one: ^
    // The time complexity of this algorithm is O(n^2).
    public ListNode mergeKList(ListNode[] lists) {
        ListNode finalList = lists[0];
        // Iterate all the lists, and merge them one by one.
        for (int i=1; i<lists.length; i++) {
            finalList = merge2List(finalList, lists[i]);
        }
        return finalList;
    }
    // Solution two:
    // Using divide and conquer.
    // Its time complexity is O(n log n). like mergeSort.
    public ListNode mergeKListVersionTwo(ListNode[] lists) {
        int len = lists.length;
        while (len > 1) {
            int half = (len+1) / 2;
            for (int i = 0; i < len/2; i++) {
               lists[i] =  merge2List(lists[i], lists[i+half]);
            }
            // we only processing half lists next loop.
            len = half;
        }
        return lists[0];
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        MergeKSortedLists mksl = new MergeKSortedLists();
        ListNode[] testLists1 = new ListNode[4];
        ListNode[] testLists2 = new ListNode[5];
        for (int i=0; i<testLists1.length; i++) {
            testLists1[i] = new ListNode(-1);
            testLists1[i].addNodeTail(new ListNode(1));
            testLists1[i].addNodeTail(new ListNode(2));
            testLists1[i].addNodeTail(new ListNode(4));
            testLists1[i].addNodeTail(new ListNode(7));
        }
        for (int i = 0; i < testLists2.length; i++) {
            testLists2[i] = new ListNode(-1);
            testLists2[i].addNodeTail(new ListNode(2));
            testLists2[i].addNodeTail(new ListNode(3));
            testLists2[i].addNodeTail(new ListNode(5));
        }

        System.out.println("The input lists1 is the following:");
        for (int i=0; i<testLists1.length; i++) {
            testLists1[i].printList();
        }
        System.out.println("The input lists2 is the following:");
        for (ListNode list : testLists2) {
            list.printList();
        }
        ListNode mergedList1 = mksl.mergeKList(testLists1);
        ListNode mergedList2 = mksl.mergeKListVersionTwo(testLists2);
        System.out.println("After calling the function with version one, the merged list is the following:");
        mergedList1.printList();
        System.out.println("After calling the function with wersion two, the merged list is the following:");
        mergedList2.printList();
    }
}
