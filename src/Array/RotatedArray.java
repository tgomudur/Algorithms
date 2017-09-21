package Array;

/**
 * Created by tharun on 1/3/17.
 * Problem description: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class RotatedArraySolution {
    public int findRotationIndex(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = 0;
        while (left < right) {
            if (nums[left] < nums[right]) return left;
            mid = (left + right)/2;
            if (nums[left] <= nums[mid])
                left = mid + 1;
            else right = mid ;
        }
        return left;
    }

    public int searchInRotatedArray(int[] nums, int target) {
        int rotationIdx = findRotationIndex(nums);
        int left = 0, right = nums.length - 1;
        int n = nums.length;
        int mid = 0, realMid = -1;
        while (left <= right) {
            mid = (left + right)/2;
            realMid = (mid + rotationIdx)%n;
            if (nums[realMid] == target) return realMid;
            else if (nums[realMid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Using modified binary search. Time : O(logn), Space : O(1)
    public int searchInRotatedArraySinglePass(int[] nums, int target) {
        int n = nums.length;
        int mid, left = 0, right = n - 1;
        while (left <= right) {
            mid = (left + right)/2;
            if (nums[mid] == target)
                return mid;

            // Is the left have sorted?
            if (nums[left] <= nums[mid]) {
                // Is target values within this range
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
public class RotatedArray {
    public static void main(String[] args) {
        RotatedArraySolution s = new RotatedArraySolution();
        int[] nums = { 4, 5, 6, 1, 2, 3};
        System.out.println(s.findRotationIndex(nums));
        System.out.println(s.searchInRotatedArray(nums, 2));

    }
}

