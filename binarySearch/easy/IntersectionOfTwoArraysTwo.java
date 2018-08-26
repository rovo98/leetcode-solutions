package BinarySearch.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem : Acceptance: 44.9%
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1,2,2,1], nums2 = [2,2], return [2,2].
 *
 * Note:
 *    1. Each element in the result should appear as many times as it shows in both arrays.
 *    2. The result can be in any order.
 *
 *
 * Follow up:
 *    1. What if the given array is already sorted? How would you optimize your algorithm?
 *    2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *    3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot
 *    load all elements into the memory at once?
 *
 *  @author rovo98
 *  Date: 4/3/2018
 */
public class IntersectionOfTwoArraysTwo {
    // Solution one: ^
    /*
    Complexity Analysis:
        Time complexity: O(n log n).
        Space complexity: O(n).
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        /*
        use mergeSort to sort the arrays first.
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        if (nums1.length < nums2.length) {
            for (int num : nums1) {
                if (interpolationSearch(nums2, num) > -1) {
                    list.add(num);
                }
            }
        } else {
            for (int num : nums2) {
                if (interpolationSearch(nums1, num) > -1) {
                    list.add(num);
                }
            }
        }

        int[] result = new int[list.size()];
        int c = 0;
        for (int item : list) {
            System.out.println(item);
            result[c++] = item;
        }
        return result;
    }
    // interpolationSearch
    private int interpolationSearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi && key >= arr[lo] && key <= arr[hi]) {
            int mid = lo + (key - arr[lo]) * (hi - lo) / (arr[hi] - arr[lo]);
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        IntersectionOfTwoArraysTwo iotat = new IntersectionOfTwoArraysTwo();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("The input test arrays are the following:");
        for (int num : nums1)
            System.out.print(num + " ");
        System.out.println();
        for (int num : nums2)
            System.out.print(num + " ");
        System.out.println();
        int[] result  = iotat.intersect(nums1, nums2);
        System.out.println("The output is the following:");
        for (int r : result)
            System.out.print(r + " ");
        System.out.println();
    }
}
