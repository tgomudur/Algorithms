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

    public int kthSmallest(BinarySearchTree<Integer> root, int k) {
        // Method 1: Inorder
        count = k;
        kthSmallestInorder(root);
        return kthSmallestElement;

        // Method 2: Binary Search
        // return kthSmallestBinarySearch(root, k);
    }

    public void kthSmallestInOrder(BinarySearchTree<Integer> root) {
        if (root.left != null)
            kthSmallestInOrder(root.left);

        count--;
        if (count == 0) {
            kthSmallestElement = root.data;
            return;
        }

        kthSmallestInOrder(root.right);
    }

    // Time : O(n^2)
    // Space : O(d) where d is depth. Call Stack.
    public int kthSmallestBinarySearch(BinarySearchTree<Integer> root, int k) {
        int count = countNodes(root.left);
        if (count >= k)
            return kthSmallestBinarySearch(root.left, k);
        else if (count + 1 < k)
            return kthSmallestBinarySearch(root.right, k - 1 - count);

        return root.data;
    }

    public int countNodes(BinarySearchTree<Integer> root) {
        if (root != null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
