/**
 * naive implementation
 *
 * This solution will modify the input list.
 * */
class Solution {
    /**
     * Complexity Analysis:
     * Time complexity : O(n)
     * Space complexity: O(1)
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // base check
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // make shorter list as the number to be added.
        int len1 = 0, len2 = 0;
        ListNode c;
        // calc the len of l1
        c = l1;
        while (c != null) {
            c = c.next;
            len1++;
        }
        // calc the len of l2
        c = l2;
        while (c != null) {
            c = c.next;
            len2++;
        }
        ListNode p, q; // p point to the longer one
        if (len1 > len2) {
            p = l1;
            q = l2;
        } else {
            p = l2;
            q = l1;
        }
        while (p != null && q != null) {
            p.val = p.val + q.val;
            if (p.val > 9) {
                format(p);
                p.next.val++;
            }
            p = p.next;
            q = q.next;
        }
        return len1 > len2 ? l1 : l2;
    }
    // helper function
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
