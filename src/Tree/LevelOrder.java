package Tree;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * https://leetcode.com/problems/binary-tree-level-order-traversal/#/description
 */
import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(BinarySearchTreeNode<Integer> root) {
        return levelOrderHelper(root, new ArrayList<>(), 0);
    }

    public List<List<Integer>> levelOrderHelper(BinarySearchTreeNode<Integer> root, List<List<Integer>> result, int level) {
        if (root != null) {
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.getData());
            levelOrderHelper(root.left, result, level + 1);
            levelOrderHelper(root.right, result, level + 1);
        }
        return result;
    }
}
