package BinarySearch.Easy;

/**
 * Problem: Acceptance: 36.4%
 *
 * You have a total of n coins that you want to form in a staircase shape, where every
 * k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 * n = 5
 *
 * The coins can form the following rows:
 * c
 * c c
 * c c
 *
 * Because the 3rd row is incomplete, we return 2.
 *
 * Example 2:
 * n = 8
 *
 * The coins can form the following rows:
 * c
 * c c
 * c c c
 * c c
 *
 * Because the 4th row is incomplete, we return 3.
 *
 * @author rovo98
 * Date: 2/3/2018
 */
public class ArrangingCoins {
    // Solution one: ^&
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(1).
     */
    public int arrangeCoins(int n) {
        int level = 1;
        while (n > 0) {
            n -= level;
            level++;
        }
        return n == 0 ? level - 1 : level -2;
    }
    // Solution two : &^
    // using binarySearch
    /*
    Complexity Analysis:
        Time complexity: O(log n).
        Space complexity:O(1).
     */
    public int arrangeCoinsVersionTwo(int n) {
        int lo = 0;
        int hi = n;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            long x = m * (m + 1L) / 2;
            if (x == n) {
                return m;
            } else if (x > n) {
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }
        return hi;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        ArrangingCoins ac = new ArrangingCoins();
        System.out.println("The result for 8 is " + ac.arrangeCoins(8) + ".");
        System.out.println("The result for 100 is " + ac.arrangeCoinsVersionTwo(100) + ".");
    }
}
