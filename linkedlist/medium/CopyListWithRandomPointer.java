package LinkedList.Medium;

import LinkedList.RandomListNode;

/**
 * Problem: Acceptance: 26.0%
 *
 * A linked list is given such that each node contains an additional random pointer which could
 * point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * @author rovo98
 * Date: 06/2/2018
 */
public class CopyListWithRandomPointer {
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */
    // Solution one: &
    // This algorithm's time complexity is O(n).
    public RandomListNode copyRandomList(RandomListNode head) {
        /*
        firstly, iterates all the nodes in list.
        copy each node, then insert it after the node.
        like:
         - - - - - - - - - - -
        |                     |
        1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
             |               |
             - - - - - - - -
         secondly, deal with the randomNode. it becomes:
          - - - - - - - - - - -
         |                     |
         1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
              |                    |
               - - - - - - - - - -
         finally, separate it into two list.
         original list:
          - - - - - -
         |          |
         1 -> 2 -> 3 -> null
         deep copy list:
         1' -> 2' -> 3' -> null
         |          |
         - - - - - -
         */
        RandomListNode rpNode = head;

        while (rpNode.next != null) {           // this while loop run in O(n) time complexity.
            rpNode = rpNode.next;
            RandomListNode copyNode = new RandomListNode(rpNode.label);
            copyNode.random = rpNode.random;
            // insert it after the original node.
            copyNode.next = rpNode.next;
            rpNode.next = copyNode;
            rpNode = rpNode.next;
        }
        rpNode = head;
        System.out.println("\nThe first procession.");
        rpNode.printList();
        System.out.println();

        int count = 0;
        while (rpNode.next != null) {          // O(n).
            rpNode = rpNode.next;
            count++;
            if (count % 2 == 0) { // deal with the copy nodes' randomNode
                if (rpNode.random != null) {
                    rpNode.random = rpNode.random.next;
                }
            }
        }
        RandomListNode deepCopyList = new RandomListNode(0);
        RandomListNode dcNode = deepCopyList;
        rpNode = head;
        count = 0;
        while (rpNode.next != null) {           // O(n).
            rpNode = rpNode.next;
            count++;
            if (count % 2 == 0) {
                dcNode.next = rpNode;
                dcNode = dcNode.next;
            }
        }
        dcNode.next = null;
        return deepCopyList;
    }
    // Solution two: &&
    //
    public RandomListNode copyRandomListVersionTwo(RandomListNode head) {
        /*
        use a map to store the random pointer of every node in original list.
         */
        return null;
    }
    // Driver the program to test the method above.
    public static void main(String[] args) {
        CopyListWithRandomPointer clwrp = new CopyListWithRandomPointer();
        // test list:
        /*
            - - - - - -
           |          |
           1 -> 2 - > 3 -> NULL.
         */
        RandomListNode testList = new RandomListNode(0);
        RandomListNode tNode = testList;
        RandomListNode randomNode = new RandomListNode(3);
        tNode.next = new RandomListNode(1);
        tNode = tNode.next;
        tNode.next = new RandomListNode(2);
        tNode = tNode.next;
        tNode.next = randomNode;
        testList.next.random = randomNode;

        System.out.println("The input list is the following:");
        testList.printList();
        RandomListNode deepCopyList = clwrp.copyRandomList(testList);
        System.out.println("And the deep copy list of it is the following:");
        deepCopyList.printList();
    }
}
