package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tharun on 7/24/2017.
 * Three Sum with no duplicate solutions
 * https://leetcode.com/problems/3sum/#/description
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            List<List<Integer>> twoSumSolutions = twoSum(nums, i + 1, n - 1, 0 - nums[i]);
            for (List<Integer> result : twoSumSolutions) {
                List<Integer> solution = new ArrayList<>(result);
                solution.add(0, nums[i]);
                solutions.add(solution);
            }
        }
        return solutions;
    }

    private List<List<Integer>> twoSum(int[] nums, int left, int right, int target) {
        int currentSum = 0, n = nums.length;
        List<List<Integer>> twoSumSolutions = new ArrayList<>();
        while (left < right) {
            currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                twoSumSolutions.add(Arrays.asList(nums[left], nums[right]));
                do {
                    left++;
                } while (left < n && nums[left] == nums[left - 1]); // check current left and previous left
                do {
                    right--;
                } while (right >= 0 && nums[right] == nums[right + 1]); // check current right and previous right
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return twoSumSolutions;
    }


}
