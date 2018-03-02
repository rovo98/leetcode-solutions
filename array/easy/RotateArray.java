package Array.Easy;

/**
 * Problem : Acceptance: 25.1%
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array  [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note :
 * Try to come up as many solutions as you can, there at least 2 different ways to solve this problem.
 *
 * Hint:
 * Could you do it in-place with O(1) extra space?
 *
 * @author rovo98
 * Date: 13/2/2018
 * Learning from leetcode's soltion to this problem.
 */
public class RotateArray {
    // Solution one: & Brute Force[Time limit exceeded]

    public void rotate(int[] nums, int k) {
        /*
        The simplest approach is to rotate all the elements of the array in k steps by
        rotating the elements by 1 unit in each step.
         */
        int temp;
        int previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length-1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
    // Solution two: & Using Extra Array
    /*
     Complexity Analysis:
        Time complexity: O(n).
        Space Complexity: O(n).
     */
    public void rotateVersionTwo(int[] nums, int k) {
        /*
        We use an extra array in which we place every element of the array at its
        correct position i.e the number at index i in the original array is placed
        at the index (i+k) % array.length. Then, we copy the new array to the original
        array.
         */
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
    // Solution three: &
    /*
    Complexity Analysis:
       Time complexity: O(n). n elements are reversed a total of three times.
       Space complexity: O(1). No extra space is used.
     */
    public void rotateVersionThree(int[] nums, int k) {
        /*
        This approach is based on the fact that when we rotate
        the array k times, k elements from the back end of the array come
        to the front and the rest of the elements shift backwards.

        We firstly reverse all the elements of the array. Then, reversing the first k elements
        followed by reversing the rest n - k elements gives us the required result.
        Let n = 7 and k = 3

        Original list: 1234567
        After reversing all numbers: 7654321
        After reversing first k numbers: 5674321
        After reversing the last n - k numbers: 5671234
         */
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] testArr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("The input array is the following:");
        for (int e : testArr) {
            System.out.print(e + " ");
        }
        System.out.println();
        ra.rotate(testArr, 3);
        System.out.println("After calling the function, it becomes:");
        for (int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
        System.out.println();
    }
}
