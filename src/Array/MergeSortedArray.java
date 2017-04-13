package Array;

/**
 * Merge Sorted Array<
 * <p><strong>Description:</strong> Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <strong>Note:</strong> You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional
 * elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.</p>
 * <a href=https://leetcode.com/problems/merge-sorted-array/#/description>More Info</a>
 */

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int numsIdx1 = m - 1, numsIdx2 = n - 1, insertIdx = m + n - 1;
        while (numsIdx1 >= 0 && numsIdx2 >= 0) {
            if (nums1[numsIdx1] > nums2[numsIdx2]) {
                nums1[insertIdx] = nums1[numsIdx1--];
            } else {
                nums1[insertIdx] = nums2[numsIdx2--];
            }
            insertIdx--;
        }
        while (numsIdx2 >= 0) {
            nums1[insertIdx--] = nums2[numsIdx2--];
        }
    }
}
