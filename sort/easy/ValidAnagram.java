package Sort.Easy;


/**
 * Problem: Acceptance: 47.2%
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note :
 *    You may assume the string contains only lowercase alphabets.
 *
 *
 * Follow up:
 *   What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 *
 * @author rovo98
 * Date: 17/2/2018
 */
public class ValidAnagram {
    // Solution one: ^
    // Using selectionSort、bubbleSort、insertionSort or shellSort.
    /*
    Complexity Analysis:
    Time complexity: O(n^2/3) ? it's depended on the increasing sequence for shell sorting.
    space complexity: O(1).
     */
    public boolean isAnagram(String s, String t) {
        /*
        Compare the length of two strings firstly. If they are different, return false.
        Otherwise, comparing their sorted string for further.
         */
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        StringBuilder sBuilder = new StringBuilder(s);
        StringBuilder tBuilder = new StringBuilder(t);
        int h = 1;
        while (h < n/3) {
            h = 3 * h + 1;  // 1, 4, 13, 40, 121, 364, ...
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (sBuilder.charAt(j) < sBuilder.charAt(j-h)) {
                        char temp = sBuilder.charAt(j);
                        sBuilder.setCharAt(j, sBuilder.charAt(j-h));
                        sBuilder.setCharAt(j-h, temp);
                    }
                    if (tBuilder.charAt(j) < tBuilder.charAt(j-h)) {
                        char temp = tBuilder.charAt(j);
                        tBuilder.setCharAt(j, tBuilder.charAt(j-h));
                        tBuilder.setCharAt(j-h, temp);
                    }
                }
            }
            h /= 3;
        }
//        System.out.println(sBuilder.toString() + " compareTo " + tBuilder.toString());
        return sBuilder.toString().equals(tBuilder.toString());
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String testStr1 = "anagram";
        String testStr2 = "nagaram";
        if (va.isAnagram(testStr1, testStr2)) {
            System.out.println(testStr2 +  " is an anagram of " + testStr1 + ".");
        } else {
            System.out.println(testStr2 + " is not an anagram of " + testStr1 + ".");
        }
        String testStr3 = "rat";
        String testStr4 = "car";
        if (va.isAnagram(testStr3, testStr4)) {
            System.out.println(testStr4 + " is an anagram of " + testStr3 + ".");
        } else {
            System.out.println(testStr4 + " is an anagram of " + testStr3 + ".");
        }
    }
}
