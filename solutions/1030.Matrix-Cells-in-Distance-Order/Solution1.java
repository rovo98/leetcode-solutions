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
                /* if (i == 0 && j == 0) continue; */
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
