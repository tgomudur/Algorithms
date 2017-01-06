package Tree;

/**
 * Created by tharun on 1/5/17.
 */

public class SortedArrayToBST {
    public BinarySearchTreeNode<Integer> sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    public BinarySearchTreeNode<Integer> sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right)/2;
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<Integer>(nums[mid]);
        root.setLeft(sortedArrayToBSTHelper(nums, left, mid - 1));
        root.setRight(sortedArrayToBSTHelper(nums, mid + 1, right));

        return root;
    }
}
