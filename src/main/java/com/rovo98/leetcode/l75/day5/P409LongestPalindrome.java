package com.rovo98.leetcode.l75.day5;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindrome
 */
public class P409LongestPalindrome {
    /*
     TC: O(n)
     SC: O(n)
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }
        int result = 0;
        int oneCharCount = 0;
        int oddCharCount = 0;
        for (int c : freq.values()) {
            if (c >= 2) {
                if (c % 2 == 0) {
                    result += c;
                } else {
                    result += (c / 2) * 2;
                    oddCharCount++;
                }
            } else {
                oneCharCount++;
            }
        }
        return (oneCharCount > 0 || oddCharCount > 0) ? result + 1 : result;
    }
}
