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

## Official or Others Solutions

### Solution 1

递归方式，为了解决这个问题，我们需要理解”什么是中位数？“，在统计学中，中位数是用于将一个集合划分成两个长度相等的子集的，其中一个子集总是大于另一个子集。

如果我们理解了中位数的用法，那么我们就很接近答案了，首先，我们根据一个随机位置 ``i`` 将集合 ``A`` 分成两个部分：

```txt
left_A      |   right_A
A[0],A[1], ..,A[i-1] | A[i], A[i+1], ....,A[m-1]
```

因为 ``A`` 有 ``m`` 个元素，所以我们有 ``m+1`` 种划分方案  (``i = 0 ~ m``)。

我们知道:

```txt
len(left_A) i, len(right_A) = m - i,
注意： 当 i = 0时，left_A 为空，i = m 时，right_A 为空。
```

使用同样的方式，我们可以将 ``B`` 按照位置 ``j`` 进行划分：

```txt
    left_B | right_B
B[0], B[1], ..., B[j-1] | B[j], B[j+1], ..., B[n-1]
```

将 ``left_A`` 和 ``left_B`` 放入一个集合里面，将 ``right_A`` 和 ``right_B`` 放入一个集合里面，然后分别命名为 ``left_part`` 和 ``right_part``。

```txt
    left_part | right_part
A[0], A[1], ..,A[i-1] | A[i], A[i+1], ..., A[m-1]
B[0], B[1],...,B[j-1] | B[j], B[j+1], ..., B[n-1]
```

如果我们能够确保:

```txt
1. len(left_part) = len(right_part)
2. max(left_part) <= min(right_part)
```

那么将能将集合 ${A, B}$ 划分成两个长度相等的部分，确保一个部分总是大于另一个部分。则 median （中位数）= $\frac{max(left_part) + min(right_part)}{2}$

要满足以上的两个条件，我们只需要满足:

```txt
1. i + j = m - i + n - j (或者: m - i + n -j +1), 如果 n >= m, 只需要令 i = 0 ~ m, j = (m+n+1) / 2 - i
2. B[j-1] <= A[i] 以及 A[i-1] <= B[j]
```

::: tip ps
1. 为了简单起见，我们假设 A[i-1], B[j-1] A[i], B[j] 总是合法，即便是 ``i=0``, ``i=m``, ``j=0``, 或者 ``j=m``的情况下，我们稍后再讨论关于边界处理的问题。
2. 为什么令 ``n>=m``? 因为需要确保 ``j`` 为一个非负数 (0 <= i <=m, j = (m+n+1)/2 - i)
:::

所以我们要做的就是:

:::tip info
在 [0, m]的区间着搜索 i, 满足 B[j-1] <= A[i] 以及 A[i-1] <= B[j], j = (m+n+1) / 2 - i

同时，我们可以使用 binarySearch 二分查找来处理:
1. 令 ``imin = 0``, ``imax=m``, 然后开始搜索 [imin, imax]
2. 令 i = (imin+imax) / 2, j = (m+n+1) / 2 - i
3. 此时，我们已经确保了 len(left_part) = len(right_part), 接下来，我们可能会遇到以下三种情况:
- B[j-1] < A[i] 且 A[i-1] < B[j], 中位数已找到，停止搜索
- B[j-1] > A[i], 此时，A[i]太小了，需要增加 i 来继续搜索， 令 imin = i+1, 回到步骤 2
- A[i-1] > B[j], 此时，B[j]太小，需要增加 j (减小 i)才能继续搜索，令 imax= i-1, 回到步骤 2
:::

当 ``i`` 找到时，中位数为:

1. 如果 m+n 为奇数，则 max(A[i-1], B[j-1])
2. 如果 m+n 为偶数，则 max(A[i-1], B[j-1] + min(A[i], B[j]))

## Summary

