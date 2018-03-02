package Array.Easy;

import java.util.Arrays;

/**
 * Problem : Acceptance: 45.1%
 * Given an integer array, find three numbers whose product is maximum and
 * output the maximum product.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 *
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 *
 * Note:
 *    1. The length of the given array will be in range[3, 10^4] and all elements
 *    are in the range[-1000, 1000].
 *    2. Multiplication of any three numbers in the input won't exceed the range
 *    of 32-bit signed integer.
 *
 * @author rovo98
 * Date: 02/2/2018
 * Modify: 12/2/2018
 */
public class MaximumProductOfThreeNumbers {
    // Solution one: ^
    // We can sort the input array firstly. And after this operation, The last three elements
    // in the array are what we need.
    // This algorithm's time complexity is depend on what kind of sorting algorithms we use.
    // And this method will modify the input array.(This is a problem)
    // This method's time complexity is O(log n).
    // Review: this method doesn't works if there are negative elements in array.
    public int maximumProduct(int[] nums) {
        // We can use the bubbleSort to test firstly.
//        boolean flag = true;
//        for (int i=1; i<nums.length&&flag==true; i++) {
//            flag = false;
//            for (int j=0; j<nums.length-i; j++) {
//                if (nums[j] > nums[j+1]) {
//                    nums[j] ^= nums[j+1];
//                    nums[j+1] ^= nums[j];
//                    nums[j] ^= nums[j+1];
//                    flag = true;
//                }
//            }
//        }
        Arrays.sort(nums);
        // then the product of the last three elements is the result.
        int result = 1;
        for (int i=nums.length-1; i>nums.length-4; i--) {
            result *= nums[i];
        }
        return result;
    }
    // Solution two: ^
    // We can find the three biggest elements in the array.
    // This algorithm's time complexity is O(n).
    public int maximumProductVersionTwo(int[] nums) {
        /*
        There two conditions we can get the maximum product.
        1. firstMinimum * secondMinimum * firstMaximum
        2. firstMaximum * secondMaximum * thirdMaximum
        And the biggest one in them is the result.
         */
        // Initial these three biggest elements.
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        // To find first biggest element and the first element.
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > firstMax) {
                firstMax = nums[i];
            }
            if (nums[i] < firstMin) {
                firstMin = nums[i];
            }
        }
        // To find second biggest element and second smallest element.
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < firstMax && nums[i] > secondMax) {
                secondMax = nums[i];
            }
            if (nums[i] > firstMin && nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }
        // To find third biggest element.
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < secondMax && nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }
        int fMax = firstMax * secondMax * thirdMax;
        int sMax = firstMin * secondMin * firstMax;

        if (fMax > sMax) {
            return fMax;
        } else {
            return sMax;
        }
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        MaximumProductOfThreeNumbers mpotn = new MaximumProductOfThreeNumbers();
        int[] testArr = {3, 2, 4, 1};
        int[] testArr1 = {-9, -7, -1, 1, 5, 8};
        System.out.println("The input array is the following:");
        for (int i=0; i<testArr.length; i++) {
            System.out.print(testArr[i]+" ");
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("The second input array is the following:");
        for (int i = 0; i < testArr1.length; i++) {
            System.out.print(testArr1[i] + " ");
        }
        System.out.println();
        int result2 = mpotn.maximumProductVersionTwo(testArr);
        int result1 = mpotn.maximumProduct(testArr);
        int result3 = mpotn.maximumProductVersionTwo(testArr1);
        System.out.println("After calling the function with version one, the output for array 1 is:"+result1);
        System.out.println("After calling the function with version two, the output for array 1 is:"+result2);
        System.out.println("After calling the function, the output for array 2 is " + result3);
    }
}
