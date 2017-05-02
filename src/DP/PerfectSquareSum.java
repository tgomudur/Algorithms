package DP;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * https://leetcode.com/problems/perfect-squares/#/description
 */
public class PerfectSquareSum {
    public int numSquares(int n) {
        // table[n] is the least number of perfect squares needed to form the sum n.
        int[] table = new int[n + 1];
        Arrays.fill(table. Integer.MAX_VALUE);
        table[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                table[i] = Math.min(table[i], table[i - j*j] + 1);
            }
        }
        return table[n];
    }
}
