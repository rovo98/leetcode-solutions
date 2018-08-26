package Array.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem : Acceptance: 39.6%
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 * [
 *       [1]
 *      [1,1]
 *     [1,2,1]
 *    [1,3,3,1]
 *   [1,4,6,4,1]
 * ]
 *
 * @author rovo98
 * Date: 12/2/2018
 */
public class PascalTriangle {
    // Solution one: &
    // This algorithm's time complexity is O(n).
    public List<List<Integer>> generate(int numbers) {
        /*
         1. the number of elements to kth level is k.
         2. the first element and last element at every level is 1.
         3. the nth element at level k(k>2) is A[k][n] = A[k-1][n-1] + A[k-1][n];
         */
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numbers; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            for (int j = 1; j < i; j++) {
                level.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }
            if (i > 0) {
                level.add(1);
            }
            list.add(level);
        }
        return list;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        List<List<Integer>> testList = new PascalTriangle().generate(5);

        System.out.println("The PascalTriangle of 5 levels:");
        for (List<Integer> level : testList) {
            for (int e : level) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        System.out.println();;
    }
}
