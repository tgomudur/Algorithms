package Tree;

/**
 * Created by tharun on 1/20/17.
 * Problem description: https://leetcode.com/problems/balanced-binary-tree/
 */

public class BalancedTree {
    // Bottom up solution: Time O(n) Space O(1)
    public int checkHeight(BinarySearchTreeNode<Integer> root) {
        if (root == null) return 0;

        int leftHeight = checkHeight(root.getLeft());
        if (leftHeight == Integer.MIN_VALUE) return leftHeight;

        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == Integer.MIN_VALUE) return rightHeight;

        if (Math.abs(leftHeight - rightHeight) > 1) return Integer.MIN_VALUE;

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public boolean isBalanced(BinarySearchTreeNode<Integer> root) {
        return (checkHeight(root) != Integer.MIN_VALUE);
    }

    // Top Down: Time O(nlogn) Space O(1)
    public boolean isBalanced1(BinarySearchTreeNode<Integer> root) {
        if (root == null) return true;
        int heightDiff = Math.abs(getHeight(root.getLeft()) - getHeight(root.getRight()));

        if (heightDiff > 1) return false;

        return isBalanced1(root.getLeft()) && isBalanced1(root.getRight());
    }

    public int getHeight(BinarySearchTreeNode<Integer> root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }
}