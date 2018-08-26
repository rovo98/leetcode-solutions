package Array.Easy;

/**
 * Problem : Acceptance: 58.0%
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix
 * into a new one with different size but keep its original data.
 *
 * You're given a matrix represented by a two-dimensional array, and two positive integers
 * r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same
 * row-traversing order as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped
 * matrix; Otherwise, output the original matrix.
 *
 * Example 1:
 * Input :
 * nums =
 * [[1, 2],
 *  [3, 4]]
 *  r = 1, c = 4
 *
 *  Output :
 *  [[1, 2, 3, 4]]
 *  Explanation :
 *  The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix,
 *  fill it row by using the previous list.
 *
 *  Example 2:
 *  Input :
 *  [[1, 2],
 *   [3, 4]]
 *   r = 2, c = 4
 *  Output:
 *   [[1, 2],
 *    [3, 4]]
 *  Explanation:
 *    There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original
 *    matrix.
 *
 *  Note :
 *     1. The height and width of the given matrix is in range[1, 100]
 *     2. The given r and c are all positive.
 * @author rovo98
 * Date: 01/2/2018
 */
public class ReshapeTheMatrix {
    // Solution one: ^
    // This algorithm's time complexity is O(n) and space complexity is also O(n).
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;

        if ((rows*cols) == r*c) { // If the matrix can be reshaped.
            int[][] newMatrix = new int[r][c];
            int[] translation = new int[rows*cols];

            // using the translation array to store the original data in the input array.
            for (int i=0,j=0; i<nums.length;i++) {
                for (int k=0; k<nums[0].length; k++) {
                    translation[j++] = nums[i][k];
                }
            }
            // then reshape the matrix.
            for (int i=0,j=0; i<newMatrix.length; i++) {
                for (int k=0; k<newMatrix[0].length; k++) {
                    newMatrix[i][k] = translation[j++];
                }
            }
            // return the result.
            return newMatrix;
        }
        //Otherwise, print the information, then return the original matrix.
        System.out.println("There is no way to reshape a "+rows+" * "+cols+
                                " matrix to a "+r+" * "+c+" matrix!");
        return nums;
    }
    public void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            System.out.print("[");
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[0].length-1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]\n");
        }
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        ReshapeTheMatrix rstm = new ReshapeTheMatrix();
        int[][] testArr = {{1, 2}, {3, 4}};

        int[][] newMatrix = rstm.matrixReshape(testArr, 1, 4);

        System.out.println("The original matrix:");
        rstm.printMatrix(testArr);
        // print the matrix after reshape.
        System.out.println("The matrix is following after calling the method:");
        rstm.printMatrix(newMatrix);
    }
}
