package Array.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem : Acceptance: 35.9%
 * Given a sorted array, remove the duplicates in-place such that each element
 * appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by
 * modifying the input array in-place with O(1) extra memory.
 *
 * Example:
 * Given nums = [1, 1, 2],
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond
 * the new length.
 *
 * @author rovo98
 * Date: 02/2/2018
 */
public class RemoveDuplicatesFromSortedArray {
    // Solution one: &
    // This algorithm's time complexity is O(n).
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j=1; j<nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
    // Solution two: ^
    // This algorithm's time complexity is O(n).
    public int removeDuplicatesVersionTwo(int[] nums) {
        // We use a hashMap to store all the key(indices) and value(value of each element)
        // If we meet the duplicates, the newLength will minus one.
        if (nums.length == 0)
            return 0;
        int newLength = nums.length;
        Set<Integer> numSet = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (numSet.contains(nums[i])) {
                newLength--;
            }else {
                numSet.add(nums[i]);
            }
        }
        return newLength;
    }

    // Derive the program to test the method above.
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();
        int[] testArr1 = {1, 1, 2, 2};
        int[] testArr2 = {1, 2, 2, 3, 3};
        System.out.println("The input arrays is the following :");
        for (int i=0; i<testArr1.length; i++) {
            System.out.print(testArr1[i]+" ");
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        for (int i=0; i<testArr2.length; i++) {
            System.out.print(testArr2[i]+" ");
        }
        System.out.println();
        int result1 = rdfsa.removeDuplicates(testArr1);
        int result2 = rdfsa.removeDuplicatesVersionTwo(testArr2);
        System.out.println("And the output is:"+result1+" and "+result2);
    }
}
