package Array.Easy;

/**
 * Problem: Acceptance: 44.9%
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every
 * other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 * Input : nums = [3, 6, 1, 0]
 * Output : 1
 * Explanation :
 * 6 is the largest integer, and for other number in the array x, 6 is more than twice
 * as big as x. The index of value 6 is 1, so we return 1.
 *
 * Example 2:
 * Input : nums = [1, 2, 3, 4]
 * Output : -1
 * Explanation : 4 isn't at least as big as twice the value of 3, so we return -1.
 *
 * Note :
 *    1. nums will have a length in the range[1, 50].
 *    2. Every nums[i] will be an integer in the range[0, 99].
 *
 * @author rovo98
 * Date: 12/2/2018
 */
public class LargestNumberAtLeastTwiceOfOthers {
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public int dominantIndex(int[] nums) {
        /*
        Find the largest element in array firstly.
        Iterates other elements in array to see if they satisfies the conditions.
         */
        int largestElem = Integer.MIN_VALUE;
        int index = -1;
        // Get the largest element in array.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largestElem) {
                largestElem = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != largestElem && (nums[i]*2 > largestElem)) {
                return -1;
            }
        }
        return index;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers lnalto = new LargestNumberAtLeastTwiceOfOthers();
        int[] testArr = {3, 6, 1, 0};
        int[] testArr1 = {1, 2, 3, 4};
        System.out.println("The input arrays is the following:");
        for (int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
        System.out.println();
        for (int e : testArr1) {
            System.out.print(e + " ");
        }
        System.out.println();
        int index1 = lnalto.dominantIndex(testArr);
        int index2 = lnalto.dominantIndex(testArr1);
        if (index1 > 0) {
            System.out.println("The output for the array 1 is " + index1);
        } else {
            System.out.println("There is no index satisfies the condition in array 1.");
        }
        if (index2 > 0) {
            System.out.println("The output for the array 2 is " + index2);
        } else {
            System.out.println("There is no index satisfies the condition in array 2.");
        }
    }
}
