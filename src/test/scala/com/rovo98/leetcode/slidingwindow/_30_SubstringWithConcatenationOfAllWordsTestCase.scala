package com.rovo98.leetcode.slidingwindow

import com.rovo98.leetcode.BaseFunSuite

class _30_SubstringWithConcatenationOfAllWordsTestCase extends BaseFunSuite {
  test("case 1") {
    val s = "barfoothefoobarman"
    val words = Array("foo", "bar")

    val expected = List(0, 9)

    val result = _30_SubstringWithConcatenationOfAllWords.findSubstring(s, words)
    result.length shouldEqual expected.length
    result.foreach(r => expected.contains(r) shouldBe true)
  }

  test("case 2") {
    val s = "wordgoodgoodgoodbestword"
    val words = Array("word", "good", "best", "word")

    val expected = List()

    val result = _30_SubstringWithConcatenationOfAllWords.findSubstring(s, words)
    result shouldEqual expected
  }

  test("case 3") {
    val s = "barfoofoobarthefoobarman"
    val words = Array("bar", "foo", "the")
    val expected = List(6, 9, 12)

    val result = _30_SubstringWithConcatenationOfAllWords.findSubstring(s, words)
    result.length shouldEqual expected.length
    result.foreach(r => expected.contains(r) shouldBe true)
  }

  test("case 4") {
    val s = "wordgoodgoodgoodbestword"
    val words = Array("word", "good", "best", "good")
    val expected = List(8)

    val result = _30_SubstringWithConcatenationOfAllWords.findSubstring(s, words)
    result.length shouldEqual expected.length
    result.foreach(r => expected.contains(r) shouldBe true)
  }

  test("case 5") {
    val s = "lingmindraboofooowingdingbarrwingmonkeypoundcake"
    val words = Array("fooo", "barr", "wing", "ding", "wing")
    val expected = List(13)

    val result = _30_SubstringWithConcatenationOfAllWords.findSubstring(s, words)
    result.length shouldEqual expected.length
    result.foreach(r => expected.contains(r) shouldBe true)
  }
}
