package Tree;

/**
 * Created by tharun on 1/27/17.
 * Problem description: https://leetcode.com/problems/getData()idate-binary-search-tree/
 */

public class BSTValidator {
    // Time Complexity : O(n) Space Complexity : O(1)
    public boolean isValidBST(BinarySearchTreeNode<Integer> root) {
        if (root == null) return true;
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(BinarySearchTreeNode<Integer> root, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && min >= root.getData()) || (max != null && max <= root.getData()))
            return false;

        if (!isValidBSTHelper(root.left, min, root.getData()) || !isValidBSTHelper(root.right, root.getData(), max))
            return false;

        return true;
    }
}