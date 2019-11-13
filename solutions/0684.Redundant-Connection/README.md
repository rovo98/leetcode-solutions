# 0684.Redundant Connection

## Description

In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

**Example 1:**
```txt
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
```
**Example 2:**
```txt
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
```
**Note**

1. The size of the input 2D-array will be between 3 and 1000.
2. Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

**Links**

[(en)https://leetcode.com/problems/redundant-connection/](https://leetcode.com/problems/redundant-connection/)
<br />
[(中文)https://leetcode-cn.com/problems/redundant-connection/](https://leetcode-cn.com/problems/redundant-connection/)

## Solutions

### Solution1

解法，使用 DisjoinSet 并查集实现的 Union-Find 来判断一个图是否连通。

```java
/*
   Complexity Analysis:
   Time complexity: O(n).
   Space complexity: O(n).
   */
public int[] findRedundantConnection(int[][] edges) {
    int[] parent = new int[edges.length];
    byte[] rank = new byte[edges.length];

    for (int i = 0; i < edges.length; i++) {
        parent[i] = i;
        rank[i] = 0;
    }
    for (int[] edge : edges) {
        if (connected(parent, edge[0]-1, edge[1]-1)) {
            return edge;
        } else {
            union(parent, rank, edge[0]-1, edge[1]-1);
        }
    }
    return null;
}

/**
 * Returns the component identifier of the component containing site {@code p}.
 *
 * @param parent the root array of sites.
 * @param p the integer representing one site.
 * @return the component identifier of the component containing site {@code p}.
 */
private int find(int[] parent, int p) {
    while (p != parent[p]) {
        parent[p] = parent[parent[p]];
        p = parent[p];
    }
    return p;
}

/**
 * Returns true if two sites are in the same component.
 * @param parent the root array of sites.
 * @param p the integer representing one site.
 * @param q the integer representing another site.
 * @return  {@code true} if two sites are in the same component;
 *          {@code false} otherwise.
 */
private boolean connected(int[] parent, int p, int q) {
    return find(parent, p) == find(parent, q);
}

/**
 * Merges the component containing site {@code p} with the component containing site {@code q}.
 *
 * @param parent the root array of sites.
 * @param rank   the rank of each site.
 * @param p the integer representing one site.
 * @param q the integer representing another site.
 */
private void union(int[] parent, byte[] rank, int p, int q) {
    int rootP = find(parent, p);
    int rootQ = find(parent, q);
    if (rootP == rootQ) {
        return;
    }
    // Always make the lower height tree to the higher tree.
    if (rank[rootP] > rank[rootQ]) {
        parent[rootQ] = rootP;
    } else if (rank[rootP] < rank[rootQ]) {
        parent[rootP] = rootQ;
    }else {
        parent[rootQ] = rootP;
        rank[rootP]++;
    }
}
```

**Submission status**

提交的代码，运行时间 1 ms, 击败 78.35%。

