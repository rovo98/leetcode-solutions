package Array.Easy;

/**
 * Problem : Acceptance: 40.4%
 * Given an array of integers nums, write a method that returns the "pivot" index of this
 * array.
 * We define the pivot index as the index where the sum of the numbers to the left of the
 * index is equal to the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you
 * should return the left-most pivot index.
 *
 * Example 1:
 * Input :
 * nums = [1, 7, 3, 6, 5, 6]
 * Output : 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers
 * to the right of index 3.
 * Also, 3 is the first index where this occurs.
 *
 *
 * Example 2:
 * Input :
 * nums = [1, 2, 3]
 * Output : -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 *
 * Note :
 *     1. The length of nums will be in the range [0, 10000].
 *     2. Each element nums[i] will be an integer in the range[-1000, 1000].
 *
 * @author rovo98
 * Date: 12/2/2018
 */
public class FindPivotIndex {
    // Solution one: ^
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(1).
     */
    public int pivotIndex(int[] nums) {
        /*
        use two pointers(left-right pointers) to iterates over the elements in array.
         */
        if (nums.length < 2) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int leftSum = nums[left];       // record the sum of the left part.
        int rightSum = nums[right];     // record the sum of the right part.
        while (left < right) {
            if (leftSum < rightSum) {
                leftSum += nums[++left];
            } else {
                rightSum += nums[--right];
            }
        }
        if (leftSum == rightSum) {
            return left;
        }
        return -1;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        FindPivotIndex fpi = new FindPivotIndex();
        int[] testArr = {1, 7, 3, 6, 5, 6};
        int[] testArr1 = {1, 2, 3};
        System.out.println("The input test array is the following:");
        for (int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
        System.out.println("\nThe input test array 2 is the following:");
        for (int i = 0; i < testArr1.length; i++) {
            System.out.print(testArr1[i] + " ");
        }
        System.out.println();
        int pivot  = fpi.pivotIndex(testArr);
        int pivot1 = fpi.pivotIndex(testArr1);
        if (pivot > 0) {
            System.out.println("And the pivot of this array is " + pivot);
        } else {
            System.out.println("There is no index that satisfies the conditions in problem statement.");
        }
        if (pivot1 > 0) {
            System.out.println("The pivot for the second array is " + pivot1);
        } else {
            System.out.println("There is no index that satisfies the conditions in array 2.");
        }
    }
}
