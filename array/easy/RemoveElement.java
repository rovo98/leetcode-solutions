package Array.Easy;

/**
 * Problem : Acceptance: 40.2%
 * Given an array and a value, remove all instance of that value in-place
 * and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 *
 * Example :
 * Given nums = [3, 2, 2, 3], val = 3
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class RemoveElement {
    // Solution one: ^
    // This algorithm's time complexity is O(n^2).
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        for (int i=0,j; i<nums.length; i++) {
            if (nums[i] == val) {
                for (j=i; j<nums.length-1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[j] = Integer.MIN_VALUE; // reset the deleted element's value to  MIN_VALUE
                length -= 1;
            }
        }
        return length;
    }
    // Solution two: ^
    // This algorithm's time complexity is O(n). but it doesn't modify the input array.
    public int removeElementVersionTwo(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != val) {
                len++;
            }
        }
        return len;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] test = {3, 2, 2, 3};
        int newLength2 = re.removeElementVersionTwo(test, 3);
        int newLength = re.removeElement(test, 3);
        System.out.println("The original length of the input array is: "+test.length);
        System.out.println("After calling the function with version one, the new length is: "+newLength);
        System.out.println("After calling the function with version two, the new length is: "+newLength2);
    }
}
