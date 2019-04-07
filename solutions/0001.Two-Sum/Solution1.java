class Solution {
    /**
     * Complexity Analysis:
     * TC: O(n^2)
     * SC: O(1)
     *
     * */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == target-nums[i])
                    return new int[] {i, j};
            }
        }
        // Returns null if solution not found.
        return null;
    }
}
