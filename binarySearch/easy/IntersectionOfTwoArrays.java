package BinarySearch.Easy;

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
 * Date: 3/3/2018
 */
public class IntersectionOfTwoArrays {
    // Solution one: ^
    /*
     Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(n).
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        /*
        use shell sort here to sort the arrays first.
        Then using Binary Search to iterate the smaller array's element to
        see whether they can be found in the another one.
         */
        shellSort(nums1);
        shellSort(nums2);

        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (!set.contains(nums1[i])) {
                    set.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int c = 0;
        for (int e : set) {
            result[c++] = e;
        }
        return result;
    }
    // Solution two : ^
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(n).
     */
    public int[] intersectionVersionTwo(int[] nums1, int[] nums2) {
        shellSort(nums1);
        shellSort(nums2);

        Set<Integer> set = new HashSet<>();

        if (nums1.length < nums2.length) {
            for (int num : nums1) {
                if (exponentialSearch(nums2, num) > -1) {
                    if(!set.contains(num)) {
                        set.add(num);
                    }
                }
            }
        } else {
           for (int num : nums2) {
               if (exponentialSearch(nums1, num) > -1) {
                   if (!set.contains(num)) {
                       set.add(num);
                   }
               }
           }
        }
        int[] result = new int[set.size()];
        int c = 0;
        for (int item : set) {
            result[c++] = item;
        }
        return result;
    }
    // binary search.
    private int binarySearch(int[] arr, int lo, int hi, int key) {
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (arr[m] == key) {
                return m;
            } else if (arr[m] > key) {
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }
        return -1;
    }
    // Exponential Search may better than binary search in this problem.
    private int exponentialSearch(int[] arr, int key) {
        int n = arr.length;
        // If x is present at first location itself.
        if (arr[0] == key) {
            return 0;
        }
        // Find the range for binary search by repeated doubling.
        int i = 1;
        while (i < n && arr[i] < key) {
            i = i * 2;
        }
        // Call binary search for the found range.
        return binarySearch(arr, i/2, Math.min(i, n), key);
    }
    // Shell sort.
    private void shellSort(int[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n/3){
            h = 3 * h + 1;  // 1, 4, 13, 40, 121, ...
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int key = arr[i];
                int j = i - h;
                while (j >= 0 && key < arr[j]) {
                    arr[j+h] = arr[j];
                    j -= h;
                }
                arr[j+h] = key;
            }
            h /= 3;
        }
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        IntersectionOfTwoArrays iota = new IntersectionOfTwoArrays();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("The input test arrays are the following:");
        for (int num : nums1)
            System.out.print(num + " ");
        System.out.println();
        for (int num : nums2)
            System.out.print(num + " ");
        System.out.println();
        int[] result = iota.intersection(nums1, nums2);
        int[] result1 = iota.intersectionVersionTwo(nums1, nums2);
        System.out.println("And the result for this case is the following:");
        for (int r : result)
            System.out.print(r + " ");
        System.out.println();
        System.out.println("And the result got from the version two:");
        for (int r : result1)
            System.out.print(r + " ");
        System.out.println();
    }
}
