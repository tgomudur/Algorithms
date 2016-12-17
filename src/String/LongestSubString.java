package String;

/**
 * Created by tharun on 12/15/16.
 */
class Solution {
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
