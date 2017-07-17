package String;

/**
 * Created by tharun on 12/15/16.
 * https://leetcode.com/problems/longest-palindromic-substring/#/description
 */
class Solution {
    // Expanding centers
    // Time : o(n^2)
    // Space : O(1)
    public String findLongestPalindromicSubString(String inputStr) {
        int n = inputStr.length();

        if (n == 0 || n == 1) return inputStr;

        String s = "$" + inputStr + "#";
        int current = 1;
        int left, right, currentLen, maxLen = 0;
        int start = 0;

        while (current <= n){
            left = current - 1;
            right = current + 1;
            currentLen = 1;
            while (s.charAt(left) != '$' && s.charAt(right) != '#'){

                if (s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                    currentLen += 2;
                }else
                    break;
            }
            if (currentLen > maxLen){
                maxLen = currentLen;
                start = current - maxLen/2;
            }

            left = current;
            right = current + 1;
            currentLen = 0;
            while (s.charAt(left) != '$' && s.charAt(right) != '#'){
                if (s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                    currentLen += 2;
                }else
                    break;
            }
            if (currentLen > maxLen){
                maxLen = currentLen;
                start = (current + 1) - maxLen/2;
            }
            current++;
        }
        return s.substring(start, start + maxLen);

    }

    // Simplified expanding centers solution
    public boolean isWithinBounds(String s, int left, int right) {
        return (s.charAt(left) != '#' && s.charAt(right) != '$');
    }

    public int expandOutFromCenter(String s, int center, boolean isOdd) {
        int right = center + 1;
        int left = (isOdd)? center - 1 : center;
        int currLen = (isOdd)? 1 : 0;
        while (isWithinBounds(s, left, right)) {
            if (s.charAt(left--) == s.charAt(right))
                currLen += 2;
            else break;
        }
        return currLen;
    }

    // Time : O(n^2)
    // Space : O(1)
    public String findLongestPalindromicSubStringSimplified(String inputStr) {
        String s = "#" + inputStr + "$";
        int center = 0, n = s.length();
        int currLenOdd = 0, currLenEven = 0, maxLen = 1, maxStartIdx = 0;
        while (center < n) {
            currLenOdd = expandOutFromCenter(s, center, true);
            currLenEven = expandOutFromCenter(s, center, false);
            if (currLenOdd > maxLen) {
                maxLen = currLenOdd;
                maxStartIdx = center + currLenOdd/2 - 1;
            }
            if (currLenEven > maxLen) {
                maxLen = currLenEven;
                maxStartIdx = center + currLenEven/2;
            }
            center++;
        }
        return inputStr.substring(maxStartIdx, maxStartIdx + maxLen);
    }

        // Using DP
    public String findLongestPalindromicSubStringDP(String s){
        int n = s.length();
        boolean[][] table = new boolean[n][n];
        int startIdx = 0;
        int maxLen = 1;
        int j;

        if (n == 1) return s;

        for (int x = 0; x < n;  x++){
            table[x][x] = true;
        }

        for (int x = 0; x < n - 1; x++){
            if (s.charAt(x) == s.charAt(x+1)){
                table[x][x+1] = true;
                startIdx = x;
                maxLen = 2;
            }
        }

        for (int windowSize = 3; windowSize <= n; windowSize++){
            for (int i = 0; i < n - windowSize + 1; i++){
                j = windowSize - 1 + i;
                if (table[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    table[i][j] = true;
                    if (windowSize > maxLen){
                        maxLen = windowSize;
                        startIdx = i;
                    }
                }
            }
        }
        return s.substring(startIdx, startIdx + maxLen);
    }
}

public class LongestSubString {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.findLongestPalindromicSubString("abceaa"));

    }

}
