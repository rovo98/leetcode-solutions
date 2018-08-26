package Array.Easy;

/**
 * Problem : Acceptance: 53.9%
 * Given a binary array, find the maximum number of consecutive 1s in the array.
 *
 * Example 1:
 * Input : [1, 1, 0, 1, 1, 1]
 * Output : 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3
 *
 *
 * Note :
 *    1. The input array will only contain 0 and 1.
 *    2. The length of input array is a positive integer and will not exceed 10,000.
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class MaxConsecutiveOnes {
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        // Iterate all the elements in the input array, if we meet consecutive 1s
        // , count += 1, otherwise, reset the count to 0.
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
            }
            else {
                count = 0;
            }
        }
        return count;
    }

    // Driver the program to test the method.
    public static void main(String[] args) {
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        int [] test = {1, 1, 0, 1, 1, 1};
        int result = mco.findMaxConsecutiveOnes(test);
        System.out.println("The input array is the following:");
        for (int i=0; i<test.length; i++) {
            System.out.print(test[i]+" ");
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("After calling the function, we can get the result is: "+result);
    }
}
