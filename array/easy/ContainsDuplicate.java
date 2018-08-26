package Array.Easy;

import java.util.*;

/**
 * Problem : Acceptance: 46.7%
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array
 * , and it should return false if every element is distinct.
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int [] nums) {
        // Solution one: ^
        // This algorithm's complexity is O(n).
        Set<Integer> numSet = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (numSet.contains(nums[i])) {
                return true;
            }else {
                numSet.add(nums[i]);
            }
        }
        return false;
    }
    // Solution two: Learning from leetcode.
    // This algorithm's time complexity is O(n^2).
    public boolean containsDuplicatesVersionTwo(int[] nums) {
        for (int i=0; i<nums.length; ++i) {
            for (int j=0; j<i; ++j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Solution three:
    // Sort the array first. Its time complexity is depended on what kind of
    // sorting we use. This algorithm's time complexity is O(log n).
    public boolean containsDuplicatesVersionThree(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
    // Driver the program to test the method above.
    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] testArr = {1, 2, 3, 4, 5, 5, 6};
        boolean result1 = cd.containsDuplicate(testArr);
        boolean result2 = cd.containsDuplicatesVersionTwo(testArr);
        boolean result3 = cd.containsDuplicatesVersionThree(testArr);
        System.out.println("The input array is the following:");
        for (int i=0; i<testArr.length; i++) {
            System.out.print(testArr[i]+" ");
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("And the output is : "+result1+", "+result2+", "+result3+".");
    }
}
