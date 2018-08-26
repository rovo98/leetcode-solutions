package Array.Easy;

/**
 * Problem : Acceptance: 29.2%
 *
 * Given an integer array, you need to find one continuous subarray that if
 * you only sort this subarray in ascending order, then the whole array will be sorted
 * in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 *
 * Example 1:
 *
 * Input : [2, 6, 4, 8, 10, 9, 15]
 * Output : 5
 * Explanation : You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole
 * array sorted in ascending order.
 *
 * Note :
 *    1. Then length of the input array is in range[1, 10000].
 *    2. The input array may contain duplicates, so ascending order here means <=.
 *
 * @author rovo98
 * Date: 12/2/2018
 */
public class ShortestUnsortedContinuousSubarray {
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public int findUnSortedSubarray(int[] nums) {
        /*
        Find the first unOrder index and the last unOrder index. (luIndex - fuIndex) + 2 is the result.
         */
        int fuIndex = -1;
        int luIndex = -1;
        // Get the first unOrder index.
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                fuIndex = i;
                break;
            }
        }
        // Get the last unOrder index.
        for (int i = nums.length-1; i >0; i--) {
            if (nums[i] < nums[i-1]) {
                luIndex = i;
                break;
            }
        }
        if (luIndex < 0) {
            return 2;
        } else if (fuIndex < 0) {
            return 0;
        }
        return luIndex - fuIndex + 1;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray sucsa = new ShortestUnsortedContinuousSubarray();
        int[] testArr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println("The input test array is the following:");
        for (int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
        System.out.println("\nThe length of the shortest subarray is " + sucsa.findUnSortedSubarray(testArr));
    }
}
