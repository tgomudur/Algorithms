package Tree;

/**
 * Created by tharun on 1/24/17.
 * Problem description: https://leetcode.com/problems/sum-of-left-leaves/
 */

public class SumOfLeftLeaves {
    public int findSumOfLeftLeaves(BinarySearchTreeNode<Integer> root) {
        if (root == null) return 0;
        return sumOfLeftLeavesHelper(root, false);
    }

    public int sumOfLeftLeavesHelper(BinarySearchTreeNode<Integer> root, boolean isLeftChild) {
        if (root == null) return 0;
        if (isLeftChild && root.left ==  null && root.right == null) return root.val;

        return sumOfLeftLeavesHelper(root.left, true) + sumOfLeftLeavesHelper(root.right, false);
    }
}