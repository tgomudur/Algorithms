package HashMap;

/**
 * Created by tharun on 4/4/17.
 * https://leetcode.com/problems/valid-anagram/#/description
 * <p>Given two strings s and t, write a function to determine if t is an anagram of s.
 * Note: You may assume the string contains only lowercase alphabets
 * </p>
 */
public class ValidAnagram {
    // Time Complexity: O(n) Space Complexity: O(k). k is the character space. In this case where it contains
    // only lowercase letters. Space complexity is O(1)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++)
            charCount[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++) {
            charCount[t.charAt(i) - 'a']--;
            if (charCount[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
