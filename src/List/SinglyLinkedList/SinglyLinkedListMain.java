package List.SinglyLinkedList;

/**
 * Created by incyphae10 on 11/22/16.
 */

public class SinglyLinkedListMain {

    public static void main(String[] args) {
        SinglyLinkedList sList = new SinglyLinkedList<Integer>();

        sList.append(5);
        sList.append(10);
        sList.append(1);
        sList.append(2);
        sList.append(4);
        sList.displayList();

        System.out.println("Testing insert: ");
        sList.insert(0, 1);
        sList.insert(0, 0);
        sList.insert(5, 3);
//        sList.insert(20, 5);
        sList.displayList();

        System.out.println("Testing delete: ");
        sList.delete(0);
        sList.displayList();
        sList.delete(20);
        sList.displayList();
        sList.delete(1);
        sList.displayList();
    }
}
