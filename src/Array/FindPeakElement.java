package Array;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * https://leetcode.com/problems/find-peak-element/#/description
 */

public class FindPeakElement {
    // Time : O(logn)
    // Space : O(1)
    public int findPeak(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid1, mid2;

        while (left < right) {
            mid1 = (left + right)/2;
            mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2])
                left = mid2;
            else
                right = mid1;
        }

        return left;
    }

    public int findPeakElement(int[] nums) {
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] > prev && nums[i] > nums[i + 1]) {
            return i;
        }
        prev = nums[i];
        }
        return nums.length - 1;
    }
}
