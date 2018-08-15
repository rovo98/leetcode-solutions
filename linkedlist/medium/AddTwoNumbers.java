package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 28.3%
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0
 * itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author rovo98
 * Date: 03/2/2018
 */
public class AddTwoNumbers {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0); // the value of the head node represents the length of the number.
        ListNode pNode = l1;
        ListNode qNode = l2;

        // add up digits one by one.
        while (pNode.next != null && qNode.next != null) {
            pNode = pNode.next;
            qNode = qNode.next;
            resultList.addNodeTail(new ListNode(pNode.val+qNode.val));
            resultList.val++;
        }
        // If the l1 has digits left.
        while (pNode.next != null) {
            pNode = pNode.next;
            resultList.addNodeTail(new ListNode(pNode.val));
            resultList.val++;
        }
        // If the l2 has digits left.
        while (qNode.next != null) {
            qNode = qNode.next;
            resultList.addNodeTail(new ListNode(qNode.val));
            resultList.val++;
        }
        // correct the result.
        ListNode rNode = resultList;
        while (rNode.next != null) {
            rNode = rNode.next;
            if (rNode.val > 9) {
                rNode.val %= 10;
                rNode.next.val++;
            }
        }
        return resultList;
    }
    // solution from leetcode.
    private ListNode addTwoNumber2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, curr = result;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return result.next;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode testNum1 = new ListNode(-1);
        ListNode testNum2 = new ListNode(-1);
        // number one : 243 represents the 342.
        testNum1.addNodeTail(new ListNode(2));
        testNum1.addNodeTail(new ListNode(4));
        testNum1.addNodeTail(new ListNode(3));
        // number two : 564 represents the 465.
        testNum2.addNodeTail(new ListNode(5));
        testNum2.addNodeTail(new ListNode(6));
        testNum2.addNodeTail(new ListNode(4));

        System.out.println("Two input numbers is the following:");
        testNum1.printList();
        testNum2.printList();
        ListNode result = atn.addTwoNumbers(testNum1, testNum2);
        System.out.println("The result is the following, and its length is "+result.val+".");
        result.printList();
    }
}
