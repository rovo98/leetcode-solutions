package com.rovo98.sgs.sorting

import java.io.{DataInputStream, DataOutputStream, EOFException, File, FileInputStream, FileOutputStream}
import java.nio.file.Files
import java.util.UUID

import scala.collection.mutable.ArrayBuffer

/**
 * External sorting can handle massive amounts of data.
 *
 * External sorting is required when the data being sorted do not
 * fit into the main memory of a computing device (usually RAM), and they
 * must reside in the slower external memory (usually a hard drive).
 *
 * External sorting typically uses a hybrid sort-merge strategy.
 *
 * sorting phase:
 *  - chunks of data small enough to fit in the main memory are read, sorted
 *  - written out to a temp file
 *    merging phase:
 *  - combining the sorted sub-files into a single large file
 */
class ReplacementSelection(private val inputFile: String,
                           private val outputFile: String,
                           private val runSize: Int,
                           private val numWays: Int) {
  // preconditions checking
  require(inputFile != null)
  require(outputFile != null)
  require(runSize > 1000)
  require(numWays > 1)

  private val TMP_DIR_NAME = "t_rs_sorting"
  private val TMP_CHUNK_FILE_NAME_PREFIX = "tmp_chunk"
  private var TMP_CHUNK_FILE_UID: String = _

  // initialization -> called on every sorting running
  private def initialization(): Unit = {
    this.TMP_CHUNK_FILE_UID = UUID.randomUUID().toString
    Files.createTempDirectory(TMP_DIR_NAME)
    this.createInitialRuns()
  }

  // returns the tmp chunk filename of given index
  private def getTmpChunkFileName(index: Int): String = {
    if (index > numWays) throw new IllegalArgumentException("Given chunk file index is invalid!")
    TMP_DIR_NAME + File.pathSeparator + TMP_CHUNK_FILE_NAME_PREFIX + TMP_CHUNK_FILE_UID + index
  }

  private def createInitialRuns(): Unit = {
    val dis: DataInputStream = new DataInputStream(new FileInputStream(inputFile))
    val outs: Array[DataOutputStream] = new Array[DataOutputStream](numWays)
    for (i <- 0 until numWays) {
      outs(i) = new DataOutputStream(new FileOutputStream(getTmpChunkFileName(i)))
    }
    val arr: ArrayBuffer[Int] = new ArrayBuffer[Int](runSize)
    var nextOutputFile = 0
    var moreInput = true

    var filled = 0
    while (moreInput) {
      // write runSize elements into arr from input file
      try {
        for (i <- 0 until runSize) {
          arr(i) = dis.readInt()
          filled = i
        }
      } catch {
        case _: EOFException =>
          moreInput = false
      }
      // sort array using merge sort
      mergeSort(arr, 0, filled)

      // write the records to the appropriate temp output file
      // can't assume that the loop above runs to runSize
      // since the last run's length may be less than runSize
      for (j <- 0 to filled) {
        outs(nextOutputFile).writeInt(arr(j))
      }
      nextOutputFile = nextOutputFile + 1
    }
    // close the input and output files
    for (i <- 0 until numWays) {
      outs(i).close()
    }
    dis.close()
  }

  private def mergeSort(arr: ArrayBuffer[Int], l: Int, r: Int): Unit = {
    if (l < r) {
      // Same as (l+r) / 2, but avoids overflow for large l and h
      val m = l + (r - l) / 2;

      mergeSort(arr, l, m)
      mergeSort(arr, m + 1, r)
      merge(arr, l, m, r);
    }
  }

  private def merge(arr: ArrayBuffer[Int], l: Int, m: Int, r: Int): Unit = {
    val n1 = m - l + 1
    val n2 = r - m
    // create temporary arrays
    val t1: ArrayBuffer[Int] = new ArrayBuffer[Int](n1)
    val t2: ArrayBuffer[Int] = new ArrayBuffer[Int](n2)

    // copy data to t1 and t2
    for (i <- 0 until n1) {
      t1(i) = arr(l + i)
    }
    for (i <- 0 until n2) {
      t2(i) = arr(m + 1 + i)
    }

    // merge the temp arrays back to arr[l..r]
    var i = 0
    var j = 0
    // Initial index of merged subarray
    var k = l
    while (i < n1 && j < n2) {
      if (t1(i) <= t2(j)) {
        arr(k) = t1(i)
        i = i + 1
      } else {
        arr(k) = t2(j)
        j = j + 1
      }
      k = k + 1
    }

    val copyRemainElements = (arr: ArrayBuffer[Int], i: Int, k: Int, len: Int) => {
      var vi = i
      var vk = k
      while (vi < len) {
        arr(vk) = t1(vi)
        vk = vk + 1
        vi = vi + 1
      }
    }
    // copy the remaining elements of t1
    // if there are any
    copyRemainElements(arr, i, k, n1)

    // copy the remaining elements of t2
    // if there are any
    copyRemainElements(arr, j, k, n2)
  }

  // merge k files (chunks)
  private def mergeFiles(): Unit = ???

  /**
   * Trigger the external sorting process.
   */
  def sort(): Unit = {
    this.initialization()
    // todo: implementation

    // do clean up staff
    this.destroy()
  }

  private def destroy(): Unit = {
    // delete the temp chunk files. -- might set as configurable
  }
}

object ReplacementSelection {
  /**
   * @param inputFile  name of input file. e.g input.txt
   * @param outputFile name of output file. e.g. output.txt
   * @param runSize    Size of a run (can fit in RAM)
   * @param numWays    Number of runs to be merged
   */
  def apply(inputFile: String, outputFile: String, runSize: Int, numWays: Int): ReplacementSelection =
    new ReplacementSelection(inputFile, outputFile, runSize, numWays)
}

/**
 *
 * @param element The element to be sorted
 * @param i       index of the array from which the element is taken
 */
case class MinHeapNode(element: Int, i: Int)

/**
 *
 * @param harr     array of elements in heap
 * @param heapSize size of the min heap
 */
class MinHeap(
               private val harr: ArrayBuffer[MinHeapNode],
               private val heapSize: Int
             ) {

  // preconditions
  require(harr != null)
  require(heapSize > 2)
  assert(harr.nonEmpty)

  // build a heap from a given array of given size
  {
    var i = (heapSize - 1) / 2
    while (i >= 0) {
      this.heapify(i)
      i = i - 1
    }
  }

  /**
   * to heapify a subtree with root at given index
   */
  def heapify(index: Int):Unit = {
    val l = left(index)
    val r = right(index)
    var smallest = index
    if (l < heapSize && harr(l).element < harr(index).element) {
      smallest = l
    }
    if (r < heapSize && harr(r).element < harr(smallest).element) {
      smallest = r
    }
    if (smallest != index) {
      swap(harr, index, smallest)
      heapify(smallest)
    }
  }

  private def swap[T](arr: ArrayBuffer[T], x: Int, y: Int): Unit = {
    val temp = arr(x)
    arr(x) = arr(y)
    arr(y) = temp
  }

  /**
   * to get the index of left child of node at index i
   */
  def left(i: Int): Int = 2 * i + 1

  /**
   * to get the index of right child of node at index i
   */
  def right(i: Int): Int = 2 * i + 2

  /**
   * to get the root
   */
  def getMin: MinHeapNode = harr(0)

  /**
   * to replace root with new node x
   * and heapify() new root
   */
  def replaceMin(x: MinHeapNode): Unit = {
    harr(0) = x
    this.heapify(0)
  }
}
