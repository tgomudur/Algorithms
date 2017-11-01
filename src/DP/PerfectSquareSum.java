package DP;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * https://leetcode.com/problems/perfect-squares/#/description
 */

import java.util.*;

public class PerfectSquareSum {
    // Good explanation:
    //    dp[0] = 0
    //    dp[1] = dp[0]+1 = 1
    //    dp[2] = dp[1]+1 = 2
    //    dp[3] = dp[2]+1 = 3
    //    dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
    //      = Min{ dp[3]+1, dp[0]+1 }
    //      = 1
    //    dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
    //      = Min{ dp[4]+1, dp[1]+1 }
    //      = 2
    //              .
    //              .
    //              .
    //    dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
    //       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
    //       = 2
    //               .
    //               .
    //               .
    //    dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
    // Time : O(n*sqrt(n))
    // Space : O(n)
    public int numSquares(int n) {
        // table[n] is the least number of perfect squares needed to form the sum n.
        int[] table = new int[n + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                table[i] = Math.min(table[i], table[i - j*j] + 1);
            }
        }
        return table[n];
    }
}
