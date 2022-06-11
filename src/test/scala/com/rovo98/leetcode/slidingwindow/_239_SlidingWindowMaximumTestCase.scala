package com.rovo98.leetcode.slidingwindow

import com.rovo98.leetcode.BaseFunSuite


class _239_SlidingWindowMaximumTestCase extends BaseFunSuite {

  test("case 1") {
    val nums = Array(1, 3, -1, -3, 5, 3, 6, 7)
    val k = 3
    val expected = Array(3, 3, 5, 5, 6, 7)

    val result = _239_SlidingWindowMaximum.maxSlidingWindow(nums, k)
    val resultOpt = _239_SlidingWindowMaximum.maxSlidingWindowOpt(nums, k)
    val resultOpt2 = _239_SlidingWindowMaximum.maxSlidingWindowOpt2(nums, k)

    result shouldEqual expected
    resultOpt shouldEqual expected
    resultOpt2 shouldEqual expected
    resultOpt2 shouldEqual expected
  }

  test("case 2") {
    val nums = Array(1)
    val k = 1
    val expected = Array(1)

    val result = _239_SlidingWindowMaximum.maxSlidingWindow(nums, k)
    val resultOpt = _239_SlidingWindowMaximum.maxSlidingWindowOpt(nums, k)
    val resultOpt2 = _239_SlidingWindowMaximum.maxSlidingWindowOpt2(nums, k)

    result shouldEqual expected
    resultOpt shouldEqual expected
    resultOpt2 shouldEqual expected
  }

  test("case 3") {
    val nums = Array(1, 2, 3, 4, 5)
    val k = 5

    val expected = Array(5)
    val result = _239_SlidingWindowMaximum.maxSlidingWindow(nums, k)
    val resultOpt = _239_SlidingWindowMaximum.maxSlidingWindowOpt(nums, k)
    val resultOpt2 = _239_SlidingWindowMaximum.maxSlidingWindowOpt2(nums, k)

    result shouldEqual expected
    resultOpt shouldEqual expected
    resultOpt2 shouldEqual expected
  }

  test("case 4") {
    val nums = Array(1, -1)
    val k = 1

    val expected = Array(1, -1)
    val result = _239_SlidingWindowMaximum.maxSlidingWindow(nums, k)
    val resultOpt = _239_SlidingWindowMaximum.maxSlidingWindowOpt(nums, k)
    val resultOpt2 = _239_SlidingWindowMaximum.maxSlidingWindowOpt2(nums, k)

    result shouldEqual expected
    resultOpt shouldEqual expected
    resultOpt2 shouldEqual expected
  }

  test("case 5") {
    val nums = Array(7, 2, 4)
    val k = 2

    val expected = Array(7, 4)
    val result = _239_SlidingWindowMaximum.maxSlidingWindow(nums, k)
    val resultOpt = _239_SlidingWindowMaximum.maxSlidingWindowOpt(nums, k)
    val resultOpt2 = _239_SlidingWindowMaximum.maxSlidingWindowOpt2(nums, k)

    result shouldEqual expected
    resultOpt shouldEqual expected
    resultOpt2 shouldEqual expected
  }

  test("case 6") {
    val nums = Array(1, 3, 1, 2, 0, 5)
    val k = 3

    val expected = Array(3, 3, 2, 5)
    val result = _239_SlidingWindowMaximum.maxSlidingWindow(nums, k)
    val resultOpt = _239_SlidingWindowMaximum.maxSlidingWindowOpt(nums, k)
    val resultOpt2 = _239_SlidingWindowMaximum.maxSlidingWindowOpt2(nums, k)

    result shouldEqual expected
    resultOpt shouldEqual expected
    resultOpt2 shouldEqual expected
  }
}
