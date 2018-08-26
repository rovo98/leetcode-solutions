package Array.Easy;

/**
 * Problem: Acceptance: 47.2%
 * Given an array of integers that is already sorted in ascending order, find two numbers such that
 * they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up
 * to the target, where index1 must be less than index2. Please note that your returned
 * answers(both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may not use
 * the same element twice.
 *
 * Input : numbers = {2, 7, 11, 15}, target = 9
 * Output : index1 = 1, index2 = 2
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class TwoSumTwo {
    // solution one: ^
    // We can iterate the first index, and then using the binary search to find the second index.
    // this algorithm's time complexity is O(n log n).
    // Definition of the Binary Search method.
    // Iteration version
    public int binarySearchIterationVersion(int[] nums, int left, int right, int key) {
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == key) {
                return mid;
            }
            else if (nums[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    // Recursion version
    public int binarySearchRecursionVersion(int[] nums, int left, int right, int key) {
        if (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == key) {
                return mid;
            }
            else if (nums[mid] > key) {
                return binarySearchRecursionVersion(nums, left, mid -1, key);
            }
            else {
                return binarySearchRecursionVersion(nums, mid +1, right, key);
            }
        }
        return -1;
    }
    public int[] twoSumVersionOne(int[] numbers, int target) {
        for (int i=0; i<numbers.length; i++) {
            int firstIndex = i;
            int secondIndex = this.binarySearchIterationVersion(numbers, i+1, numbers.length, target-numbers[firstIndex]);
            if (secondIndex > 0) {
                return new int[] {firstIndex+1, secondIndex+1};
            }
        }
        return null;
    }
    // Solution two: ^
    public int[] twoSumVersionTWo(int[] numbers, int target) {
        // We can assume the firstIndex represents the first element and the secondIndex represents the last element in the input array.
        // If the sum which they add up is greater than the target, then the secondIndex = secondIndex - 1, if the sum is smaller than the target
        // , then the firstIndex = firstIndex + 1. According to the problem above, when firstIndex equals to the secondIndex, it means there is
        // no solution for this case.
        // This algorithm's time complexity is optimized to O(n).
        int firstIndex = 0;
        int secondIndex = numbers.length - 1;
        while (firstIndex < secondIndex) {
            int sum = numbers[firstIndex] + numbers[secondIndex];
            if (sum == target) {
                return new int[] {firstIndex+1, secondIndex+1};
            }
            else if (sum > target) {
                secondIndex = secondIndex - 1;
            }
            else {
                firstIndex = firstIndex + 1;
            }
        }
        // While we can't find the solution, return null.
        return null;
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        TwoSumTwo tst = new TwoSumTwo();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result1 = tst.twoSumVersionOne(nums, target);
        int[] result2 = tst.twoSumVersionTWo(nums, target);

        System.out.println("The input test array is the following:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        if (result1 != null) {
            System.out.print("We use the algorithm's version one, then we can get the result is: [");
            for (int i=0; i<result1.length; i++) {
                System.out.print(result1[i]);
                if (i != result1.length-1) {
                    System.out.print(",");
                }
            }
            System.out.print("] for target " + target + ".\n");
        }
        else {
            System.out.println("We can't get the answer for " + target + " using the version one's algorithm!");
        }

        if (result2 != null) {
            System.out.print("We use the algorithm's version two, then we can get the result is: [");
            for (int i=0; i<result2.length; i++) {
                System.out.print(result2[i]);
                if (i != result2.length-1) {
                    System.out.print(",");
                }
            }
            System.out.print("] for target " + target + ".\n");
        }
        else {
            System.out.println("We can't get the answer for " + target + " using the version two's algorithm!");
        }
    }
}
