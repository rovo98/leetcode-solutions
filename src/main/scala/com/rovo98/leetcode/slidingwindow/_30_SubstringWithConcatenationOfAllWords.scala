package com.rovo98.leetcode.slidingwindow

/**
 * ==Description==
 * <p>
 * You are given a string `s` and an array of strings `words` of the same length.
 * Return all starting indices of substring(s) in `s` that is a concatenation of each
 * words exactly once, in any order, and without any intervening characters.
 *
 * You can return the answer in any order
 * </p>
 * ==Example1:==
 * {{{
 *   Input: s = "barfoothefoobarman", words = ["foo","bar"]
 *   Output: [0,9]
 *   Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 *   The output order does not matter, returning [9,0] is fine too.
 * }}}
 * ==Example2:==
 * {{{
 *   Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 *   Output: []
 * }}}
 * ==Example3:==
 * {{{
 *   Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 *   Output: [6,9,12]
 * }}}
 * ==Constraints==
 *  - `1 <= s.length <= 10^4`
 *  - `s` consists of lower-case English letters.
 *  - `1 <= words.length <= 5000`
 */
object _30_SubstringWithConcatenationOfAllWords {

  def findSubstring(s: String, words: Array[String]): List[Int] = {
    import collection.mutable
    import util.control.Breaks._
    val result = mutable.ArrayBuffer.empty[Int]

    val stride = words(0).length
    var ws = 0
    var we = words.length * stride

    def isValidSubstring(si: Int, ei: Int): Boolean = {
      val hits = Array.fill[Int](words.length)(0)
      var vsi = si
      while (vsi < ei) {
        val substr = s.substring(vsi, vsi + stride)
        val indices = mutable.ArrayBuffer[Int]()
        for (i <- words.indices) {
          if (words(i).equals(substr)) {
            indices.append(i)
          }
        }
        if (indices.isEmpty) return false
        val targetIndices = indices.filter(_ >= 0)

        // verify current bitset first
        var verify = 1
        targetIndices.foreach(i => verify = verify & hits(i))
        if (verify == 1) return false

        breakable {
          targetIndices.foreach(index => {
            if (hits(index) == 0) {
              hits(index) = 1
              break
            }
          })
        }
        vsi = vsi + stride
      }
      hits.foldLeft(1)((a: Int, b: Int) => a & b) == 1
    }

    while (we <= s.length) {
      if (isValidSubstring(ws, we)) {
        result.append(ws)
      }
      ws = ws + 1
      we = we + 1
    }

    result.toList
  }

}
