package Array;

/**
 * Created by tharun on 9/19/2017.
 * https://leetcode.com/problems/search-for-a-range/description/
 */

public class SearchRange {
    public int doBinarySearch(int[] nums, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // Time complexity: O(logn*logn)
    // Space complexity ; O(1)
    // Naive approach
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = {-1, -1};

        if (n == 0)
            return result;

        int initialIdx = doBinarySearch(nums, 0, n - 1, target);
        int leftIdx = initialIdx, rightIdx = initialIdx;
        // Keep searching left till you get to the extreme
        while(leftIdx != -1) {
            result[0] = leftIdx;
            leftIdx = doBinarySearch(nums, 0, leftIdx - 1, target);
        }

        // Keep searching right till you get to the extreme
        while(rightIdx != -1) {
            result[1] = rightIdx;
            rightIdx = doBinarySearch(nums, rightIdx, n - 1, target);
        }

        return result;
    }

    // Time complexity : O(logn)
    // Space complexity : O(1)
    // Does two binary searches to find extremes.
    public int[] searchRangeEfficient(int[] nums, int target) {
        int n = nums.length;
        int[] result = {-1, -1};
        if (n == 0)
            return result;

        int mid, left = 0, right = n - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] <  target)
                left = mid + 1;
            else
                right = mid;
        }

        if (nums[left] != target)
            return result;

        result[0] = left;
        right = n - 1;
        while (left < right) {
            // Making it right baised
            mid = ((left + right) / 2) + 1;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }

        result[1] = right;
        return result;
    }
}
