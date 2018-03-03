package BinarySearch.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Acceptance: 35.5%
 *
 * Given a sorted array, two integers k and x, find the k closest elements to x in
 * the array. The result should also sorted in ascending order. If there
 * is a tie, the smaller elements are always preferred.
 *
 * Example 1:
 * Input: [1, 2, 3, 4, 5], k = 4, x = 3
 * Output: [1, 2, 3, 4]
 *
 * Example 2:
 * Input: [1, 2, 3, 4, 5], k = 4, x = -1
 * Output: [1, 2, 3, 4]
 *
 * Note:
 *    1. The value k is positive and will always be smaller than the length of the
 *       sorted array.
 *    2. Length of the given array is positive and will not exceed 10^4.
 *    3. Absolute value of elements in the array and x will not exceed 10^4.
 *
 * @author rovo98
 * Date: 2/3/2018
 */
public class FindKClosestElements {
    // Solution one : ^
    /*
    Complexity Analysis:
        Time complexity: O(log n).
        Space complexity: O(1).
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
        using Binary Search to find the index of the element to be approached.

         */
        if (k > arr.length) {
            throw new IllegalArgumentException("The value k is out of range.");
        }
        if (k == arr.length) {
           List<Integer> list = new ArrayList<>();
           for (int a : arr)
               list.add(a);
           return list;
        }

        // use binary search to get the pos of closest element.
        int pos = binarySearch(arr, 0, arr.length-1, x);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= pos; i++) {
            list.add(arr[i]);
            k--;
        }
        while (k > 0) {
            list.add(arr[++pos]);
            k--;
        }
        return list;
    }
    // Binary Search.
    private int binarySearch(int arr[], int l, int h, int key) {
        int mid = 0;
        while (l <= h) {
            mid = l + (h - l) >> 1;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return mid;
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        FindKClosestElements fkce = new FindKClosestElements();
        int[] testArr = {1, 2, 3, 4, 5};
        System.out.println("The input test array is the following:");
        for (int item : testArr)
            System.out.print(item + " ");
        System.out.println();
        List<Integer> result = fkce.findClosestElements(testArr, 4, -1);
        System.out.println("And the result of it is the following:");
        for (int r : result)
            System.out.print(r + " ");
        System.out.println();
    }

}
