package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 46.0%
 *
 * You are given two non-empty linked lists representing two non-negative integers. The most significant
 * digit comes first and each of their nodes contain a single digit. Add the two numbers
 * and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words reversing lists is not
 * allowed.
 *
 * Example :
 * Input : (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 * @author rovo98
 * Date: 03/2/2018
 */
public class AddTwoNumbersTwo {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // This algorithm's time complexity is O(n^2).
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0); // the value of the head node represents the length of the number.
        ListNode pNode = l1;
        ListNode qNode = l2;
        int length1 = 0; // the length of the l1.
        int length2 = 0; // the length of the l2.
        // To get the length of these two lists first.
        while (pNode.next != null) {
            pNode = pNode.next;
            length1++;
        }
        while (qNode.next != null) {
            qNode = qNode.next;
            length2++;
        }
        // adjust the l1 and l2. And add the most significant digits to resultList.
        int steps;
        if (length1 > length2) {
            steps = length1 - length2;
            while (steps > 0) {
                l1 = l1.next;
                resultList.addNodeTail(new ListNode(l1.val));
                resultList.val++;
                steps--;
            }
        } else {
            steps = length2 - length1;
            while (steps > 0) {
                l2 = l2.next;
                resultList.addNodeTail(new ListNode(l2.val));
                resultList.val++;
                steps--;
            }
        }
        // add up l1 and l2.
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            resultList.addNodeTail(new ListNode(l1.val+l2.val));
            resultList.val++;
        }
        // correct the result.
        while (!isFinalResult(resultList)) {
            ListNode rNode = resultList;
            while (rNode.next != null) {
                if (rNode.next.val > 9) {
                    if (rNode.next.equals(resultList.next)) { // If first digit more than 9.
                        ListNode highDigit = new ListNode(1);
                        rNode.next.val = 0;
                        // insert the highDigit to the resultList.
                        highDigit.next = rNode.next;
                        rNode.next = highDigit;
                    } else {
                        rNode.val++;
                        rNode.next.val = 0;
                    }
                }
                rNode = rNode.next;
            }
        }
        return resultList;
    }
    // detect whether the result we got is the final result or not.
    public boolean isFinalResult(ListNode result) {
        ListNode rNode = result;
        while (rNode.next != null) {
            rNode = rNode.next;
            if (rNode.val > 9) {
                return false;
            }
        }
        return true;
    }
    // Driver the program to test the method above.
    public static void main(String[] args) {
        AddTwoNumbersTwo atnt = new AddTwoNumbersTwo();
        ListNode testNum1 = new ListNode(-1);
        ListNode testNum2 = new ListNode(-1);
        // number one : 9443  -- 9->4->4->3->NULL
        testNum1.addNodeTail(new ListNode(9));
        testNum1.addNodeTail(new ListNode(4));
        testNum1.addNodeTail(new ListNode(4));
        testNum1.addNodeTail(new ListNode(3));
        // number two : 564  -- 5->6->4->NULL
        testNum2.addNodeTail(new ListNode(5));
        testNum2.addNodeTail(new ListNode(6));
        testNum2.addNodeTail(new ListNode(4));

        System.out.println("The input numbers is the following:");
        testNum1.printList();
        testNum2.printList();
        // The result will be : 10007 -- 1->0->0->0->7->NULL
        ListNode result = atnt.addTwoNumbers(testNum1, testNum2);
        System.out.println("The result is the following, and its length is "+result.val+".");
        result.printList();
    }
}
