package LinkedList.Easy;

import LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Acceptance: 40.1%
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * @author rovo98
 * Date: 02/2/2018
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    // Solution one: ^
    // The time complexity of this algorithm is O(n) and its space complexity is O(n) too.
     public ListNode deleteDuplicates(ListNode head) {
          ListNode pNode = head;
          // use a set to store all the distinct nodes.
          Set<Integer> nodeSet = new HashSet<>();
          while (pNode.next != null) {
              if (nodeSet.contains(pNode.next.val)){ // If the node we meet is already in the map.
                  pNode.next = pNode.next.next;
                  continue;
              } else {
                nodeSet.add(pNode.next.val);
              }
              pNode = pNode.next;
          }
          return head;
     }
     // Solution two: ^
     // This algorithm's time complexity is O(n) and its space complexity is O(1).
     public ListNode deleteDuplicateVersionTwo(ListNode head) {
         // Iterate the list, compare two node each time
         // If their val is equal then delete the second node, otherwise, iterate to
         // the next node.
         ListNode pNode = head.next; // starts from the first node, not the head node.
         while (pNode.next != null) {
             if (pNode.val == pNode.next.val) {
                 pNode.next = pNode.next.next;
             } else {
                 pNode = pNode.next;
             }
         }
         return head;
     }
     // Derive the program to test the method above.
     public static void main(String[] args) {
         RemoveDuplicatesFromSortedList rdfsl = new RemoveDuplicatesFromSortedList();
         // test list1 : 1->2->1->3->3->NULL.
         ListNode testList1 = new ListNode(-1);
         testList1.addNodeTail(new ListNode(1));
         testList1.addNodeTail(new ListNode(2));
         testList1.addNodeTail(new ListNode(1));
         testList1.addNodeTail(new ListNode(3));
         testList1.addNodeTail(new ListNode(3));
         // test list2 : 1->3->3->4->NULL.
         ListNode testList2 = new ListNode(-1);
         testList2.addNodeTail(new ListNode(1));
         testList2.addNodeTail(new ListNode(3));
         testList2.addNodeTail(new ListNode(3));
         testList2.addNodeTail(new ListNode(4));

         System.out.println("The input linked-list1 is the following:");
         testList1.printList();
         System.out.println("The input linked-list2 is the following:");
         testList2.printList();

         testList1 = rdfsl.deleteDuplicates(testList1);
         testList2 = rdfsl.deleteDuplicateVersionTwo(testList2);
         System.out.println("After calling the function with version one, the list1 becomes:");
         testList1.printList();
         System.out.println("After calling the function with version two, the list2 becomes:");
         testList2.printList();
     }
}
