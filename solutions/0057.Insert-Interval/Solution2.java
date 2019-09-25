
public class Solution2 {
    /**
     * Using the idea of quickSort
     * Complexity Analysis: 
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * @author rovo98
     *
     * learning from ots.
     * */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // base cases
        if (intervals == null || intervals.length == 0)
            return new int[][] {newInterval};
        int n = intervals.length;
        int l = 0, r = n - 1;

        while (l < n && newInterval[0] > intervals[l][1])
            l++;
        while (r >= 0 && newInterval[1] < intervals[r][0])
            r--;

        int[][] res = new int[n - (r-l)][2];
        for (int i = 0; i < l; i++)
            res[i] = intervals[i];
        if (l < n)
            newInterval[0] = Math.min(newInterval[0], intervals[l][0]);
        if (r >= 0)
            newInterval[1] = Math.max(newInterval[1], intervals[r][1]);

        for (int i = r+1; i < n; i++)
            res[++l] = intervals[i];

        return res;
    }
}
