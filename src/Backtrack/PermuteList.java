package Backtrack;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * https://leetcode.com/problems/permutations/#/description
 */
public class PermuteList {
    public List<List<Integer>> permute(int[] nums) {
        return permute(new ArrayList<List<Integer>>(), nums, 0, nums.length - 1);
    }

    // Time : O(n*n!). n! permutations and n to convert each permutation to list
    // Space: O(n) call stack.
    public List<List<Integer>> permute(List<List<Integer>> result, int[] nums, int left, int right) {
        if (left == right) {
            result.add(convertToList(nums));
        } else {
            for (int i = left; i <= right; i++) {
                swap(nums, left, i);
                permute(result, nums, left + 1, right);
                swap(nums, left, i);
            }
        }
        return result;
    }

    public List<Integer> convertToList(int[] nums) {
        List<Integer> newList = new ArrayList<>();
        for (int num : nums) {
            newList.add(num);
        }
        return newList;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
