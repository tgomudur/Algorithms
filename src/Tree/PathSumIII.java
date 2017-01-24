package Tree;

/**
 * Created by tharun on 1/23/17.
 * Problem description : https://leetcode.com/problems/path-sum-iii/
 */

public class PathSumIII {
    // Time Complexity : O(n) Space Complexity : O(n)
    public int findPathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        // Map <prefixSum, Number of paths to reach this sum>
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return pathSumHelper(root, 0, sum, preSum);
    }

    public int pathSumHelper(TreeNode root, int sum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) return 0;

        // Update prefixSum
        sum += root.val;
        // Get the number of valid path, ended by the current node
        int result = preSum.getOrDefault(sum - target, 0);

        // Update the map with the current sum, so the map is good to be passed to the next recursion
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        result += pathSumHelper(root.left, sum, target, preSum) + pathSumHelper(root.right, sum, target, preSum);

        // Restore the map, as the recursion goes from the bottom to the top
        preSum.put(sum, preSum.get(sum) - 1);

        return result;
    }

    // Time Complexity : O(n^2), Space complexity : O(1)
    public int findPathSum1(BinarySearchTreeNode<Integer> root, int sum) {
        if (root == null) return 0;
        return findPathSumFrom(root, sum) + findPathSum1(root.left, sum) + findPathSum1(root.right, sum);
    }

    public int findPathSumFrom(BinarySearchTreeNode<Integer> root, int sum) {
        if (root == null) return 0;
        return ((root.getData() == sum)? 1 : 0) + findPathSumFrom(root.left, sum - root.getData()) + findPathSumFrom(root.right, sum - root.getData());
    }
}

