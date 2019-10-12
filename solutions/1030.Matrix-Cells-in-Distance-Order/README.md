# 1030. Matrix Cells in Distance Order

## Description

We are given a matrix with ``R`` rows and ``C`` columns has cells with integer coordinates ``(r, c)``, where ``0 <= r < R`` and ``0 <= c < C``.

Additionally, we are given a cell in that matrix with coordinates (r0, c0).

Return the coordinates of all cells in the matrix, sorted by their distance from ``(r0, c0)`` from smallest distance to largest distance.  Here, the distance between two cells ``(r1, c1)`` and ``(r2, c2)`` is the Manhattan distance, ``|r1 - r2| + |c1 - c2|``.  (You may return the answer in any order that satisfies this condition.)


**Example 1:**
```txt
Input: R = 1, C = 2, r0 = 0, c0 = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (r0, c0) to other cells are: [0,1]
```

**Example 2:**
```txt
Input: R = 2, C = 2, r0 = 0, c0 = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
```
**Example 3:**
```txt
Input: R = 2, C = 3, r0 = 1, c0 = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
```

### Note

1. 1 <= R <= 100
2. 1 <= C <= 100
3. 0 <= r0 < R
4. 0 <= c0 < C

### Links

[(en)https://leetcode.com/problems/matrix-cells-in-distance-order/](https://leetcode.com/problems/matrix-cells-in-distance-order)
<br />
[(中文)https://leetcode-cn.com/problems/matrix-cells-in-distance-order](https://leetcode-cn.com/problems/matrix-cells-in-distance-order)

## 解题思路

### Solution 1

由题意是根据给定的矩阵以及点，使用曼哈顿距离来计算点到点的距离。

最直观以及容易想到的方法是，brute-force 两层循环以遍历每个点，然后使用插入排序的思想，假设第一个点是已排好序的部分；则不断比较接下来的所有点，插入到已排序部分即可。

Complexity Analysis:
- Time complexity: $O(n^2)$
- Space complexity: $O(1)$

#### Java Code 

下面的代码存在许多的问题，例如我是在最内层循环中来判断是否是第一个点 ``(0,0)``的，这意味着每次迭代都需要进行一次判断。


```java
class Solution {
    /**
    using the idea of Insertion Sort
    Complexity Analysis:
        TC: O(n^2)
        SC: O(1)
    */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int num = R * C;
        int[][] result = new int[num][2];
        
        //System.out.println(Arrays.deepToString(result));
        // suppose the (0, 0) is the first in the sorted part.
        int inserted = 1;
        for (int i = 0; i < R; i++) {
            int j = i == 0 ? 1 : 0;
            for (; j < C; j++) {
            //    if (i == 0 && j == 0) continue;
                int p = inserted;
                while (--p >= 0 && md(result[p][0], result[p][1], r0, c0) - md(i, j, r0, c0) > 0) {
                    result[p+1][0] = result[p][0];
                    result[p+1][1] = result[p][1];
                }
                // insert the new point to the sorted part.
                result[p+1][0] = i;
                result[p+1][1] = j;
                inserted++;
            }
        }
        //System.out.println(Arrays.deepToString(result));
        return result;
    }
    // return manhattan distance of two points.
    private int md(int i, int j, int e, int f) {
        return Math.abs(i - e) + Math.abs(j - f);
    }
}
```

#### Submission status

果不其然，性能非常地差。

![submission-status](../../images/1030.matrix-cells-in-distance-order.png)


