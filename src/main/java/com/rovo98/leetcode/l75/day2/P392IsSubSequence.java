package com.rovo98.leetcode.l75.day2;

/**
 * https://leetcode.com/problems/is-subsequence
 */
public class P392IsSubSequence {
    /*
    TC: O(n)
    SC: O(1)
     */
    public boolean isSubSequence(String s, String t) {
        // base case
        if (s.length() == t.length()) return s.equals(t);

        int preIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            int idx = t.indexOf(s.charAt(i), preIndex + 1);
            if (idx < 0 || idx < preIndex) return false;
            preIndex = idx;
        }

        return true;
    }

    /*
    two pointers
     */
    public boolean isSubSequence1(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
            }
            j += 1;
        }
        return i == s.length();
    }
}
