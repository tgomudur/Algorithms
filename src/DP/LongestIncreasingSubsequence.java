package DP;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    // Time : O(n^2)
    // Space : O(n)
    public void findLengthOfLIS(int[] nums) {
        int n = nums.length;
        int lengthOfLIS = 0;
        if (n != 0) {
            // The table[i] holds the length of the LIS at i.
            int[] table = new int[n];
            table[0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    // Condition (nums[j] < nums[i]) ensures its increasing
                    // Condition (table[i] < table[j] + 1) ensure that length of LIS at i is less than or equal length of LIS
                    // at j. This ensures that there is an increasing subsequence before i whose length is greater than or
                    // equal to the current increasing subsequence at i.
                    if (nums[j] < nums[i] && table[i] <= table[j]) {
                        table[i] = table[j];
                    }
                }
                // Add ith element to the length before moving to next
                table[i] += 1;
            }
        }
    }
}

