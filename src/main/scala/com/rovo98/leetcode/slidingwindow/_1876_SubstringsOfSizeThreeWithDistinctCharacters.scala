package com.rovo98.leetcode.slidingwindow

/**
 * ==Description==
 * <p>
 * A string is <b>good</b> if there are no repeated characters.
 * Give a string `s`, return the number of good substrings of length three in s.
 *
 * Note that if there are multiple occurrences of the same substring, every occurrence should
 * be counted.
 *
 * A substring is contiguous sequence of characters in a string.
 * </p>
 * ==Example 1:==
 * {{{
 *   Input: s = "xyzzaz"
 *   Output: 1
 *   Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
 *   The only good substring of length 3 is "xyz".
 * }}}
 * ==Example 2:==
 * {{{
 *   Input: s = "aababcabc"
 *   Output: 4
 *   Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
 *   The good substrings are "abc", "bca", "cab", and "abc".
 * }}}
 * ==Constraints:==
 *  - `1 <= s.length <= 100`
 *  - `s` consists of lowercase English letters
 */
object _1876_SubstringsOfSizeThreeWithDistinctCharacters {
  def countGoodSubstrings(s: String): Int = {
    val len = s.length

    // base cases
    if (len < 3) return 0

    val initBits = -1 << 26
    var bitset: Int = initBits

    var count = 0
    for (i <- 0 to len - 3)
      if (isGoodSubstr(i))
        count = count + 1

    def isGoodSubstr(st: Int): Boolean = {
      for (i <- st until st + 3) {
        val p = s.charAt(i) - 'a'
        if (((bitset >> p) & 1) == 1) {
          bitset = initBits
          return false
        } else {
          bitset = bitset | (1 << p)
        }
      }
      bitset = initBits
      true
    }

    count
  }

  def countGoodSubstringsV1(s: String): Int = {
    val len = s.length
    // base cases
    if (len < 3) return 0

    var count = 0
    for (i <- 0 to len - 3)
      if (isGoodStr(i)) count = count + 1

    def isGoodStr(st: Int): Boolean =
      !(s.charAt(st) == s.charAt(st + 1) ||
        s.charAt(st) == s.charAt(st + 2) ||
        s.charAt(st + 1) == s.charAt(st + 2))

    count
  }
}
