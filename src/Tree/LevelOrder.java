package Tree;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * https://leetcode.com/problems/binary-tree-level-order-traversal/#/description
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(BinarySearchTree<Integer> root) {
        return levelOrderHelper(root, new ArrayList<>(), 0);
    }

    public List<List<Integer>> levelOrderHelper(BinarySearchTree<Integer> root, List<List<Integer>> result, int level) {
        if (root != null) {
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            levelOrderHelper(root.left, result, level + 1);
            levelOrderHelper(root.right, result, level + 1);
        }
        return result;
    }
}
