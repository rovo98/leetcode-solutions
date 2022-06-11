package com.rovo98.leetcode.slidingwindow

import com.rovo98.leetcode.BaseFunSuite

class _1876_SubstringsOfSizeThreeWithDistinctCharactersTestCase extends BaseFunSuite {

  test("case1") {
    val str = "xyzzaz"
    val expected = 1

    val result = _1876_SubstringsOfSizeThreeWithDistinctCharacters.countGoodSubstrings(str)
    val result1 = _1876_SubstringsOfSizeThreeWithDistinctCharacters.countGoodSubstringsV1(str)

    result shouldEqual expected
    result1 shouldEqual expected
  }

  test("case2") {
    val str = "aababcabc"
    val expected = 4

    val result = _1876_SubstringsOfSizeThreeWithDistinctCharacters.countGoodSubstrings(str)
    val result1 = _1876_SubstringsOfSizeThreeWithDistinctCharacters.countGoodSubstringsV1(str)

    result shouldEqual expected
    result1 shouldEqual expected
  }

  test("case3") {
    val str = "x"
    val expected = 0

    val result = _1876_SubstringsOfSizeThreeWithDistinctCharacters.countGoodSubstrings(str)
    val result1 = _1876_SubstringsOfSizeThreeWithDistinctCharacters.countGoodSubstringsV1(str)

    result shouldEqual expected
    result1 shouldEqual expected
  }

}
