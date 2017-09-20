package List.SinglyLinkedList;

/**
 * Created by tharun on 11/22/16.
 */
public class SinglyLinkedList<T> {
    protected SinglyLinkedListNode<T> head;
    protected int numOfElements;

    public SinglyLinkedList() {
        this.head = null;
        this.numOfElements = 0;
    }

    public SinglyLinkedListNode<T> getHead() {
        return head;
    }

    public int size() {
        return numOfElements;
    }

    public void append(T data) {
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
        SinglyLinkedListNode<T> current;

        if (head == null) {
            head = newNode;
        } else {
            current = head;
            while (current.next != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.numOfElements += 1;
    }

    public void insert(int index, T data) {
        SinglyLinkedListNode<T> current;
        SinglyLinkedListNode<T> tmp;
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
        int currentPosition;

        if (head != null) {
            current = head;
            currentPosition = 0;

            // if index is out of bounds
            if (index >= this.numOfElements) {
                System.out.println("Index Out of Bounds");
                return;
            }

            // insert at the beginning
            if (index == 0) {
                newNode.setNext(current);
                head = newNode;

            }
            // insert at the end
            else if (index == this.numOfElements) {
                this.append(data);
            }
            // insert in the middle
            else {
                while (current != null) {
                    if (currentPosition == index - 1)
                        break;
                    current.setNext(current.getNext());
                    currentPosition++;
                }
                if (current != null) {
                    tmp = current.getNext();
                    current.setNext(newNode);
                    newNode.setNext(tmp);
                } else {
                    // throw exception
                    System.out.println("Error: Something went wrong!");
                    return;
                }
            }
            this.numOfElements++;
        }
    }

    public void delete(T data) {
        SinglyLinkedListNode<T> current;
        SinglyLinkedListNode<T> prev;

        // Handles empty list
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Handles case where the data is the first element
        if (head.getData() == data) {
            head = head.getNext();
            return;
        }

        // Handles case where data is in the middle and end
        current = head;
        prev = null;
        while (current != null) {
            if (current.getData() == data) {
                prev.setNext(current.getNext());
            }
            prev = current;
            current = current.getNext();
        }

        // Handles case where data is not in the list
        if (current == null) {
            System.out.println(" The data was not found in the list");
        }
    }

    public void displayList() {
        SinglyLinkedListNode<T> current;

        if (head != null) {
            current = head;
            while (current != null) {
                System.out.print(" " + current.getData());
                current = current.getNext();
            }
        }
    }

    // Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
    // https://leetcode.com/problems/delete-node-in-a-linked-list/#/description
    public void deleteNode(SinglyLinkedListNode<T> node) {
        SinglyLinkedListNode<T> prev = node;
        SinglyLinkedListNode<T> current = node.next;

        prev.setData(current.getData());
        prev.setNext(current.getNext());
    }

    public void reverseList(SinglyLinkedList<T> list) {
        SinglyLinkedListNode<T> prev = null;
        SinglyLinkedListNode<T> current = list.head;
        SinglyLinkedListNode<T> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list.head = prev;
    }
}
