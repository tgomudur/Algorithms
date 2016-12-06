package List.SinglyLinkedList;

/**
 * Created by tharun on 11/22/16.
 */

public class SinglyLinkedListNode<T> {
    protected T data;
    protected SinglyLinkedListNode<T> next;

    public SinglyLinkedListNode(T data, SinglyLinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public SinglyLinkedListNode(T data) {
        this(data, null);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SinglyLinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }
}
