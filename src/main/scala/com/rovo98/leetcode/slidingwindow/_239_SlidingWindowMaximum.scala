package com.rovo98.leetcode.slidingwindow

/**
 * ==Description:==
 * <p>
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the
 * very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding
 * window moves right by one position.
 * <br/>
 * Return the max sliding window.
 * </p>
 * ==Example 1:==
 * {{{
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * }}}
 * ==Example 2:==
 * {{{
 *   Input: nums = [1], k = 1
 *   Output: [1]
 * }}}
 * ==Constraints:==
 *  - `1 <= nums.length <= 10^5`
 *  - `-10^4 <= nums[i] < 10^4`
 *  - `1 <= k <= nums.length`
 *
 * https://leetcode.com/problems/sliding-window-maximum/
 */
object _239_SlidingWindowMaximum {
  // This implementation might occurs Memory Limit Exceed exception.
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    // precondition checking
    if (nums.length < k)
      throw new IllegalArgumentException("k should be smaller than the size of the given array.")
    // base cases
    if (nums.length == 1 && k == 1) return nums

    def findMaxOfRange(nums: Array[Int], s: Int, e: Int): Int = {
      var i = s
      var j = e
      var max = Int.MinValue
      while (i <= j) {
        if (nums(i) > max) max = nums(i)
        if (nums(j) > max) max = nums(j)
        i = i + 1
        j = j - 1
      }
      max
    }

    val r = k until nums.length

    val result = new Array[Int](r.size + 1)

    // find the maximum of the first window
    result(0) = findMaxOfRange(nums, 0, k - 1)

    // find each maximum of every sliding window
    var i = 1
    for (j <- r) {
      result(i) = findMaxOfRange(nums, j - k + 1, j)
      i = i + 1
    }

    result
  }

  /*
  Complexity analysis:
  (n - k + 1) * 2T(k/2)

  TC: O(nlogn)
  SC: O(n)
   */

  def maxSlidingWindowOpt(nums: Array[Int], k: Int): Array[Int] = {
    // precondition checking
    if (nums.length < k)
      throw new IllegalArgumentException("k should be smaller than the size of the given array.")
    // base cases
    if (nums.length == 1 && k == 1) return nums

    var maximumIndex = -1

    def updateMaxIndexOfRange(nums: Array[Int], s: Int, e: Int): Unit = {
      maximumIndex = s
      var i = s
      var j = e
      while (i <= j) {
        if (nums(i) > nums(maximumIndex)) maximumIndex = i
        if (nums(j) > nums(maximumIndex)) maximumIndex = j
        i = i + 1
        j = j - 1
      }
    }

    def findMaxOfRange(nums: Array[Int], s: Int, e: Int): Int = {
      if (maximumIndex == -1) {
        updateMaxIndexOfRange(nums, s, e)
        return maximumIndex
      }
      // NOTE: maximumIndex will never greater than e
      if (maximumIndex < s) { // update maximum index if needed
        updateMaxIndexOfRange(nums, s, e)
        maximumIndex
      } else {
        if (nums(e) > nums(maximumIndex))
          maximumIndex = e
        maximumIndex
      }
    }

    val r = k until nums.length

    val result = new Array[Int](r.size + 1)

    // find the maximum of the first window
    result(0) = nums(findMaxOfRange(nums, 0, k - 1))

    // find each maximum of every sliding window
    var i = 1
    for (j <- r) {
      result(i) = nums(findMaxOfRange(nums, j - k + 1, j))
      i = i + 1
    }
    result
  }

  def maxSlidingWindowOpt2(nums: Array[Int], k: Int): Array[Int] = {
    // precondition checking
    if (nums.length < k)
      throw new IllegalArgumentException("k should be smaller than the size of the given array.")
    // base cases
    if (nums.length == 1 && k == 1) return nums

    import collection.mutable.{PriorityQueue => mutablePriorityQueue}
    val priorityQueue = new mutablePriorityQueue[Int]()(Ordering.by(i => nums(i)))
    var maximumIndex = -1

    // initialize the priority queue
    for (i <- 0 until k) {
      priorityQueue.enqueue(i)
    }
    maximumIndex = priorityQueue.dequeue()

    def cmpMaxIndexAndEnqueueSmallerOne(i: Int): Unit = {
      if (nums(i) > nums(maximumIndex)) {
        priorityQueue.enqueue(maximumIndex)
        maximumIndex = i
      } else {
        priorityQueue.enqueue(i)
      }
    }

    def findMaxOfRange(s: Int, e: Int): Int = {
      if (maximumIndex < s) { // update maxIndex on need (current maximum index invalided)
        if (priorityQueue.isEmpty) {
          maximumIndex = e
          return maximumIndex
        }

        var lastMaxIndex = priorityQueue.dequeue()
        while (lastMaxIndex < s && priorityQueue.nonEmpty) {
          lastMaxIndex = priorityQueue.dequeue()
        }
        maximumIndex = lastMaxIndex
        if (maximumIndex >= s) {
          cmpMaxIndexAndEnqueueSmallerOne(e)
        } else {
          maximumIndex = e
        }
      } else { // Handling new sliding window elements (elem at the right most of slide)
        cmpMaxIndexAndEnqueueSmallerOne(e)
      }
      maximumIndex
    }

    val r = k until nums.length
    val result = new Array[Int](r.size + 1)

    result(0) = nums(maximumIndex)
    var i = 1
    for (j <- r) {
      result(i) = nums(findMaxOfRange(j - k + 1, j))
      i = i + 1
    }
    result
  }
}
