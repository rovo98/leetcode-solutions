package Array.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : Acceptance: 28.2%
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs
 * in the array. Here a k-diff pair is defined as an integer pair(i,j), where i and j are both numbers
 * in the array and their absolute difference is k.
 *
 * Example 1:
 * Input : [3, 1, 4, 1, 5], k = 2
 * Output : 2
 * Explanation : There are two 2-diff pairs in the array, (1,3) and (3,5).
 * Although we have two is in the input, we should only return the number of unique pairs.
 *
 * Example 2:
 * Input : [1, 2, 3, 4, 5], k = 1
 * Output : 4
 * Explanation : There are four 1-diff pairs in the array, (1,2), (2,3), (3,4) and (4,5).
 *
 * Example 3:
 * Input : [1, 3, 1, 5, 4], k = 0
 * Output : 1
 * Explanation : There is one 0-diff pair in the array, (1,1).
 *
 * Note :
 *    1. The pairs (i,j) and (j,i) count as the same pair.
 *    2. The length of the array won't exceed 10000.
 *    3. All the integers in the given input belong to the range[-1e7,1e7].
 *
 * @author rovo98
 * Date: 12/2/2018
 */
public class KDiffPairsInAnArray {
    // Solution one: ^
    // This algorithm's time complexity is O(n^2).
    public int findPairs(int[] nums, int k) {
        /*
        Iterates all elements in array and for each element, add k to it to see if others equals to it.
        count the elements that satisfies this condition.
        I use a map to store the different pairs.
         */
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] == nums[i] + k && map.get(nums[j]) == null) {
                    map.put(nums[j], nums[i]);
                    count++;
                }
            }
        }
        return count;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        KDiffPairsInAnArray kdpia = new KDiffPairsInAnArray();
        int[] testArr = {3, 1, 4, 1, 5};
        int[] testArr1 = {1, 2, 3, 4, 5};
        System.out.println("The input test arrays is the following:");
        for (int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
        System.out.println();
        for (int e : testArr1) {
            System.out.print(e + " ");
        }
        System.out.println();
        int k = 2;
        int k1 = 1;
        System.out.println("And the number of " + k + "-diff pairs in array 1 is " + kdpia.findPairs(testArr, k));
        System.out.println("And the number of " + k1 + "-diff pairs in array 2 is " + kdpia.findPairs(testArr1, k1));
    }
}
