package List.DoublyLinkedList;

/**
 * Created by incyphae10 on 12/6/16.
 */
public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList<Integer>();
        System.out.println("Testing insert: ");

        dList.insert(3, 0);
        dList.insert(1, 0);
        dList.insert(2, 0);
        dList.insert(4, 4);
        dList.insert(6, 3);
        dList.insert(5, 4);
        dList.insert(0, 1);

        dList.display();

        System.out.println("\nTesting delete: ");

        dList.delete(0);
        dList.display();

        dList.delete(100);

        dList.delete(4);
        dList.display();

        dList.delete(2);
        dList.display();

    }
}

