package Tree;

/**
 * Created by tharun on 12/7/16.
 */
public class BinarySearchTreeNode<T extends Comparable<T>>{
    private T data;
    public BinarySearchTreeNode<T> left;
    public BinarySearchTreeNode<T> right;

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

    public BinarySearchTreeNode<T> getLeft() {
        return this.left;
    }

    public BinarySearchTreeNode<T> getRight() {
        return this.right;
    }

    public void setLeft(BinarySearchTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinarySearchTreeNode<T> right) {
        this.right = right;
    }

//    @Override
//    public int compareTo(BinarySearchTreeNode<T> other){
//        if (this.getData() == other.getData())
//            return 0;
//        else if (this.getData() < other.getData())
//            return -1;
//        else
//            return 1;
//
//    }
}
