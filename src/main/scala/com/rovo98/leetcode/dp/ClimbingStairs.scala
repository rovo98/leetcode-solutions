package com.rovo98.leetcode.dp

object ClimbingStairs {
  /*
   * dp approach
   */
  def dpCount(n: Int): Int = {
    if (n <= 0) throw new IllegalArgumentException("Given n can not less than 1.")
    if (n <= 2) return n
    val dp = new Array[Int](n)
    dp(0) = 1
    dp(1) = 2
    for (i <- 2 to n) dp(i) = dp(i-1) + dp(i-2)
    dp(n-1)
  }


  /*
   recursive approach
   */
  def countRecursive(n: Int): Int = {
    if (n <= 0) throw new IllegalArgumentException("Given n should be greater than 0.")
    if (n <= 2) return n
    countRecursive(n - 1) + countRecursive(n - 2)
  }
}
