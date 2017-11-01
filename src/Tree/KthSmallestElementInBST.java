package Tree;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ? k ? BST's total elements.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/description
 */

public class KthSmallestElementInBST {
    int count = 0;
    int kthSmallestElement = 0;

    public int kthSmallest(BinarySearchTreeNode<Integer> root, int k) {
        // Method 1: Inorder
        count = k;
        kthSmallestInOrder(root);
        return kthSmallestElement;

        // Method 2: Binary Search
        // return kthSmallestBinarySearch(root, k);
    }

    public void kthSmallestInOrder(BinarySearchTreeNode<Integer> root) {
        if (root.left != null)
            kthSmallestInOrder(root.left);

        count--;
        if (count == 0) {
            kthSmallestElement = root.getData();
            return;
        }

        kthSmallestInOrder(root.right);
    }

    // Time : O(n^2)
    // Space : O(d) where d is depth. Call Stack.
    public int kthSmallestBinarySearch(BinarySearchTreeNode<Integer> root, int k) {
        int count = countNodes(root.left);
        if (count >= k)
            return kthSmallestBinarySearch(root.left, k);
        else if (count + 1 < k)
            return kthSmallestBinarySearch(root.right, k - 1 - count);

        return root.getData();
    }

    public int countNodes(BinarySearchTreeNode<Integer> root) {
        if (root != null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
