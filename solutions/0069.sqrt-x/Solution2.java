class Solution {
    public int mySqrt(int x) {
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
