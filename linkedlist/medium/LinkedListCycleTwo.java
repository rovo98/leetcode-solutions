package LinkedList.Medium;

import LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Acceptance: 30.8%
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * @author rovo98
 * Date: 03/2/2018
 * Modify: 13/2/2018 -- Add solution two.
 */
public class LinkedListCycleTwo {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    /*
    Complexity Analysis:
        Time complexity: O(n^2).
        Space complexity: O(1).
     */
    public ListNode detectCycle(ListNode head) {
        // use two pointers, one always starts from the head of the list while one move forward each time.
        // compare their steps.
        ListNode pNode = head;
        ListNode qNode;
        int steps1 = 0;
        int steps2 = 0;
        while (pNode.next != null) {
            pNode = pNode.next;
            steps1++;
            qNode = head;
            while (qNode.next != null && !qNode.equals(pNode)) {
                qNode = qNode.next;
                steps2++;
            }
            if (steps1 != steps2) {
                return pNode;
            }
        }
        // If there is no cycle in list.
        return null;
    }

    // Solution two : ^&
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(n).
     */
    public ListNode detectCycleVersionTwo(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (nodeSet.contains(head)) {
                return new ListNode(head.val);
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        // If there is no cycle in list.
        return null;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        LinkedListCycleTwo lct = new LinkedListCycleTwo();
        /**
         * The input list is the following:
         *  1 -> 2 -> 3
         *       |    |
         *       5 <- 4
         *
         */
        ListNode testList = new ListNode(-1);
        testList.addNodeTail(new ListNode(1));
        ListNode point = new ListNode(2);
        testList.addNodeTail(point);
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(4));
        testList.addNodeTail(new ListNode(5));
        testList.addNodeTail(point);

        ListNode result = lct.detectCycle(testList);
        System.out.println("After calling the function with version one, the cycle begins at :"+result.val);
    }
}
