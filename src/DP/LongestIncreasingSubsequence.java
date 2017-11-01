package DP;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
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

    // Time : O(nlogn)
    // Space : O(n)
    public int findLengthOfLISEfficient(int[] nums) {
        int lengthOfLIS = 0;
        int n = nums.length;
        if (n != 0) {
            // tails[i] is the smallest tail element of the LIS of length i.
            // for each num we do
            // if (num > all tails), then append it
            // if (tails[i - 1] < num <= tails[i]), then update tails[i] with num;
            int[] tails = new int[n];
            int insertIdx = 0;
            for (int num : nums) {
                insertIdx = binarySearch(tails, 0, lengthOfLIS, num);
                tails[insertIdx] = num;
                if (insertIdx == lengthOfLIS) lengthOfLIS++;
            }
        }
        return lengthOfLIS;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right)/2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

