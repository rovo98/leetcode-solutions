# 0441. Arranging Coins

## Description

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

**Example 1:**
```txt
n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
```

**Example 2:**
```txt
n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
```

**Links**

[(en)https://leetcode.com/problems/arranging-coins/](https://leetcode.com/problems/arranging-coins/)
<br />
[(中文)https://leetcode-cn.com/problems/arranging-coins/](https://leetcode-cn.com/problems/arranging-coins/)

## Solutions

### Solution1

Brute-force 方式，最直接地，从 ``1`` 开始遍历，然后让 ``n`` 依次减去当前遍历值，直到 ``n`` 无法再继续减下一个值。则当前值为最大层数。

```java
class Solution {
    /**
        Time complexity: O(n)
        Space complexity: O(1)
    */
    public int arrangeCoins(int n) {
        for (int i = 1; i < n; i++) {
            if (n < i) return i - 1;
            n -= i;
        }
        return -1; // this return statement will not be reached.
    }
}
```

**Submission status**

### Solution 2

利用等差数列的特性，配合二分查找思路，来确定最大的可取层数值。

```java
class Solution {
    /**
        Approach two: using binary search
        Time complexity: O(log n)
        Space complexity: O(1)
    */
    public int arrangeCoins(int n) {
        // base cases
        if (n == 0) return 0;
        if (n <= 2) return 1;
        
        int lo = 1;
        int hi = n;
        // optimation is needed
            
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sum = (mid * (mid + 1)) / 2;
            if (sum > n) 
                hi =(int) mid - 1;
            else if ( sum < n) 
                lo = (int) mid + 1;
            else
                return (int) mid;
        }
        return hi;
    }
}
```

当然，该解决方案，如果能够在执行二分查找之前，有效地将 ``hi`` 的取值提前先尽量地变小，那么算法的效率可能会更高一点。

**Submission status**

## Summary

