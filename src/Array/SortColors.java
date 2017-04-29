package Array;

/**
 * Created by incyphae10 on 4/29/17.
 */
public class SortColors {
    // Time : O(n);
    // Space : O(m) where m is number of distinct elements
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        int insertIdx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[insertIdx++] = count[i];
                count[i]--;
            }
        }
    }

    // Time : O(n)
    // Space: O(m - 1) where m is number of distinct elements
    public void sortColorsEfficient(int[] nums) {
        int zeroIdx = 0, secondIdx = nums.length - 1;
        for (int i = 0; i <= secondIdx; i++) {
            if (nums[i] == 0 && i != zeroIdx)
                swap(nums, i--, zeroIdx++);
            else if (nums[i] == 2 && i != secondIdx)
                swap(nums, i--, secondIdx--);
        }
    }

}
