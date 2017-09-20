package Array;

/**
 * Created by tharun on 9/19/2017.
 * https://leetcode.com/problems/first-missing-positive/description/
 */

public class FirstMissingPositive {
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findMissingPositive(int[] nums) {
        int n = nums.length;
        if (n != 0) {
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] < 0 || i != nums[i] - 1)
                    return i + 1;
            }
        }
        return n + 1;
    }
}
