package String;

/**
 * Created by tharun on 7/19/2017.
 * https://leetcode.com/problems/regular-expression-matching/#/description
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "a*") ? true
 * isMatch("aa", ".*") ? true
 * isMatch("ab", ".*") ? true
 * isMatch("aab", "c*a*b") ? true
 */

public class RegexMatcher {
    // Recursive solution
    public boolean isMatch(String inputStr, String pattern) {
        if (pattern.isEmpty())
            return inputStr.isEmpty();
        // If second character is '*', either inputStr matches with empty or inputStr matches with xx*
        if (pattern.length() > 1 && pattern.charAt(1) == '*')
            return isMatch(inputStr, pattern.substring(2)) ||
                   !inputStr.isEmpty() && (inputStr.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.') &&
                            isMatch(inputStr.substring(1), pattern);
        else
            return !inputStr.isEmpty() && (inputStr.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.') &&
                    isMatch(inputStr.substring(1), pattern.substring(1));
    }

    // DP solution
    public boolean isMatchDP(String inputStr, String pattern) {
        int nRows = inputStr.length(), nCols = pattern.length();
        boolean[][] table = new boolean[nRows + 1][nCols + 1];

        table[0][0] = true;
        for (int row = 1; row <= nRows; row++)
            table[row][0] = false;

        for (int col = 1; col <= nCols; col++)
            table[0][col] = col > 1 && pattern.charAt(col - 1) == '*' && table[0][col - 2];

        for (int row = 1; row <= nRows; row++) {
            for (int col = 1; col <= nCols; col++) {
                if (pattern.charAt(col - 1) == '*')
                    table[row][col] = table[row][col - 2] ||
                                    (inputStr.charAt(row - 1) == pattern.charAt(col - 2) || pattern.charAt(col - 2) == '.') &&
                                    table[row - 1][col];
                else
                    table[row][col] = table[row - 1][col - 1] &&
                                    (inputStr.charAt(row - 1) == pattern.charAt(col - 1) || pattern.charAt(col - 1) == '.');
            }
        }

        return table[nRows][nCols];
    }
}
