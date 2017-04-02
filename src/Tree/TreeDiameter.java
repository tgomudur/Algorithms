package Tree;

/**
 * Created by tharun on 4/1/17.
 *
 */
public class TreeDiameter {
    public int findHeight(BinarySearchTreeNode<Integer> root) {
        if (root == null)
            return 0;

        return Math.max(findHeight(root.getLeft()), findHeight(root.getRight())) + 1
    }

    public int findDiameter(BinarySearchTreeNode<Integer> root, int maxDiameter) {
        if (root == null)
            return maxDiameter;
        maxDiameter = Math.max(maxDiameter, findHeight(root.getLeft()) + findHeight(root.getRight()));
        maxDiameter = findDiameter(root.getLeft(), maxDiameter);
        maxDiameter = findDiameter(root.getRight(), maxDiameter);

        return maxDiameter;
    }
    public int diameterOfTree(BinarySearchTreeNode<Integer> root) {
        if (root == null)
            return 0;

        return findDiameter(root , 0);
    }
}
