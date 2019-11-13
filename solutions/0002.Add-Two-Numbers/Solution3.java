/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, current = result;
        
        int carry = 0;
        while (p != null && q != null) {
            int x = p.val;
            int y = q.val;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            p = p.next;
            q = q.next;
        }
        
       current.next = (p == null) ? q : p; // this operation will modify the input list.
        if (current.next == null)  {
            if (carry > 0) 
               current.next  = new ListNode(1);
            return result.next; // pointer overflow check.
        }
        if (carry > 0) {
            current.next.val++;
        }
        
        format(current.next);
        return result.next;
    }
    private void format(ListNode list) {
           ListNode p = list;
        boolean flag = true;
        while (p != null) {
            flag = false;
                if (p.val > 9) {
                    flag = true;
                    p.val %= 10;
                    if (p.next == null) {
                        p.next = new ListNode(1);
                        break;
                    }
                    p.next.val++;
                }
           if (!flag) break; 
            p = p.next;
        }
    }
}
