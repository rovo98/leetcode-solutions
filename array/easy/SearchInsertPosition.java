package Array.Easy;

/**
 * Problem : Acceptance: 40.0%
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1, 3, 5, 6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1, 3, 5, 6], 2
 * Output: 1
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class SearchInsertPosition {
    // Solution one: using a algorithm like binary search.
    // And the time complexity of this algorithm is O(log n).
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return mid + 1;
    }

    // Driver the program to test the method.
    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] testArr = {1, 3, 5, 6};
        int index1 = sip.searchInsert(testArr, 5);
        int index2 = sip.searchInsert(testArr, 2);

        System.out.println("The input array is following:");
        for (int i=0; i<testArr.length; i++) {
            System.out.print(testArr[i]+" ");
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("For target 5, we get the result is:"+index1);
        System.out.println("For target 2, we get the result is:"+index2);
    }
}
