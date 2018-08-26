package Array.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem : Acceptance: 51.3%
 * Given an array of integers where 1<= a[i] <= n(n = size of array), some elements
 * appear twice and others appear once.
 *
 * Find all the elements of [1,n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 *
 * Example :
 * Input : [4, 3, 2, 7, 8, 2, 3, 1]
 *
 * Output : [5, 6]
 *
 * @author rovo98
 * Date: 13/2/2018
 * Learning from leetcode's solutions for this problem.
 */
public class FindAllNumbersDisappearedInAnArray {
    // Solution one: &^&
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(1).
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
        We iterate through the input array and mark elements as negative using
        nums[nums[i]-1] = - nums[nums[i]-1]. In this way all the numbers that we have seen
        will be marked as negative. In the second iteration, if a value is not marked as
        negative, it implies we have never seen that index, so just add to the return list.
         */
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray fandia = new FindAllNumbersDisappearedInAnArray();
        int[] testArr = {4, 3, 2, 1, 7, 8, 2, 3, 1};
        System.out.println("The input test array is the following:");
        for (int num : testArr) {
            System.out.print(num + " ");
        }
        System.out.println();
        List<Integer> result = fandia.findDisappearedNumbers(testArr);
        System.out.println("And all missing numbers in this array is the following:");
        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
