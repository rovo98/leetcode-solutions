package Stack.Medium;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

/**
 * Problem: Acceptance: 42.0%
 *
 * Given an encoded string,return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra while spaces, square brackets
 * are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that
 * digits are only for those repeat numbers, k. For example, there won't be input like
 * 3a or 2[4].
 *
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc"
 * s = "3[a2[c]]", return "accaccacc"
 * s = "2[abc]3[cd]ef, return "abcabccdcdcdef"
 *
 * @author rovo98
 * Date: 22/2/2018
 */
public class DecodeString {
    // Solution one: ^
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(n).
     */
    public String decodeString(String s) {
        Stack<String> stack = new LinkedStack<>();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                String str = "";
                while (!stack.peek().equals("[")) {
                    str = stack.pop().concat(str);
                }
                stack.pop();            // Remove the character '[' from stack.
                int times = Integer.parseInt(stack.pop());
                String rs = "" +  str;  // the string to be repeated.

                for (int t = 1; t < times; t++) { // repeat the str k times.
                    str = str.concat(rs);
                }
                stack.push(str);
            } else {
                stack.push("" + c);
            }
        }
        while (!stack.isEmpty()) {
            result = stack.pop().concat(result);
        }
        return result;
    }


    // Driver the program to test the method above.
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String testStr1 = "3[a]2[bc]";
        String testStr2 = "3[a2[c]]";
        String testStr3 = "2[abc]3[cd]ef";
        System.out.println("The result for the string " + testStr1 + " is " + ds.decodeString(testStr1) + ".");
        System.out.println("The result for the string " +  testStr2 + " is " + ds.decodeString(testStr2) + ".");
        System.out.println("The result for the string " + testStr3 + " is " + ds.decodeString(testStr3) + ".");
    }
}
