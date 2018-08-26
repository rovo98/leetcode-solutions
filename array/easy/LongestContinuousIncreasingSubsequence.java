package Array.Easy;

/**
 * Problem : Acceptance: 42.5%
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence
 * (subarray).
 *
 * Example 1:
 * Input : [1, 3, 5, 4, 7]
 * Output : 3
 * Explanation :
 * The longest continuous increasing subsequence is [1, 3, 5], its length is 3.
 * Even though [1, 3, 5, 7] is also an increasing sbusequence, it's not a continuous one
 * where 5 and 7 are separated by 4.
 *
 * Example 2:
 * Input : [2, 2, 2, 2, 2]
 * Output : 1
 * Explanation:
 * The longest continuous increasing subsequence is [2], its length is 1.
 *
 * @author rovo98
 * Date: 12/2/2018
 */
public class LongestContinuousIncreasingSubsequence {
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public int findLengthOfCIS(int[] nums) {
        int length = 0;
        int count = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > length) {
                length = count;
            }
        }
        return length;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence lcisa = new LongestContinuousIncreasingSubsequence();
        int[] testArr = {1, 3, 5, 4, 7, 11, 12, 54, 14};
        System.out.println("The input test array is the following:");
        for (int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
        System.out.println("\nThe length of its longest continuous increasing subsequence is " + lcisa.findLengthOfCIS(testArr));
    }
}
