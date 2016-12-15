package String;

/**
 * Created by tharun on 12/15/16.
 */
class Solution {
    public String findLongestPalindromicSubString(String s){
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
        System.out.println(s.findLongestPalindromicSubString("abcdea"));
    }

}
