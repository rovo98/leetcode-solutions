package LinkedList.Easy;

import LinkedList.ListNode;

/**
 * Problem:  Acceptance: 30.9%
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                      ↘
 *                         c1 → c2 → c3
 *                      ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 * Notes:
 *   1. If the two linked lists have no intersection at all, return null.
 *   2. The linked lists must retain their original structure after the function returns.
 *   3. You may assume there are no cycles anywhere in the entire linked structure.
 *   4. Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * @author rovo98
 * Date: 03/2/2018
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // As we know, if we just iterate all the elements in list1 and compare to each element
    // in list2, we can get the result. But it will run in O(n^2) time.
    // There is important point that two lists have the same length counted from the intersected node
    // to the end.
    // This algorithm's time complexity is O(n) and its memory complexity is O(1).
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // To get listA's length.
        ListNode pNode = headA;
        ListNode qNode = headB;
        int length1 = 0;
        int length2 = 0;
        while (pNode.next != null) {
            pNode = pNode.next;
            length1++;
        }
        // To get listB's length.
        while (qNode.next != null) {
            qNode = qNode.next;
            length2++;
        }
        // adjust listA and listB, Compare their nodes starts with the same length.
        int steps;
        if (length1 > length2) {
            steps = length1 - length2;
            while (steps > 0) {
                headA = headA.next;
                steps--;
            }
        } else {
            steps = length2 - length1;
            while (steps > 0) {
                headB = headB.next;
                steps--;
            }
        }
        // compare their nodes one by one.
        while (headA.next != null && headB.next != null) {
            if (headA.next.equals(headB.next)) {
                return headA.next;
            }
            headA = headA.next;
            headB = headB.next;
        }
        // If the intersected node doesn't exists.
        return null;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists iotl = new IntersectionOfTwoLinkedLists();
        ListNode testList1 = new ListNode(-1);
        ListNode testList2 = new ListNode(-1);
        ListNode intersectedNode = new ListNode(31);
        testList1.addNodeTail(new ListNode(11));
        testList1.addNodeTail(new ListNode(12));

        testList2.addNodeTail(new ListNode(21));
        testList2.addNodeTail(new ListNode(22));
        testList2.addNodeTail(new ListNode(23));
        // add the intersected nodes to list1 and list2
        testList1.addNodeTail(intersectedNode);
        testList1.addNodeTail(new ListNode(32));
        testList1.addNodeTail(new ListNode(33));
        testList2.addNodeTail(intersectedNode);

        System.out.println("The input lists is the following:");
        testList1.printList();
        testList2.printList();
        ListNode result = iotl.getIntersectionNode(testList1, testList2);
        System.out.println("These two lists begin to intersect at "+result.val+".");
    }
}
