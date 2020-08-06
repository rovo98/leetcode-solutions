class Solution {
    /**
    brute-force approach:
            time complexity: O(n^2)
            space complexity: O(n)
    */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        
        for (int i = 0; i < T.length; i++) {
            for (int j = i+1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
