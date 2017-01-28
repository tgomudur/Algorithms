package Tree;

/**
 * Created by tharun on 1/27/17.
 */

public class BSTValidator {

    // Time Complexity : O(n)
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && min >= root.val) || (max != null && max <= root.val))
            return false;

        if (!isValidBSTHelper(root.left, min, root.val) || !isValidBSTHelper(root.right, root.val, max))
            return false;

        return true;
    }
}