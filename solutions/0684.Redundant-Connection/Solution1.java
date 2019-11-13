class Solution  {
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
}
