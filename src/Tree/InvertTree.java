package Tree;

/**
 * Created by tharun on 4/1/17.
 * https://leetcode.com/problems/invert-binary-tree/#/description
 */
class InvertTreeSolution {
    public BinarySearchTreeNode<Integer> invertTree(BinarySearchTreeNode<Integer> root) {
        if (root == null)
            return null;

        BinarySearchTreeNode left = invertTree(root.getLeft());
        BinarySearchTreeNode right = invertTree(root.getRight());
        root.setLeft(right);
        root.setRight(left);

        return root;
    }
}