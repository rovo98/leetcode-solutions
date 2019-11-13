class Solution {
    /**
     * Complexity Analysis: 
     *  Time complexity: O(n log n)
     *  Space complexity: O(1)
     * */
    public int arrayPairSum(int[] nums) {
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
}
