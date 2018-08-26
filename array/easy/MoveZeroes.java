package Array.Easy;

/**
 * Problem : Acceptance: 51.1%
 * Given an array nums, write a function to move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should
 * be [1, 3, 12, 0, 0].
 *
 * Note :
 *    1. You must do this in-place without making a copy of the array.
 *    2. Minimize the total number of operations.
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class MoveZeroes {
    // Solution one: ^
    // This algorithm's time complexity is O(n^2).
    public void moveZeroes(int[] nums) {
        // Record the length of the input array.
        int length = nums.length;
        // To move all the zeroes.
        for (int i=0; i<length; i++) {
            if (nums[i] == 0) {      // If the element's value is zero.
                int j;
                for (j=i; j<length-1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[j] = 0;
                // refresh the length.
                length -= 1;
            }
        }
    }
    public void printArr(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    // Driver the program to test the method above.
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] testArr = {0, 1, 0, 3, 12};
        System.out.println("The input array is the following:");
        mz.printArr(testArr);
        mz.moveZeroes(testArr);
        System.out.println("After calling the function, the array becomes:");
        mz.printArr(testArr);
    }
}
