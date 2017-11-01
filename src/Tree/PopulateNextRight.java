package Tree;

/**
 * Given a binary tree
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/#/description
 */
import java.util.*;

class TreeLinkNode {
     TreeLinkNode left;
     TreeLinkNode right;
     TreeLinkNode next;
}

public class PopulateNextRight {
    TreeLinkNode prev;
    Map<Integer, TreeLinkNode> prevAtLevelMap;

    // Time : O(n)
    // Space : O(1)
    public void connectRecursiveEfficient(TreeLinkNode root) {
        if (root == null)
            return;

        if (root.left != null)
            root.left.next = root.right;

        if (root.right != null && root.next != null)
            root.right.next = root.next.left;

        connectRecursiveEfficient(root.left);
        connectRecursiveEfficient(root.right);

    }

    // Time : O(n)
    // Space : O(1)
    public void connectIterativeEfficient(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode current = levelStart;
            while (current != null) {
                if (current.left != null)
                    current.left.next = current.right;
                if (current.right != null && current.next != null)
                    current.right.next = current.next.left;
                current = current.next;
            }
            levelStart = levelStart.left;
        }
    }

    // Time : O(n*d) - where d is the max depth of the tree and n is number of nodes in tree
    // Space : O(1)
    public void connectUsingLevelTraversal(TreeLinkNode root) {
        for (int i = 2; i <= maxDepth(root); i++) {
            prev = null;
            connectLevel(root, i, 1);
        }
    }

    // Time : O(n)
    // Space : O(1)
    public void connectLevel(TreeLinkNode root, int targetLevel, int currentLevel) {
        if (root == null)
            return;

        // if target level reached, if prev exist link and update prev, otherwise initialize prev
        if (targetLevel == currentLevel) {
            if (prev == null)
                prev = root;
            else {
                prev.next = root;
                prev = prev.next;
            }
        }

        connectLevel(root.left, targetLevel, currentLevel + 1);
        connectLevel(root.right, targetLevel, currentLevel + 1);
    }

    // Optimizing on the previous solution using a map.
    // Time : O(n)
    // Space : O(d)
    public void connectUsingLevelTraversal2(TreeLinkNode root) {
        prevAtLevelMap = new HashMap<>();
        connectLevel(root, 1);
    }

    public void connectLevel(TreeLinkNode root, int currentLevel) {
        if (root == null)
            return;

        if (!prevAtLevelMap.containsKey(currentLevel))
            prevAtLevelMap.put(currentLevel, root);
        else {
            prevAtLevelMap.get(currentLevel).next = root;
            prevAtLevelMap.put(currentLevel, root);
        }
        connectLevel(root.left, currentLevel + 1);
        connectLevel(root.right, currentLevel + 1);
    }

    public int maxDepth(TreeLinkNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
