package BinarySearch.Easy;

/**
 * Problem: Acceptance: 28.6%
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * x is guaranteed to be a non-negative integer.
 *
 * Example 1:
 * Input: 4
 * Output: 2
 *
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation:
 * The square root of 8 is 2.82.8443..., and since we want to return an integer, the
 * decimal part will be truncated.
 *
 * @author rovo98
 * Date: 24/2/2018
 */
public class SqrtX {
    // Solution one: ^
    /*
    Complexity Analysis:
        Time complexity: O(log n).
        Space complexity: O(1).
     */
    public int mySqrt(int x) {
        int lo = 0;
        int hi = x-1;

        int s = 1;
        while (lo <= hi) {
            s = lo + (hi - lo) / 2;
            if ((s * s) == x) {
                return s;
            } else if ((s * s) < x) {
                lo = s + 1;
            } else {
                hi = s - 1;
            }
        }
        return s;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        SqrtX s = new SqrtX();
        System.out.println("The square root of 8 is " + s.mySqrt(8) + ".");
        System.out.println("The square root of 9 is " + s.mySqrt(9) + ".");
        System.out.println("And the square root of 25 is " + s.mySqrt(25) + ".");
    }
}
