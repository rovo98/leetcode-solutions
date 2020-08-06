# 0739.Daily Temperatures

## Description

Given a list of daily temperatures ``T``, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put ``0`` instead.

For example, given the list of temperatures ``T = [73, 74, 75, 71, 69, 72, 76, 73]``, your output should be ``[1, 1, 4, 2, 1, 1, 0, 0]``.

 
**Note**

The length of temperatures will be in the range ``[1, 30000]``. Each temperature will be an integer in the range ``[30, 100]``.

**Links**

[(en)https://leetcode.com/problems/daily-temperatures/](https://leetcode.com/problems/daily-temperatures/)
<br />
[(中文)https://leetcode-cn.com/problems/](https://leetcode-cn.com/problems/daily-temperatures/)

## Solutions

### Solution1

由于问题相对比较简单，可以直接用暴力法 (brute-force) 来进行处理，即对于每一个温度 ``T[i]``， 去遍历剩下的 ``T.length - i`` 个元素，看是否有符合
升温条件的温度，若存在则更新相应结果。

```java
/**
brute-force approach:
        time complexity: O(n^2)
        space complexity: O(n)
*/
public int[] dailyTemperatures(int[] T) {
    int[] result = new int[T.length];
    
    for (int i = 0; i < T.length; i++) {
        for (int j = i+1; j < T.length; j++) {
            if (T[j] > T[i]) {
                result[i] = j - i;
                break;
            }
        }
    }
    return result;
}
```

**Submission status**

因为是 brute-force 方法，时间复杂度为 $O(n^2)$，其运行时间为 718 ms，击败 15.05%。效果不是很好，我们应该进一步进行优化。

### Solution2



## Summary

