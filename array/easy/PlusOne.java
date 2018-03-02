package Array.Easy;

/**
 * Problem : Acceptance: 39.4%
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * @author rovo98
 * Date: 02/2/2018
 */
public class PlusOne {
    // Solution one : ^
    // This algorithm's time complexity is O(n).
    public int[] plusOne(int[] digits) {
        // We can first plus one to the last element in the array,
        // then iterate all the elements from right to left, find out whether each element's value
        // is lower or equals to 9. If not, deal with it.
        digits[digits.length-1] += 1;
        for (int i=digits.length-1; i>0; i--) {
            if (digits[i] > 9) {
                digits[i] = 0;
                digits[i-1] += 1;
            }
        }
        // return the modified array.
        return digits;
    }
    public void printDigits(int[] digits) {
        for (int i=0; i<digits.length; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
    // Driver the program to test the method above.
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] testDigits = {9, 9, 9};
        System.out.println("The input digits is the following: ");
        po.printDigits(testDigits);
        po.plusOne(testDigits);
        System.out.println("After calling the function, the digits is now the following:");
        po.printDigits(testDigits);
    }
}
