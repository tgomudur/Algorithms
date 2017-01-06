package Tree;

/**
 * Created by tharun on 1/4/17.
 * Problem description : https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(BinarySearchTreeNode<Integer> root) {
        maxPathSumUtil(root);
        return maxSum;
    }

    public int maxPathSumUtil(BinarySearchTreeNode<Integer> root) {
        if (root == null) return 0;

        int left = Math.max(maxPathSumUtil(root.getLeft()), 0);
        int right = Math.max(maxPathSumUtil(root.getRight()), 0);

        maxSum = Math.max(maxSum, left + right + root.getData());

        return root.getData() + Math.max(left, right);

    }
}
