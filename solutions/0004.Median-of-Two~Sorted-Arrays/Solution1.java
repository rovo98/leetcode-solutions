class Solution {
    /*
       Complexity Analysis:
       Time complexity: O(m +n )
       Space complexity: O(m + n)
       */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // using the idea of mergeSort
        int m = nums1.length;
        int n = nums2.length;

        int[] merged = new int[m + n];

        int left = 0, right = 0;
        for (int i = 0; i < merged.length; i++) {
            if (left >= m) // no elements left in nums1
                merged[i] = nums2[right++];
            else if (right >= n) // no elements left in nums2
                merged[i] = nums1[left++];
            else if (nums1[left] < nums2[right])
                merged[i] = nums1[left++];
            else
                merged[i] = nums2[right++];
        }
        // if only one element in the merged array.
        if (merged.length == 1)
            return merged[0];

        int mid = merged.length / 2;
        return merged.length % 2 == 0 ? (double)(merged[mid]+merged[mid-1]) /2: (double)(merged[mid]);
    }
}
