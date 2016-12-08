package Tree;

/**
 * Created by tharun on 12/7/16.
 */
public class BinarySearchTreeMain {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree<Integer>();

        System.out.println("\nTesting insert: \n");
        bst.insert(4);
        bst.insert(3);
        bst.insert(6);
        bst.insert(1);
        bst.insert(2);
        bst.insert(5);

        bst.print();
        System.out.println("\nSearching 2:");
        BinarySearchTreeNode node = bst.search(2);
        System.out.println("\nFound:" + node.getData());

        System.out.println("\nTesting delete: \n");

        System.out.println("\nDeleting 5: \n");
        bst.delete(5);
        bst.print();

        System.out.println("\nDeleting 1: \n");
        bst.delete(1);
        bst.print();

        System.out.println("\nDeleting 4: \n");
        bst.delete(4);
        bst.print();

    }
}
