public class Solution2 {
    // using the idea of the bucketSort
    /*
    Complexity Analysis:
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int arrayPairSum(int[] nums) {

        if (nums.length % 2 != 0)
            throw new IllegalArgumentException();

        int[] bucket = new int[20001];
        int maxElemt = Integer.MIN_VALUE;
        int minElemt = Integer.MAX_VALUE;

        for (int num : nums) {
            bucket[num + 10000]++;
            if (num > maxElemt)
                maxElemt = num;
            if (num < minElemt)
                minElemt = num;
        }

        int result = 0;
        minElemt += 10000;  // offset is 10000
        maxElemt += 10000;
        boolean isOdd = true;
        for (int i = minElemt; i <= maxElemt; i++) {
            if (bucket[i] > 0) {
                for (int j = 0; j < bucket[i]; j++) {
                    if (isOdd)
                        result += (i - 10000);
                    isOdd = !isOdd;
                }
            }
        }
        return result;
    }
} 
