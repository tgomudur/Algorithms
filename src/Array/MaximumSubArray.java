package Array;

/**
 * <p>Maximum Subarray</p>
 * <a href="https://leetcode.com/problems/maximum-subarray/#/description"> More Info</a>
 */
public class MaximumSubArray {
    public int findMaxSubArraySum(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }
}
