import java.util.*;

public class Solution1 {
    /**
     * Simple approach: using a list to simulating the items adding process.
     * suppose newInterval: [x, y], for iv in intervals:
     * case 1:  iv[1] lt x;
     * case 2: iv[0] gt y;
     * case 3: update newInterval:
     *      x = min(x, iv[0]);
     *      y = max(y, iv[1]);
     *
     * Complexity Analysis:
     * Time complexity: O(n)
     * Space compleixty: O(n)
     *
     * @author rovo98
     * */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // base cases
        if (intervals == null || intervals.length == 0)
            return new int[][] {newInterval};
        List<int[]> list = new LinkedList<>();
        boolean added = false;
        int[] addIv = newInterval;

        for (int[] iv : intervals) {
            if (added)
                list.add(iv);
            else {
                if (addIv[1] < iv[0]) {
                    list.add(addIv);
                    added = true;
                    list.add(iv);
                } else if (addIv[0] > iv[1]) {
                    list.add(iv);
                } else {
                    addIv[0] = Math.min(addIv[0], iv[0]);
                    addIv[1] = Math.max(addIv[1], iv[1]);
                }
            }
        }
        if (!added)
            list.add(addIv);

        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        list = null;

        return res;
    }
}
