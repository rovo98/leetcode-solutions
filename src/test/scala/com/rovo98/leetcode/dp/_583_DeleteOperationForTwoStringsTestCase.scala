package com.rovo98.leetcode.dp

import com.rovo98.leetcode.BaseFunSuite

class _583_DeleteOperationForTwoStringsTestCase extends BaseFunSuite {
  test("case 1") {
    val s1 = "sea"
    val s2 = "eat"
    val expected = 2

    val result = _583_DeleteOperationForTwoStrings.minDistance(s1, s2)
    result shouldEqual expected
  }

  test("case 2") {
    val s1 = "leetcode"
    val s2 = "etco"
    val expected = 4

    val result = _583_DeleteOperationForTwoStrings.minDistance(s1, s2)
    result shouldEqual expected
  }
}
