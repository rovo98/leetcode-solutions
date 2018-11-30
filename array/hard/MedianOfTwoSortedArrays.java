package Array.Hard;

import java.util.Arrays;

/**
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * @author rovo98
 * date: 2018.11.28 22:34
 */
public class MedianOfTwoSortedArrays {

    /**
     * private empty constructor
     *
     * this class can not be instanced.
     */
    private MedianOfTwoSortedArrays() {}

    /*
        Complexity Analysis:
            Time complexity: O(m +n )
            Space complexity: O(m + n)
    */
    private static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // using the idea of mergeSort
        int m = nums1.length;
        int n = nums2.length;

        int[] merged = new int[m + n];

        int left = 0, right = 0;
        for (int i = 0; i < merged.length; i++) {
            if (left >= m) // no elements left in nums1
                merged[i] = nums2[right++];
            else if (right >= n) // no elements left in nums2
                merged[i] = nums1[left++];
            else if (nums1[left] < nums2[right])
                merged[i] = nums1[left++];
            else
                merged[i] = nums2[right++];
        }
        // if only one element in the merged array.
        if (merged.length == 1)
            return merged[0];

        int mid = merged.length / 2;
        return merged.length % 2 == 0 ? (double) (merged[mid] + merged[mid - 1]) /2: (double) merged[mid];
    }

    /**
     * Driver the program to test the methods above.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println("The input test case is the following:");
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("And the result is " + findMedianSortedArrays(nums1, nums2) + ".");
    }
}
