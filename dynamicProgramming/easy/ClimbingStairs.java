package DynamicProgramming.Easy;

/**
 * Problem: Acceptance: 40.9%
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways you climb to the
 * top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 *
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 *
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 2. 2 steps + 1 step
 *
 * @author rovo98
 * date: 2018.5.14
 */
public class ClimbingStairs {
    // Solution one: ^
    // Recursive way.
    /*
    Complexity Analysis:
    Time complexity: O(log n)
    Space complexity: O(1)
     */
    private int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n-1) + climbStairs(n-2);
    }
    // Solution two: ^
    /*
    Complexity Analysis:
    Time complexity: O(n)
    Space complexity: O(1)
     */
    private int climbStairsDP(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        // fill the dp table.
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }

    // Driver the program to test the method above
    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int testTop = 10;
        System.out.println("The ways to climb to the top of " + testTop + " is "
                + cs.climbStairs(testTop) + ".");
        System.out.println("The ways to climb to the top of " + testTop + "(DP) is "
                + cs.climbStairsDP(testTop) + ".");
    }
}
