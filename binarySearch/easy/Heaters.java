package BinarySearch.Easy;

/**
 * Problem: Acceptance: 29.6%
 *
 * Winter is coming! Your first job during the contest is to design a standard heater
 * with fixed warm radius to warm all the houses.
 *
 * Now, you are given positions of houses and heaters on a horizontal line, find out
 * minimum radius of heaters so that all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters separately, and your expected output
 * will be the minimum radius standard of heaters.
 *
 * Note:
 *   1. Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 *   2. Positions of houses and heaters you are given are non-negative and will not exceed
 *      10^9.
 *   3. As long as a house is in the heaters' warm radius range, it can be warmed.
 *   4. All the heaters follow your radius standard and the warm radius will the same.
 *
 *
 * Example 1:
 * Input: [1, 2, 3], [2]
 * Output: 1
 * Explanation:
 * The only heater was placed in the position 2, and if we use the radius 1 standard,
 * then all the houses can be warmed.
 *
 * Example 2:
 * Input: [1, 2, 3, 4], [1, 4]
 * Output: 1
 * Explanation:
 * The two heater was placed in the position 1 and 4. We need to use radius 1 standard,
 * then all the houses can be warmed.
 *
 * @author rovo98
 * Date: 24/2/2018
 */
public class Heaters {
    // Solution one: ^
    /*
    Complexity Analysis:
        Time complexity: O(n log n).
        Space complexity: O(heaters.length).
     */
    public int findRadius(int[] houses, int[] heaters) {
        int[] hIndices = new int[heaters.length];
        
        // Get all the heaters' index in houses.
        int hLen = heaters.length;
        for (int i = 0; i < hLen; i++) {
            hIndices[i] = search(houses, heaters[i]);
        }

        int minRadius = 1;
        for (int i = 0; i < hIndices.length-1; i++) {
            int r = (hIndices[i+1] - hIndices[i]) / 2;
            if (r > minRadius) {
                minRadius = r;
            }
        }
        return minRadius;
    }

    /**
     * Returns the index of the heater in {@code houses}.
     * @param houses the positions of houses.
     * @param heater the heater.
     * @return      the index of the heater in {@code houses}.
     *              {@code -1} if heater is not in {@code houses}.
     */
    private int search(int[] houses, int heater) {
        int lo = 0;
        int hi = houses.length - 1;

        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (houses[m] == heater) {
                return m;
            } else if (houses[m] > heater) {
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }
        return -1;      // In this case, this code will never be executed.
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        Heaters h = new Heaters();
        int[] houses = {1, 2, 3, 4, 5};
        int[] heaters = {1, 5};
        System.out.println("The input test houses array is the following:");
        for (int house : houses) {
            System.out.print(house + " ");
        }
        System.out.println();
        System.out.println("And the input test heaters array is the following:");
        for (int heater : heaters) {
            System.out.print(heater + " ");
        }
        System.out.println();
        System.out.println("The minimum radius for this case is " + h.findRadius(houses, heaters) + ".");
    }
}
