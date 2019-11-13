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
