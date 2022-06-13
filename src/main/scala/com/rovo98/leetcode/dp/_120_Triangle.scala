package com.rovo98.leetcode.dp

/**
 * ==Description==
 * <p>
 * Given a `triangle` array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are one index `i` on the current row, you may move to either index `i` or index `i+1`
 * on the next row.
 * </p>
 *
 * ==Example 1:==
 * {{{
 *   Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 *   Output: 11
 *   Explanation: The triangle looks like:
 *      2
 *     3 4
 *    6 5 7
 *   4 1 8 3
 *  The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * }}}
 * ==Example 2:==
 * {{{
 *   Input: triangle = [[-10]]
 *   Output: -10
 * }}}
 * ==Constraints==
 *  - `1 <= triangle.length <= 200`
 *  - `triangle[0].length == 1`
 *  - `triangle[i].length == triangle[i - 1].length + 1`
 *  - `-10^4 <= triangle[i][j] <= 10^4`
 *
 *  ==Follow up==
 *  Could you do this using only `O(n)` extra space, where `n` is the total number of the rows in the triangle?
 */
object _120_Triangle {

  /*
  m(n, i) = min (m(n+1, i) , m(n+1, i+1)), 0 <= n <= triangle.length;

  Complexity Analysis:
  TC: O(n*m), where n is length of layers and m is the length of each layer
  SC: O(n*m)
   */
  def minimumTotal(triangle: List[List[Int]]): Int = {
    if (triangle.length == 1) return triangle.head.head

    val n = triangle.length
    val il = triangle(n-1).length

    val dp  = Array.ofDim[Int](n, il)

    // initialization
    for (i <- 0 until il)
      dp(n-1)(i) = triangle(n-1)(i)


    for (i <- (0 to n - 2).reverse) {
      val len = triangle(i).length
      for (j <- 0 until len) {
        dp(i)(j) = triangle(i)(j) + Math.min(dp(i+1)(j), dp(i+1)(j+1))
      }
    }

    dp(0)(0)
  }
}
