package Tree;

/**
 * Created by tharun on 12/7/16.
 */
public class BinarySearchTreeNode<T> {
    private T data;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    BinarySearchTreeNode() {
        this.left = null;
        this.right = null;
    }

    BinarySearchTreeNode(T data) {
        this();
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getLeft() {
        return this.left;
    }

    public T getRight() {
        return this.right;
    }

    public void setLeft(BinarySearchTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinarySearchTreeNode<T> right) {
        this.right = right;
    }
}
