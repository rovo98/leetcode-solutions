# 4. Median of Two Sorted Arrays

## Description

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

**Example 1:**
```txt
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
```

**Example 2:**

```txt
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```

[(en)https://leetcode.com/problems/median-of-two-sorted-arrays/](https://leetcode.com/problems/median-of-two-sorted-arrays/)
<br />
[(中文)https://leetcode-cn.com/problems/median-of-two-sorted-arrays/](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)

## Solutions

### Solution1

由于在做题时，实在没有想到什么高效的解法，因此，直接使用归并排序 (``MergeSort``) 中归并的想法。将两个已排序数组归并起来，然后再取中间值。

```java
/*
   Complexity Analysis:
   Time complexity: O(m +n )
   Space complexity: O(m + n)
   */
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // using the idea of mergeSort
    int m = nums1.length;
    int n = nums2.length;

    int[] merged = new int[m + n];

    int left = 0, right = 0;
    for (int i = 0; i < merged.length; i++) {
        if (left >= m) // no elements left in nums1
            merged[i] = nums2[right++];
        else if (right >= n) // no elements left in nums2
            merged[i] = nums1[left++];
        else if (nums1[left] < nums2[right])
            merged[i] = nums1[left++];
        else
            merged[i] = nums2[right++];
    }
    // if only one element in the merged array.
    if (merged.length == 1)
        return merged[0];

    int mid = merged.length / 2;
    return merged.length % 2 == 0 ? (double)(merged[mid]+merged[mid-1]) /2: (double)(merged[mid]);
}
```

**Submission status**

果然，提交完之后，发现击败 $4.56%$ 的人而已，运行时间 32 ms。

## Summary

