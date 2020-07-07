# 03. Longest Substring Without Repeating Characters

## Description

Given a string, find the length of the longest substring without repeating characters.

**Example 1:**

```txt
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
```

**Example 2:**

```txt
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

**Example 3:**
```txt
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

**Links**

[(en)https://leetcode.com/problems/longest-substring-without-repeating-characters/](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
<br />
[(中文)https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

## Solutions

### Solution1

在不了解题目 Tag 的情况下，我能直接想到的方法是用一个 ``StringBuilder`` 或者 ``Set`` 来保存当前遍历的子串，如果该串包含下一个字符，那么该串的长度就是当前子串的最大长度。
依次比较所有遍历子串的长度，即可获得最长子串的长度。

```java
class Solution {
    /**
        Time complexity: O(n*m), where m is the length of the maximum sub-string
        Space complexity: O(m)
    */
    public int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        if (s == null) return 0;
        if (sLen < 2) return sLen;

        Set<Character> set = new HashSet<>(); // or using StringBuilder
        int maxLen = 0;
        for (int i = 0; i < sLen; i++) {
            int pLen = 1;
            set.add(s.charAt(i));
            for (int j = i+1; j < slen; j++) {
                char c = s.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                    pLen++;
                } else {
                    set.clear();
                    break;
                }
            }
            if (maxLen < pLen)
                maxLen = pLen;
        }
        return maxLen;
    }
```

**Submission status**

Solution1 由于采用的非常直接的方式，因此，运行效率比较低 92ms，且占用的内存也较多，39.8MB。仅击败 11%。

## Summary

