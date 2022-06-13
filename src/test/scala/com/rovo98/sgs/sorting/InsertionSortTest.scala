package com.rovo98.sgs.sorting

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class InsertionSortTest extends AnyFunSuite with Matchers {

  test("sort an empty list") {
    val sorted = InsertionSort.sort(List[Int]())

    sorted shouldEqual List[Int]()
  }

  test("sort int list in asc order") {
    val list = List(1, 3, 2, 5, 4)
    val expected = for (i <- 1 to 5) yield i

    val sorted = InsertionSort.sort(list)
    sorted shouldEqual expected
  }

  test("sort int list in desc order") {
    val list = 1 :: 3 :: 4 :: 2 :: 6 :: 5 :: Nil
    val expected = for (i <- (1 to 6).reverse) yield i

    val sorted = InsertionSort.sort(list)(Ordering.Int.reverse)
    sorted shouldEqual expected
  }

  test("sort string list in asc order") {
    val list = List("rovo98", "hello", "world", "test")
    val expected = List("hello", "rovo98", "test", "world")

    val sorted = InsertionSort.sort(list)
    sorted shouldEqual expected
  }
}
