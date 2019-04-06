class Solution {
    /**
     * Complexity Analysis:
     * TC: O(log(x)), since log_10(x) is O(log n)
     * SC: O(1)
     *
     * */
    public int reverse(int x) {
        long rev = 0; // declare as long type to avoid overflow checking

        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // overflow checking
        if (rev >= Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
            return 0;

        return (int) rev;
    }
}
