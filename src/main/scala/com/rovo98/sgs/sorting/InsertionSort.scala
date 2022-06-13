package com.rovo98.sgs.sorting

/**
 * Insertion sorting naive implementation using List concatenation.
 */
object InsertionSort {

  /**
   * InsertionSort implemented using List concatenation
   *
   * @param xs       A list of elements to be sorted
   * @param ordering [[Ordering]] defines the way to sort elements (desc/asc)
   * @tparam T The type of element
   * @return A sorted list
   */
  def sort[T](xs: List[T])(implicit ordering: Ordering[T]): List[T] = xs match {
    case List() => List[T]()
    case y :: ys => insert(y, sort(ys))(ordering)
  }

  private def insert[T](x: T, xs: List[T])(implicit ordering: Ordering[T]): List[T] =
    xs match {
      case List() => x :: Nil
      case y :: ys =>
        if (ordering.lt(x, y)) x :: y :: ys
        else y :: insert(x, ys)
    }
}
