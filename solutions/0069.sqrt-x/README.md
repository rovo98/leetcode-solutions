# 69. Sqrt(x)

## Description

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.


**Example 1:**
```txt
Input: 4
Output: 2
```

**Example 2:**
```txt
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```

### Links

[(en)https://leetcode.com/problems/sqrtx](https://leetcode.com/problems/sqrtx)
<br />
[(中文)https://leetcode-cn.com/problems/sqrtx](https://leetcode-cn.com/problems/sqrtx)

## 解题思路

### Solution 1

二分查找的方式，从区间 [1, x] 找寻目标，计算平方，并和目标值进行比较，在误差允许范围内，则算找到了解。（x 是需要开方的目标）

> Complexity Analysis:
>   time complexity: O(log n) 但其中每次均需要做乘法运算，以及浮点数比较
>   Space complexity: O(1)

#### Java Code 

```java
class Solution {
    /*
    Binary Search approach
    TC: O(log n)
    SC: O(1)
    */
    public int mySqrt(int x) {
        if (x < 0) throw new IllegalArgumentException();
        if (x == 0)  return 0;
        if (x == 1)  return 1;
        
        double lo = 0, hi = x;
        while (lo <= hi) {
            double mid = lo + (hi - lo) / 2;
            double r = mid * mid;
            if (r > x && r - x < 0.001f)
                return (int) mid;
            else if (r > x)
                hi = mid;
            else
                lo = mid;
        }
        return (int) lo;
    }
}
```

#### Submission status

果然运行效果非常不佳，时间 1028 ms, 所用的内存  26.8 M。

### Solution 2

使用牛顿迭代法，即设 $y = x^2 - n$，令该方程有解即可。如果设它的解为 $(x_0, y_0)$, 其切线方程过 x 轴的横坐标为 $x_{t}$。则我们可以从横坐标 $x_i = 1$ 开始，不断地作 $(x_i, f(x_i))$ 的切线，得到相应的横坐标。如果：

> 切线方程的推倒这里就省略了，也相对简单。求导，代入点坐标，然后令纵坐标为 0 即可得到。

1. 该横坐标的平方与目标值在误差内，就算是得到了我们需要的解;
2. 当前横坐标与上一次得到的横坐标无限接近（相等）。

Complexity Analysis:
- Time complexity: O(1), 牛顿迭代法，迭代的次数是常数次的。
- Space complexity: O(1)

#### Java Code

很明显使用上面的方案 2 能够更快地得到结果。

```java
// best approach
class Solution {
    pubic int mySqrt(int x) {
        if (x < 0) throw IllegalArgumentException();
        if (x == 0) return 0;
        double last = 0;
        double res = 1;
        while (last != res) {
            last = res;
            res  = 0.5 * (res + x / res);
        }
        return (int) res;
    }
}
```

```java
// another approach
class Solution {
    public int mySqrt(int x) {
        if (x < 0) throw IllegalArgumentException();
        if (x == 0) return 0;
        double res = x / 2;
        while (res * res - x > 0.1f) {
            res = 0.5 * (res + x / res);
        }
        return (int) res;
    }
}
```

#### Submission status

方案一: 时间 19 ms, 27.1 M, 方案二: 时间 1 ms, 33.6 MB。


