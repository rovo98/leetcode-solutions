class Solution1 {
    /**
    time complexity: O(n)
    space complexity: O(n)
    */
    public int[] sortArrayByParityII(int[] A) {
        
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        
        for (int n : A) {
            if (n % 2 == 0)
                even.add(n);
            else 
                odd.add(n);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                result[i] = even.remove(0);
            } else {
                result[i] = odd.remove(0);
            }
        }
        return result;
    }
}
