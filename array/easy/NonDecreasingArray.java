package Array.Easy;

/**
 * Problem : Acceptance: 20.9%
 * Given an array with n integers, your task is to check if it could become non-decreasing by
 * modifying at most one element.
 *
 * We define an array is non-decreasing if array[i] <= array[i+1] holds for every i(i <= i < n).
 *
 * Example 1:
 * Input : [4, 2, 3]
 * Output : True
 * Explanation :
 * You could modify the first 4 to 1 to get a non-decreasing array.
 *
 *
 * Example 2:
 * Input : [4, 2, 1]
 * Output : False
 * Explanation:
 * You can't get a non-decreasing array by modifying at most one element.
 *
 * Note : The n belongs to [1, 10000].
 *
 * @author rovo98
 * Date: 12/2/2018
 */
public class NonDecreasingArray {
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public boolean chechkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                nums[i] = nums[i+1] - 1;
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        NonDecreasingArray nda = new NonDecreasingArray();
        int[] testArr1 = {4, 2, 3};
        int[] testArr2 = {4, 3, 2};
        System.out.println("The input test arrays is the following:");
        for (int i = 0; i < testArr1.length; i++) {
            System.out.print(testArr1[i] + " ");
        }
        System.out.println();
        for (int e : testArr2) {
            System.out.print(e + " ");
        }
        System.out.println();
        if (nda.chechkPossibility(testArr1)) {
            System.out.println("The array 1 is a Non-decreasing array.");
        } else {
            System.out.println("The array 1 is not a Non-decreasing array.");
        }
        if (nda.chechkPossibility(testArr2)) {
            System.out.println("The array 2 is a Non-decreasing array.");
        } else {
            System.out.println("The array 2 is not a Non-decreasing array.");
        }
    }
}
