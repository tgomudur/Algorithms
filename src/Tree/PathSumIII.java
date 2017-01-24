package Tree;

/**
 * Created by tharun on 1/23/17.
 * Problem description : https://leetcode.com/problems/path-sum-iii/
 */

public class PathSumIII {
    // Time Complexity : O(n^2), Space complexity : O(1)
    public int findPathSum(BinarySearchTreeNode<Integer> root, int sum) {
        if (root == null) return 0;
        return findPathSumFrom(root, sum) + findPathSum(root.left, sum) + findPathSum(root.right, sum);
    }

    public int findPathSumFrom(BinarySearchTreeNode<Integer> root, int sum) {
        if (root == null) return 0;
        return ((root.getData() == sum)? 1 : 0) + findPathSumFrom(root.left, sum - root.getData()) + findPathSumFrom(root.right, sum - root.getData());
    }
}

