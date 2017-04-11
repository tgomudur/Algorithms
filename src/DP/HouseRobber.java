package DP;

public class HouseRobber {
    // Time : O(n). Space : O(n)
    public int rob(int[] nums) {
        int[][] table = new int[nums.length + 2][2];
        for (int i = 2; i < nums.length; i++) {
            table[i][0] = Math.max(table[i - 1][0], table[i - 1][1]);
            table[i][1] = nums[i - 2] + Math.max(table[i - 2][0], table[i - 2][1]);
        }
        return Math.max(table[nums.length  - 1][0], table[nums.length  - 1][1]);
    }

    // Time : O(n) Space : O(n)
    public int robEfficient(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        int temp = 0;
        for (int num : nums) {
            temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
