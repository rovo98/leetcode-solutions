package Array.Easy;

import java.util.Arrays;
import java.util.Random;

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
    // Solution one: ^
    // This algorithm's time complexity is O(log n), it depended on what kind of sorting
    // algorithms we use.
    public int arrayParisSum(int[] nums) {
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

    // The definition of the testing methods
    public int[] generateRandomArr() {
        // According to the notes above to generate the input array randomly.
        int n = new Random().nextInt(10000) + 1;
        System.out.println("we generate "+n+"elements!");
        int[] arr = new int[n];

        //Initial the all the integers in the array
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int)(Math.random()*9999) + 1;
        }

        // return the arr
        return arr;
    }

    // Driver the program to test the method.
    public static void main(String[] args) {
        ArrayPartition ap = new ArrayPartition();
        int[] arr = {1, 4, 3, 2};
        System.out.println("The input array:");
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+"\t");
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        int sum = ap.arrayParisSum(arr);
        System.out.println("The result is: "+sum);
    }
}
