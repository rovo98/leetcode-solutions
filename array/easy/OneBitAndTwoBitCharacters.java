package Array.Easy;

/**
 * Problem : Acceptance: 49.7%
 *
 * We have two special characters. The first character can be represented by
 * one bit 0. The second character can be represented by two bits(10 or 11).
 *
 * Now given a string represented by several bits. Return whether the last character
 * must be a one-bit character or not.
 * The given string will always end with a zero.
 *
 * Example 1:
 *
 * Input :
 * bits = [1, 0, 0]
 * Output : True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character.
 * So the last character is one-bit character.
 *
 * Example 2:
 *
 * Input :
 * bits = [1, 1, 1, 0]
 * Output : False
 * Explanation :
 * The only way to decode it is two-bit character and two-bit character.
 * So the last character is NOT one-bit character.
 *
 * Note :
 *    1. 1 <= len(bits) <= 1000.
 *    2. bits[i] is always 0 or 1.
 *
 * @author rovo98
 * Date: 01/2/2018
 */
public class OneBitAndTwoBitCharacters {
    // Solution one: ^
    // This algorithm's time complexity is O(n).
    public boolean isOneBitCharacter(int[] bits) {
        // record how many steps left while doing the decoding process.
        // decoding process:
        // when we meet 1, we walk 2 steps. reset the steps to steps -= 2;
        // when we meet 0, we walk 1 step. reset the steps to steps -= 1;
        int steps = bits.length;
        for (int i=0; i<bits.length; i++) {
            if (bits[i] == 1) {
                if (steps == 2) { // If the steps are 2 left.
                    return false;
                }
                steps -= 2;
                i += 1;
            }
            else {
                if (steps == 1) { // If the steps is now 1 left.
                    return true;
                }
                steps -= 1;
            }
        }
        return false;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        OneBitAndTwoBitCharacters obatbc  = new OneBitAndTwoBitCharacters();
        int[] testBits = {1, 0, 0, 1, 0, 0};
        boolean result = obatbc.isOneBitCharacter(testBits);
        System.out.println("The input bits is the following:");
        for (int i=0; i<testBits.length; i++) {
            System.out.print(testBits[i]+" ");
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("The output is: "+result);
    }
}
