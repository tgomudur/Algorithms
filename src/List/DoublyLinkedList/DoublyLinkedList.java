package List.DoublyLinkedList;

/**
 * Created by incyphae10 on 12/6/16.
 */
public class DoublyLinkedList<T> {
    DoublyLinkedListNode<T> head;
    int size;

    DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void insert(T data, int position) {
        DoublyLinkedListNode<T> prev;
        DoublyLinkedListNode<T> current;
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(data);

        // Case 1: Empty List
        if (this.isEmpty()) {
            this.head = newNode;
        }
        // Case 2: Insert in the beginning
        else if (position == 0) {
            newNode.setRight(head);
            head.setLeft(newNode);
            head = newNode;
        }
        // Case 3: Insert at the end of the list. If position > size, insert at the end
        else if (position > this.size - 1) {
            this.append(newNode);
        }
        // Case 3: Insert in the middle/beginning
        else {
            current = head;
            int currentPosition = 0;

            // Traverse to the position in the list
            while (current != null) {
                if (currentPosition == position)
                    break;
                current = current.getRight();
                currentPosition += 1;
            }
            if (current != null) {
                // Rewiring the list
                prev = current.getLeft();
                prev.setRight(newNode);
                newNode.setLeft(prev);
                current.setLeft(newNode);
                newNode.setRight(current);
            }
        }
        this.size += 1;
    }

    public void delete(T data) {
        // Deletes the first occurrence of the data, if multiple occurrences are there
        DoublyLinkedListNode<T> prev;
        DoublyLinkedListNode<T> next;
        if (this.isEmpty()) {
            // TODO: raise custom exception.
            System.out.println("Error: List is empty");
            return;
        } else {
            DoublyLinkedListNode<T> current = head;
            int currentPosition = 0;

            // Traverse to the position in the list
            while (current != null) {
                // TODO: Should implement equals() in node class
                if (current.getData() == data)
                    break;
                current = current.getRight();
                currentPosition += 1;
            }
            // Case 2: Data not found
            if (current == null) {
                // TODO: raise custom exception
                System.out.println("\nError: Data Not Found!");
                return;
            }

            prev = current.getLeft();
            next = current.getRight();
            // Case 3: Data in the middle
            if (prev != null && next != null) {
                prev.setRight(next);
                next.setLeft(prev);
                current.setLeft(null);
                current.setRight(null);
            }
            // Case 4: Data at the end
            else if (prev != null) {
                prev.setRight(next);
                current.setLeft(null);
            }
            // Case 5: Data at the beginning
            else {
                next.setLeft(prev);
                head = next;
                current.setRight(null);
            }
            this.size -= 1;
        }
    }

    public void append(DoublyLinkedListNode<T> newNode) {
        // Adds newNode to the end
        DoublyLinkedListNode<T> current = head;

        // Traverse to the position in the list
        while (current.getRight() != null) {
            current = current.getRight();
        }
        current.setRight(newNode);
        newNode.setLeft(current);
    }

    public void display() {
        // Prints the list
        DoublyLinkedListNode<T> current = head;

        while (current != null) {
            System.out.print(" " + current.getData());
            current = current.getRight();
        }
        System.out.println();
    }
}
