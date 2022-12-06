package com.rovo98.leetcode.l75.day2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** https://leetcode.com/problems/isomorphic-strings */
public class P205IsomorphicStrings {
    /*
    TC: O(n)
    SC: O(1)
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapping = new HashMap<>();

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int len = sChars.length;

        // store mapped characters
        Set<Character> mapped = new HashSet<>();
        Map<Character, Integer> chCountMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (mapping.containsKey(sChars[i]) && mapping.get(sChars[i]) != tChars[i]) {
                return false;
            }
            // a character may map to itself.
            if (!mapping.containsKey(sChars[i])) {
                mapping.put(sChars[i], tChars[i]);
                if (!mapped.contains(sChars[i])) {
                    if (chCountMap.containsKey(tChars[i])) {
                        chCountMap.put(tChars[i], chCountMap.get(tChars[i]) + 1);
                    } else {
                        chCountMap.put(tChars[i], 1);
                    }
                    mapped.add(sChars[i]);
                }
            }
        }

        for (int count : chCountMap.values()) {
            // No two characters may map to the same character.
            if (count > 1) return false;
        }
        return true;
    }
}
