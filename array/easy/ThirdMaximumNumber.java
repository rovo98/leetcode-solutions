package Array.Easy;

/**
 * Problem : Acceptance: 28.0%
 * Given a non-empty array of integer, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input : [3, 2, 1]
 * Output : 1
 *
 * Explanation : The third maximum is 1.
 *
 * Example 2:
 * Input : [1, 2]
 * Output : 2
 *
 * Explanation : The third maximum does not exist, so the maximum (2) is returned.
 *
 * Example 3:
 * Input : [2, 2, 3, 1]
 * Output : 1
 * Explanation : Note that the third maximum here means the third maximum distinct
 * number. Both numbers with value 2 are both considered as second maximum.
 *
 * @author rovo98
 * Date:   03/2/2018
 */
public class ThirdMaximumNumber {
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public int thirdMax(int[] nums) {
        // Allocate three integer to store the three biggest number in the array.
        // Initial them by assigning the MIN_VALUE of integer.
        int firstNum = Integer.MIN_VALUE;
        int secondNum = Integer.MIN_VALUE;
        int thirdNum = Integer.MIN_VALUE;

        // To find the first biggest number.
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > firstNum) {
                firstNum = nums[i];
            }
        }
        // To find the second biggest number.
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > secondNum && nums[i] < firstNum) {
                secondNum = nums[i];
            }
        }
        // To find the third biggest number.
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > thirdNum && nums[i] < secondNum) {
                thirdNum = nums[i];
            }
        }
        if (thirdNum < 0) { // If the third biggest number doesn't exists.
            return firstNum;
        } else {
            return thirdNum;
        }
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        ThirdMaximumNumber tmn = new ThirdMaximumNumber();
        int[] testArr1 = {1, 2};
        int[] testArr2 = {2, 2, 3, 1};

        System.out.println("The first test array is the following:");
        for (int i=0; i<testArr1.length; i++) {
            System.out.print(testArr1[i]+" ");
            if ((i+1) % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println("\nThe second test array is the following:");
        for (int i=0; i<testArr2.length; i++) {
            System.out.print(testArr2[i]+" ");
            if ((i+1) % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        int result1 = tmn.thirdMax(testArr1);
        int result2 = tmn.thirdMax(testArr2);
        System.out.println("The first result we got is "+result1+", and the second one is "+result2+".");
    }
}
