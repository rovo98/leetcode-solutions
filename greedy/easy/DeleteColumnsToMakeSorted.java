package Greedy.Easy;

/**
 *
 * We are given an array A of N lowercase letter strings, all of the same length.
 *
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
 * The remaining rows of strings form columns when read north to south.
 *
 * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after
 * deletions is ["bef","vyz"], and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  (Formally, the
 * c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)
 *
 * Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in
 * non-decreasing sorted order.
 *
 * Return the minimum possible value of D.length.
 *
 * Example:
 * Input: ["cba","daf","ghi"]
 * Output: 1
 * Explanation:
 * After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
 * If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.
 *
 * @author rovo98
 * date: 2018.11.27 12:09
 */
public class DeleteColumnsToMakeSorted {
    /**
     * private empty constructor
     *
     * this class can not be instanced.
     */
    private DeleteColumnsToMakeSorted() {}

    /**
     * Returns the minimum possible value of {@code D.length}
     * @param A The array contains all the strings
     * @return the minimum possible value of {@code D.length}
     */
    /*
    Complexity Analysis:
        Time complexity: O(X) X is the total content of A.
        Space complexity: O(1)
     */
    private static int minDeletionSize(String[] A) {
        int count = 0;

        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length-1; j++) {
                if (A[j].charAt(i) > A[j+1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * Driver the program to test the method above.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        String[] test = {"cba", "daf", "ghi"};
        System.out.println("The input test case is the following:");
        for (String s : test) {
            System.out.print(s + ",");
        }
        System.out.println("\nAnd the output result is " + minDeletionSize(test) + ".");
    }
}
