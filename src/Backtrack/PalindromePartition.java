package Backtrack;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * https://leetcode.com/problems/palindrome-partitioning/#/description
 */

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backTrack(s, result, current, 0);
        return result;
    }

    // Time : O (n^2 + 2^n)
    // Space : O(n^2)
    public List<List<String>> partitionEfficient(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        int n = s.length();

        // Instead of checking whether a substring is palindrome or not
        // Precompute and store the result.
        // table[i][j] indicates whether substring of s from i to j is a palindrome or not
        boolean[][] table = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || table[j + 1][i - 1]))
                    table[j][i] = true;
            }
        }
        backTrack(s, result, current, 0, table);
        return result;
    }

    // Time : O(2^n)
    // Space : O(n^2). For the dp table
    public void backTrack(String s, List<List<String>> result, List<String> current, int startIndex, boolean[][] table) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = startIndex; i < s.length(); i++) {
                if (table[i][startIndex]) {
                    current.add(s.substring(startIndex, i + 1));
                    backTrack(s, result, current, i + 1, table);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
    // Normal DFS
    // Time : O(n * 2^n) - 2^n partitions and for each partition finding isPalindrom takes O(n)
    // Space: O(n)- Size of call stack. Not counting space required to store result
    public void backTrack(String s, List<List<String>> result, List<String> current, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = startIndex; i < s.length(); i++) {
                if (isPalindrome(s, startIndex, i)) {
                    current.add(s.substring(startIndex, i + 1));
                    backTrack(s, result, current, i + 1);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    // Time : O(n)
    // Space: O(1)
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
}
