package Sort.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Acceptance: 47.9%
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1,2,2,1], nums2 = [2, 2], return [2]
 *
 * Note :
 *     1. Each element in the result must be unique.
 *     2. The result can be in any order.
 *
 * @author rovo98
 * Date: 7/3/2018
 */
public class IntersectionOfTwoArrays {
    // solution one : ^
    /*
    Complexity Analysis:
        Time complexity: O(n log n).
        Space complexity: O(n).
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // since the array may contains duplicates.
        // we use quickSort 3 ways here.
        quickSort(nums1);
        quickSort(nums2);

        Set<Integer> set = new HashSet<>();
        if (nums1.length < nums2.length) {
            for (int num : nums1) {
                if (interpolationSearch(nums2, num) > -1) {
                    set.add(num);
                }
            }
        } else {
            for (int num : nums2) {
                if (interpolationSearch(nums1, num) > -1) {
                    set.add(num);
                }
            }
        }

        int[] result = new int[set.size()];
        int c = 0;
        for (int num : set) {
            result[c++] = num;
        }
        return result;
    }
    // interpolationSearch.
    private int interpolationSearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) * (key - a[lo]) / (a[hi] - a[lo]);
            if (a[mid] == key)
                return mid;
            else if (a[mid] > key)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
    // quick3ways sort.
    private void quickSort(int[] a) {
        sort(a, 0, a.length-1);
        assert isSorted(a);
    }
    private void sort(int[] a, int lo, int hi) {
        // insertion sort the small arrays.
        if (hi <= lo + 7) {
            insertionSort(a, lo, hi);
            return;
        }
        int v = a[lo];
        int lt = lo;
        int gt = hi;
        int i = lo + 1;

        while (i <= gt) {
            if      (v > a[i])   exch(a, i++, lt++);
            else if (v < a[i])   exch(a, i, gt--);
            else                 i++;
        }
        sort(a, lo, i-1);
        sort(a, i+1, hi);
    }
    // insertion sort.
    private void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++) {
            int key = a[i];
            int j = i-1;
            while (j >= lo && key < a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    /**************************************
     *  Check if the array is sorted.
     **************************************/
    private boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        IntersectionOfTwoArrays isota = new IntersectionOfTwoArrays();
        int[] nums1 = new int[] {1, 2, 2, 1};
        int[] nums2 = new int[] {2, 2};
        System.out.println("The input test array is the following:");
        for (int num : nums1)
            System.out.print(num + " ");
        System.out.println();
        for (int num : nums2)
            System.out.print(num + " ");
        System.out.println();
        int[] result = isota.intersection(nums1, nums2);
        System.out.println("The result is the following:");
        for (int r : result)
            System.out.print(r + " ");
        System.out.println();
    }
}
