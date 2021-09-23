package com.rovo98.leetcode.dp

import com.rovo98.leetcode.BaseFunSuite

class ClimbingStairsSuite extends BaseFunSuite {
  test("test case 1") {
    ClimbingStairs.dpCount(1) should be (1)
    ClimbingStairs.countRecursive(1) should be (1)

    ClimbingStairs.dpCount(2) should be (2)
    ClimbingStairs.countRecursive(2) should be (2)
  }
}
