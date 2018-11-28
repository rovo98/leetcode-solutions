package HashTable.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American
 * keyboard
 * <p>
 * Example:
 * <p>
 * <p>
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *  
 * <p>
 * Note:
 * <p>
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 * @author rovo98
 * date: 2018.11.28 12:43
 */
public class KeyboardRow {
    // this class can not be instanced.
    private KeyboardRow() {
    }

    /*
    Complexity Analysis:
        Time complexity: O(n)
        Space complexity: O(1)
     */
    private static String[] findWordsVerOne(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String s = word.toLowerCase();
            // get row index of the given string
            int row = 0;
            if (rows[1].contains(String.valueOf(s.charAt(0))))
                row = 1;
            else if (rows[2].contains(String.valueOf(s.charAt(0))))
                row = 2;

            boolean add = true;
            for (int j = 1; j < s.length(); j++) {
                if (!rows[row].contains(String.valueOf(s.charAt(j)))) {
                    add = false;
                    break;
                }
            }
            if (add)
                result.add(word);
        }
        String[] res = new String[result.size()];
        return result.toArray(res);
    }

    /*
    Complexity Analysis:
        Time complexity: O(n)
        Space complexity: O(1)
     */
    private static String[] findWords(String[] words) {
        int[] rows = {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2,
                2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};

        List<String> result = new ArrayList<>();

        for (String word : words) {
            int row = getRow(rows, word.charAt(0));
            int j = 1;

            for (; j < word.length(); j++) {
                if (row != getRow(rows, word.charAt(j)))
                    break;
            }
            if (j == word.length())
                result.add(word);
        }

        String[] r = new String[result.size()];
        return result.toArray(r);
    }

    // get the row number of the given character
    private static int getRow(int[] rows, char c) {
        int row = 0;
        if (c - 'A' < 26 && c - 'A' >= 0)
            row = c - 'A';
        else if (c - 'a' < 26 && c - 'a' >= 0)
            row = c - 'a';
        return rows[row];
    }

    /**
     * Driver the program to test the methods above.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        String[] testStrings = {"Hello", "Alaska", "Dad", "Peace"};

        System.out.println("The input test case is the following:");
        System.out.println("Input: " + Arrays.toString(testStrings));
        System.out.println("Output(ver1): " + Arrays.toString(findWordsVerOne(testStrings)));
        System.out.println("Output(ver2): " + Arrays.toString(findWords(testStrings)));

    }
}
