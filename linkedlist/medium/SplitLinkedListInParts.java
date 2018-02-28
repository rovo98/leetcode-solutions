package LinkedList.Medium;

import LinkedList.ListNode;

/**
 * Problem: Acceptance: 48.3%
 *
 * Given a (singly) linked list with head node root, write a function to split the linked
 * list into k consecutive linked list "parts".
 *
 * The length of each part should be as equal as possible: no two parts should have a size
 * differing by more than 1. This may lead to some parts being null.
 *
 * The parts should be in order of occurrence in the input list, and parts occurring earlier
 * should always have a size greater than or equal parts occurring later.
 *
 * Return a List of ListNode's representing the linked list parts that are formed.
 *
 * Examples 1->2->3->4, k = 5 // 5 equal parts [[1],[2],[3],[4],null]
 *
 * Example 1:
 *
 * Input: [1, 2, 3], k = 5
 * Output: [[1], [2], [3], [], []]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2,
 * \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as
 * a ListNode is [].
 *
 * Note :
 *      1. The length of root will be in the range [0, 1000].
 *      2. Each value of a node in the input will be an integer in the range [0, 999].
 *      3. k will be integer in the range [1, 50].
 *
 * @author rovo98
 * Date: 09/2/2018
 */
public class SplitLinkedListInParts {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    //Solution one: ^
    // This algorithm's time complexity is O(n).
    public ListNode[] splitListToParts(ListNode root, int k) {
        /*

         */
        // Get the length of the list first.
        int length = 0;
        ListNode pNode = root;
        while (pNode.next != null) {
            pNode = pNode.next;
            length++;
        }
        int part;           // The length of each part.
        if (k > length) {
            part = 1;
        } else {
            part = length / k;
        }
        pNode = root;
        int count = 0;
        // Allocate parts and initial them.
        ListNode[] parts = new ListNode[k];
        for (int i = 0; i < parts.length; i++) {
            parts[i] = new ListNode(0);
        }
        while (pNode.next != null) {
            int i;
            if (count == 0 && k < length && k*part != length) {
                i = 0;
            } else {
                i = 1;
            }
            for (; i < part+1 && pNode.next != null; i++) {
                pNode = pNode.next;
                parts[count].addNodeTail(new ListNode(pNode.val));
            }
            count++;
        }
        while (count < k) {             // If k > length( of list).
            parts[count++].next = null; // And the rest of parts are assigned to empty.
        }
        return parts;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        SplitLinkedListInParts slip = new SplitLinkedListInParts();
        // test list: 1->2->3->4->NULL.
        ListNode testList = new ListNode(0);
        testList.addNodeTail(new ListNode(1));
        testList.addNodeTail(new ListNode(2));
        testList.addNodeTail(new ListNode(3));
        testList.addNodeTail(new ListNode(4));

        ListNode[] result = slip.splitListToParts(testList, 2);
        System.out.println("The input list is the following:");
        testList.printList();
        System.out.println("And the result is the following:");
        for (ListNode part : result) {
            part.printList();
        }
    }
}
