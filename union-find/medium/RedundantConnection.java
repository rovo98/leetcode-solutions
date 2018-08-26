package UnionFind.Medium;

/**
 * Problem: Acceptance: 42.5%
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1,2, .., N),
 * with one additional edge added. The added edge has two different vertices chosen from 1
 * to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v]
 * with u < v, that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If
 * there are multiple answers, return the answer that occurs last in the given 2D-array.
 * The answer edge [u,v] should be in the same format, with u < v.
 *
 * Example 1:
 *
 * Input : [[1, 2], [1, 3], [2, 3]]
 * Output: [2, 3]
 *
 * Explanation: The given undirected graph will be like this:
 *   1
 *  /  \
 * 2 -  3
 *
 * Example 2:
 *
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1, 4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 *
 *
 *  Note :
 *      1. The size of the input 2D-array will be between 3 and 1000.
 *      2. Every integer represented in the 2D-array will be between 1 and N,
 *      where N is the size of the input array.
 *
 * @author rovo98
 * Date: 25/2/2018
 */
public class RedundantConnection {
    // Solution one: ^
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
        int[] redundantEdge = new int[2];

        for (int[] edge : edges) {
            if (connected(parent, edge[0]-1, edge[1]-1)) {
                redundantEdge[0] = edge[0];
                redundantEdge[1] = edge[1];
            } else {
                union(parent, rank, edge[0]-1, edge[1]-1);
            }
        }
        return redundantEdge;
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


    // Driver the program to test the method above.
    public static void main(String[] args) {
        RedundantConnection rc = new RedundantConnection();
        int[][] testEdges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] testEdges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println("The input test edges1 is the following:");
        for (int[] edge : testEdges1) {
            System.out.print("[" + edge[0] + ", " + edge[1] + "] ");
        }
        System.out.println();
        int[] result1 = rc.findRedundantConnection(testEdges1);
        System.out.println("And the result of it is [" + result1[0] + ", " + result1[1] + "].");
        System.out.println("The input test edges2 is the following:");
        for (int[] edge : testEdges2) {
            System.out.print("[" + edge[0] + ", " + edge[1] + "] ");
        }
        System.out.println();
        int[] result2 = rc.findRedundantConnection(testEdges2);
        System.out.println("And the result of it is [" + result2[0] + ", " + result2[1] + "].");
    }
}
