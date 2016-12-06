package List.DoublyLinkedList;

/**
 * Created by incyphae10 on 12/6/16.
 */
public class DoublyLinkedListNode<T> {
    protected T data;
    protected DoublyLinkedListNode<T> left;
    protected DoublyLinkedListNode<T> right;

    DoublyLinkedListNode(T data, DoublyLinkedListNode<T> left, DoublyLinkedListNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    DoublyLinkedListNode(T data) {
        this(data, null, null);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyLinkedListNode<T> getLeft() {
        return this.left;
    }

    public DoublyLinkedListNode<T> getRight() {
        return this.right;
    }

    public void setLeft(DoublyLinkedListNode<T> left) {
        this.left = left;
    }

    public void setRight(DoublyLinkedListNode<T> right) {
        this.right = right;
    }

}
