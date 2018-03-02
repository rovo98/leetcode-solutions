package LinkedList.Hard;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 31.2%
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should
 * remain as it is.
 *
 * You may not alter the values in the nodes, only itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example:
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return : 2->1->4->3->5
 * For k = 3, you should return : 3->2->1->4->5
 *
 * @author rovo98
 * Date: 10/2/2018
 */
public class ReverseNodesInKGroup {
    // Reverses a group of nodes.
    public ListNode reverse(ListNode preNode, ListNode endNode) {
        ListNode rNode = preNode.next;
        while (rNode.next != endNode) {
            ListNode node = rNode.next;
            rNode.next = node.next;
            node.next = preNode.next;
            preNode.next = node;
        }
        // returns the previous node of the node which starts reversing.
        return rNode;
    }
    // Solution one: &
    // This algorithm's time complexity is O(n).
    public ListNode reverseKGroup(ListNode head, int k) {
        /*
          use reversing operation in list thoughts.
         */
        ListNode pNode = head;
        ListNode preNode;
        while (pNode.next != null) {
            preNode = pNode;
            for (int i = 0; i < k; i++) {
                pNode = pNode.next;
                if (pNode == null) { // If the left nodes can't be a group.
                    return head;
                }
            }
            pNode = reverse(preNode, pNode.next);
        }
        return head;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        ReverseNodesInKGroup rnikg = new ReverseNodesInKGroup();
        ListNode testList = new ListNode(0);
        for (int i = 1; i < 6; i++) {
            testList.addNodeTail(new ListNode(i));
        }
        System.out.println("The input list is the following:");
        testList.printList();
        testList = rnikg.reverseKGroup(testList, 3);
        System.out.println("And the output is the following:");
        testList.printList();
    }
}
