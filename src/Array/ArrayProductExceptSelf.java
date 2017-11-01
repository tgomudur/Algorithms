package Array;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * https://leetcode.com/problems/product-of-array-except-self/#/description
 */

public class ArrayProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int runningProductBeforeI = 1, runningProductAfterI = 1;
        for (int i = 0; i < n; i++) {
            result[i] = runningProductBeforeI;
            runningProductBeforeI *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] *= runningProductAfterI;
            runningProductAfterI *= nums[i];
        }
        return result;
    }
}
