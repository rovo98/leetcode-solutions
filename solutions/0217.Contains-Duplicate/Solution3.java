class Solution {
    /*
    one iteration(sorting the given array) approach
    Complexity Analysis:
        Time complexity: O(n log n)
        Space complexity: O(1)
    */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) return false;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] == nums[i+1])
                    return true;
        }
        return false;
    }
}
