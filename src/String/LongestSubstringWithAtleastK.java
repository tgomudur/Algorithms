package String;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 * Input:
 * s = "ababbc", k = 2
 * Output:
 * 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/#/description
 */

public class LongestSubstringWithAtleastK {
    public int longestSubstringIterative(String s, int k) {
        int maxLength = 0;
        for (int numUniqueChar = 0; numUniqueChar < 26; numUniqueChar++) {
            maxLength = Math.max(maxLength, longestSubstringIterativeHelper(s, k, numUniqueChar));
        }
        return maxLength;
    }

    public int longestSubstringIterativeHelper(String s, int k, int numUniqueCharTarget) {
        int end = 0, begin = 0, numUniqueChars = 0, numCharsNoLessThanK = 0;
        int maxLength = 0;
        int[] count = new int[26];
        while (end < s.length()) {
            if (count[s.charAt(end)]++ == 0) numUniqueChars++;
            if (count[s.charAt(end++)] == k) numCharsNoLessThanK++;

            while (numUniqueChars > numUniqueCharTarget) {
                if (count[s.charAt(begin)]-- == k) numCharsNoLessThanK--;
                if (count[s.charAt(begin++)] == 0) numUniqueChars--;
            }

            if (numUniqueChars == numUniqueCharTarget && numUniqueChars == numCharsNoLessThanK) {
                maxLength = Math.max(maxLength, end - begin);
            }
        }
        return maxLength;
    }


    // Divide and Conquer
    // Time : O(n)
    // Space: O(26)
    public int longestSubstringDC(String s, int k) {
        return longestSubstringDCHelper(s.toCharArray(), k, 0, s.length());
    }

    public int longestSubstringDCHelper(char[] s, int k, int start, int end) {
        if (end - start > k)
            return 0;

        int[] count = new int[26];
        for (int i = start; i < end; i++)
            count[s[i] - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) {
                for (int j = start; j < end; j++) {
                    int left = longestSubstringDCHelper(s, k, start, j);
                    int right = longestSubstringDCHelper(s, k, j + 1, end);
                    return Math.max(left, right);
                }
            }
        }
        return end - start;
    }
}
