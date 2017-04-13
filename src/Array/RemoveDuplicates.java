package Array;

/**
 * Remove Duplicates
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description
 */

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int insertIdx = 1;
        for (int i = 1; i < nums; i++) {
            if (nums[i] != nums[i - 1]) nums[insertIdx++] = nums[i];
        }
        return insertIdx;
    }
}
