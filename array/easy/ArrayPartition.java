package Array.Easy;

import java.util.Arrays;

/**
 * Problem : Acceptance: 66.5%
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1,b1), (a2,b2), ...,(an,bn) which makes sum of min(ai,bi) for all i from  1 to n
 * as large as possible.
 *
 * Example 1:
 * Input : [1, 4, 3, 2]
 * Output : 4
 *
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1,2) + min(3,4).
 *
 * Note :
 *    1. n is a positive integer, which is in the range of [1, 10000].
 *    2. All the integers in the array will be in the range of [-10000, 10000].
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class ArrayPartition {
    // this class can not be instanced
    private ArrayPartition() {}
    // Solution one: ^
    // This algorithm's time complexity is O(log n), it depended on what kind of sorting
    // algorithms we use.
    private static int arrayParisSum(int[] nums) {
        //sort the input array first, then add up all the elements which have the even index.
        int sum = 0;

        // using shell sort or merge sort here.
        /*
        int n = nums.length;
        int h = 1;
        while (h < n/3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, ...
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int key = nums[i];
                int j;
                for (j = i-h; j >= 0 && key < nums[j]; j -= h) {
                    nums[j+h] = nums[j];
                }
                nums[j+h] = key;
            }
            h /= 3;
        }
        */
        Arrays.sort(nums);
        // add up all the even elements
        for (int i=0; i<nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }


    // using the idea of the bucketSort
    /*
    Complexity Analysis:
        Time complexity: O(n)
        Space complexity: O(n)
     */
    private static int arrayParisSumVer2(int[] nums) {

        if (nums.length % 2 != 0)
            throw new IllegalArgumentException();

        int[] bucket = new int[20001];
        int maxElemt = Integer.MIN_VALUE;
        int minElemt = Integer.MAX_VALUE;

        for (int num : nums) {
            bucket[num + 10000]++;
            if (num > maxElemt)
                maxElemt = num;
            if (num < minElemt)
                minElemt = num;
        }

        int result = 0;
        minElemt += 10000;  // offset is 10000
        maxElemt += 10000;
        boolean isOdd = true;
        for (int i = minElemt; i <= maxElemt; i++) {
            if (bucket[i] > 0) {
                for (int j = 0; j < bucket[i]; j++) {
                    if (isOdd)
                        result += (i - 10000);
                    isOdd = !isOdd;
                }
            }
        }
        return result;
    }

    // Driver the program to test the method.
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        System.out.println("The input array:");
        for (int anArr : arr) {
            System.out.print(anArr + "\t");
        }
        System.out.println();
        int sum = arrayParisSum(arr);
        System.out.println("The result is: "+sum);
        System.out.println("The result(ver2) is " + arrayParisSumVer2(arr) + ".");
    }
}
