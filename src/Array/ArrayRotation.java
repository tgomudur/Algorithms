package Array;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <a href=https://leetcode.com/problems/rotate-array/#/description>More Info</a>
 */
public class ArrayRotation {
    public void reverse(int[] nums, int left, int right) {
        int tmp = 0;
        while (left < right) {
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return;
        int minRotations = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, minRotations - 1);
        reverse(nums, minRotations, n - 1);
    }
}
