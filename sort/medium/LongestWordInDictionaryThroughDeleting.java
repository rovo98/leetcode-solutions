package Sort.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Acceptance: 43.5%
 *
 * Given a string and a string dictionary, find the longest string in the dictionary that
 * can be formed by deleting some characters of the given string. If there are more than one
 * possible results, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale", "apple", "monkey", "plea"]
 *
 * Output:
 * "apple"
 *
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a", "b", "c"]
 * Output:
 * "a"
 *
 *
 * Note:
 *   1. All the strings in the input will only lower-case letters.
 *   2. The size of the dictionary won't exceed 1,000.
 *   3. The length of all the strings in the input won't exceed 1,000.
 *
 * @author rovo98
 * Date: 2/3/2018
 */
public class LongestWordInDictionaryThroughDeleting {
    // Solution one: ^
    /*
    Complexity Analysis:
        Time complexity: O(n).
        Space complexity: O(1).
     */
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String word : d) {
            for (int i = 0, j = 0; i < s.length() && j < word.length(); i++) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                if (j == word.length()) {
                    if (result.length() < word.length()
                            || (result.length() == word.length()
                                && result.compareTo(word) > 0)) {
                        result = word;
                    }
                }
            }
        }
        return result;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeleting lwidtd = new LongestWordInDictionaryThroughDeleting();
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        System.out.println("The input test dictionary is the following:");
        for (String word : d) {
            System.out.print(word + " ");
        }
        System.out.println();
        System.out.println("And the result of it is " + lwidtd.findLongestWord("abpcplea", d) + ".");

    }
}
