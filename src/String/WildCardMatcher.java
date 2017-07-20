package String;

/**
 * Created by tharun on 7/19/2017.
 * <p>Implement wildcard pattern matching with support for '?' and '*'.</p>
 * '?' Matches any single character. <br/>
 * '*' Matches any sequence of characters (including the empty sequence). <br/>
 * The matching should cover the entire input string (not partial). <br/>
 * The function prototype should be: <br/>
 * bool isMatch(const char *s, const char *p) <br/>
 *
 * Some examples: <br/>
 * isMatch("aa","a") ? false <br/>
 * isMatch("aa","aa") ? true <br/>
 * isMatch("aaa","aa") ? false <br/>
 * isMatch("aa", "*") ? true <br/>
 * isMatch("aa", "a*") ? true <br/>
 * isMatch("ab", "?*") ? true <br/>
 * isMatch("aab", "c*a*b") ? false <br/>
 */
public class WildCardMatcher {
    // Recursive Solution
    public boolean isMatch(String inputStr, String pattern) {
        if (pattern.isEmpty())
            return inputStr.isEmpty();

        if (pattern.charAt(0) == '*')
            return !inputStr.isEmpty() && isMatch(inputStr.substring(1), pattern) || isMatch(inputStr, pattern.substring(1));
        else
            return !inputStr.isEmpty() && (inputStr.charAt(0) == pattern.charAt(1) || pattern.charAt(1) == '?') && isMatch(inputStr.substring(1), pattern.substring(1));
    }

    // DP Solution

    public boolean isMatchDP(String inputStr, String pattern) {
        int nRows = inputStr.length(), nCols = pattern.length();
        boolean[][] table = new boolean[nRows + 1][nCols + 1];

        table[0][0] = true;
        for (int col = 1; col <= nCols; col++) {
            if (pattern.charAt(col - 1) != '*') break;
            else table[0][col] = (pattern.charAt(col - 1) == '*');
        }

        for (int row = 1; row <= nRows; row++) {
            for (int col = 1; col <= nCols; col++) {
                if (pattern.charAt(col - 1) == '*')
                    table[row][col] = table[row][col - 1] || table[row - 1][col];
                else if (inputStr.charAt(row - 1) == pattern.charAt(col - 1) || pattern.charAt(col - 1) == '?')
                    table[row][col] = table[row - 1][col - 1];
                else
                    table[row][col] = false;
            }
        }
        return table[nRows][nCols];
    }

    // TODO: Greedy solution.
}
