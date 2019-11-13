# 0561. Array Partition I

## Description

Given an array of ``2n`` integers, your task is to group these integers into ``n`` pairs of integer, say ``(a1, b1)``,
 ``(a2, b2)``, ..., ``(an, bn)`` which makes sum of ``min(ai, bi)`` for all ``i`` from ``1`` to ``n`` as large as possible.

**Example:**

```txt
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
```
 
**Note**

1. ``n`` is a positive integer, which is in the range of [1, 10000].
2. All the integers in the array will be in the range of [-10000, 10000].

**Links**

[(en)https://leetcode.com/problems/array-partition-i/](https://leetcode.com/problems/array-partition-i/)
<br />
[(中文)https://leetcode-cn.com/problems/array-partition-i/](https://leetcode-cn.com/problems/array-partition-i/)

## Solutions

### Solution1

题目要求，将给定数组中的元素组成对，再取所有对中的较小值，进行累加。得到结果。

实际上，将给定数组排好序，之后取所有奇数位置的元素，进行累加，即可。

> 因此，我想到的解法的重点将放在如何将数组进行排序上面。下面的解法 1，是使用传统的基于比较的排序算法，时间复杂度为 $O(n log n)$。

```java
/**
 * Complexity Analysis: 
 *  Time complexity: O(n log n)
 *  Space complexity: O(1)
 * */
public int arrayPairSum(int[] nums) {
    //sort the input array first, then add up all the elements which have the even index.
    int sum = 0;

    // using shell sort or merge sort here.
    /*
    int n = nums.length;
    int h = 1;
    while (h < n/3) {
        h = 3 * h + 1; // 1, 4, 13, 40, 121, ...
    }
    while (h >= 1) {
        for (int i = h; i < n; i++) {
            int key = nums[i];
            int j;
            for (j = i-h; j >= 0 && key < nums[j]; j -= h) {
                nums[j+h] = nums[j];
            }
            nums[j+h] = key;
        }
        h /= 3;
    }
    */
    Arrays.sort(nums);
    // add up all the even elements
    for (int i=0; i<nums.length; i+=2) {
        sum += nums[i];
    }
    return sum;
}
```
**Submission status**

提交代码的运行时间 32 ms。

#### Solution 2

由于我能想到的方式是基于排序算法的，所以，很容易结合题目给出的限制条件，使用空间换时间的想法，利用桶排序 (buketSort)来对给定数组进行排序。

> 下面给出的解法，是将 ``[-10000, 10000]`` 中的负数范围通过 ``+10000`` 的方式映射到正数区间上，然后在对桶进行标记的同时，记录最小值和最大值出现的位置，来确定之后遍历的范围。
> 进一步提高遍历的效率。

```java
// using the idea of the bucketSort
/*
Complexity Analysis:
    Time complexity: O(n)
    Space complexity: O(n)
 */
public int arrayPairSum(int[] nums) {

    if (nums.length % 2 != 0)
        throw new IllegalArgumentException();

    int[] bucket = new int[20001];
    int maxElemt = Integer.MIN_VALUE;
    int minElemt = Integer.MAX_VALUE;

    for (int num : nums) {
        bucket[num + 10000]++;
        if (num > maxElemt)
            maxElemt = num;
        if (num < minElemt)
            minElemt = num;
    }

    int result = 0;
    minElemt += 10000;  // offset is 10000
    maxElemt += 10000;
    boolean isOdd = true;
    for (int i = minElemt; i <= maxElemt; i++) {
        if (bucket[i] > 0) {
            for (int j = 0; j < bucket[i]; j++) {
                if (isOdd)
                    result += (i - 10000);
                isOdd = !isOdd;
            }
        }
    }
    return result;
}
```

## Summary

在得到解的情况下，对于个给定的题目，还可以结合其限制条件，对已有的解决方案进行优化。🤔

