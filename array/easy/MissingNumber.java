package Array.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem : Acceptance: 44.6%
 * Given an array containing n distinct numbers taken from 0,1,2, ..., n, find the one that is
 * missing from the array.
 *
 * Example 1:
 * Input : [3, 0, 1]
 * Output : 2
 *
 * Example 2:
 * Input : [9, 6, 4, 2, 3, 5, 7, 0, 1]
 * Output : 8
 *
 * Note :
 *   Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant extra space complexity?
 *
 * @author rovo98
 * Date: 08/2/2018
 * Modify: 13/2/2018 -- Add approach three.
 */
public class MissingNumber {
    // Solution one: ^
    // This solution doesn't meet the condition from note above.
    /*
    Complexity Analysis:
        Time complexity: O(n log n).
        Space complexity: O(1).
     */
    public int missingNumberVersionOne(int[] nums) {
        // Sort the input array first.
        Arrays.sort(nums);      // it takes O(log n).
        for (int i = 0; i < nums.length; i++) { // O(n)
            if (nums[i] != i) {
                return i;
            }
        }
        return -1;
    }
	// interpolation search.
    private int interpolationSearch(int[] nums, int key) {
    	int lo = 0;
		int hi = nums.length - 1;
		while (lo <= hi && key < nums[hi] && key > nums[lo]) {
			int pos = lo + (hi - lo) * (key - nums[lo]) / (nums[hi]-nums[lo]);
			if (nums[pos] == key)
				return pos;
			else if (nums[pos] > key)
				hi = pos - 1;
			else
				lo = pos + 1;
		}
		return -1;
    }
	// solution two :
	/*
	Complexity Analysis:
		Time complexity: O(n log log n), worst case : O(n^2)
		Space complexity: O(n).
	*/
	public int missingNumberVersionTwo(int[] nums) {
		int aux[] = new int[nums.length+1];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = i;	
		}
		for (int num : nums) {
			int index = interpolationSearch(aux, num);
			if (index > -1)
				aux[index] = -aux[index];
		}
		for (int num : aux)
			if (num > 0)
				return num;
		return -1;
	}
    // Solution two: &
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(1).
     */
    public int missingNumber(int[] nums) {
        /*
          first do XOR from 0 to n.
          x = x ^ elem
          then do x ^= e from input array.
          the final x is the result.
        */
        int x = 0;
        for (int i = 0; i <= nums.length; i++) {
            x ^= i;
        }
        for(int n : nums) {
            x ^= n;
        }
        return x;
    }
    // Solution three: &
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space Complexity: O(n).
     */
    public int missingNumberVersionThree(int[] nums) {
        /*
        This approach is almost identical to the brute force, except we first insert
        each element of nums into a set, allowing us to later query for containment in
        O(1) time.
         */
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!set.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] testArr1 = {3, 0, 1};
        int[] testArr2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("The input arrays is the following:");
        for (int i = 0; i < testArr1.length; i++) {
            System.out.print(testArr1[i]+" ");
        }
        System.out.println();
        for (int elem : testArr2) {
            System.out.print(elem+" ");
        }
        System.out.println();
        int result1 = mn.missingNumber(testArr1);
        int result2 = mn.missingNumberVersionOne(testArr2);
		int result3 = mn.missingNumberVersionThree(testArr1);
		int result4 = mn.missingNumberVersionTwo(testArr1);
        System.out.println("The result of testArr1 is "+result1+", and the result of " +
                "testArr2 is "+result2);
		System.out.println("The result of testArr1 got from function version 3 is " + result3 + ".");
		System.out.println("The result of testArr1 got from function version 2 is " + result4 + ".");
    }
}
