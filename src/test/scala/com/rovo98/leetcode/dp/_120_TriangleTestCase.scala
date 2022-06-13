package com.rovo98.leetcode.dp

import com.rovo98.leetcode.BaseFunSuite

class _120_TriangleTestCase extends BaseFunSuite {
  test("case 1") {
    val triangle = List(
      List(2),
      List(3, 4),
      List(6, 5, 7),
      List(4, 1, 8, 3)
    )

    val result = _120_Triangle.minimumTotal(triangle)
    result shouldEqual 11
  }

  test("case 2") {
    val triangle = List(List(-10))

    _120_Triangle.minimumTotal(triangle) shouldEqual -10
  }
}
