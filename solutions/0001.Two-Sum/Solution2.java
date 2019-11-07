class Solution {
    /**
     * Complexity Analysis:
     * TC: O(n)
     * SC: O(n)
     * */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int remain = target - map.get(nums[i]);
            if (map.containsKey(remain) && map.get(remain) != i)
                return new int[] {i, map.get(remain)};
        }
        // returns null if solution not found.
        return null;
    }
}
