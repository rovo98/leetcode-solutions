package Array.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : Acceptance: 36.9%
 * Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * Example :
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0,1]
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class TwoSum {
    // solution one: ^
    // Iterate all conditions which can add up to equal the target.
    // this solution's time complexity is O(n^2).
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            int firstIndex = i;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] == (target - nums[firstIndex])) {
                    return new int[] {firstIndex, j};
                }
            }
        }
        // If we can't find such a condition, return null.
        return null;
    }
    // Solution two: &&
    // This method's time complexity is O(n).
    public int[] twoSumVersionTwo(int[] nums, int target) {
        // solution two: its time complexity is O(n)
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i+1;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i+1);
        }
        return result;
    }
    // Driver the program to test the method above.
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum(nums, 9);
        if (result != null) {
            System.out.print("Test the example case above, we can get the result is:[");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i != result.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]\n");
        }
    }
}
