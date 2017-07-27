package Array;

import java.util.Arrays;

/**
 * Created by tharun on 7/26/2017.
 * https://leetcode.com/problems/3sum-closest/#/description
 */
public class ThreeSumClosest {
    // Time : O(n^2)
    // Space : O(1)
    public int threeSumClosest(int[] nums, int target) {
        int currentSum, n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[n - 1];
        int left, right;

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            left = i + 1;
            right = n - 1;
            while (left < right) {
                currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum))
                    closestSum = currentSum;

                if (currentSum == target)
                    return target;
                else if (currentSum < target)
                    left++;
                else
                    right--;
            }
        }
        return closestSum;
    }
}
