package Tree;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by tharun on 12/7/16.
 */
public class BinarySearchTreeMain {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree<Integer>();
        BinarySearchTree bst1 = new BinarySearchTree<Integer>();
        bst1.insert(4);
        bst1.insert(3);
        bst1.insert(6);
        bst1.insert(1);
        bst1.insert(2);
        bst1.insert(5);

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
        System.out.println("PreOrder Traversal: " + bst.preOrder(bst.root));
        System.out.println("InOrder Traversal: " + bst.inOrder(bst.root));


//        System.out.println("\nTesting delete: \n");
//
//        System.out.println("\nDeleting 5: \n");
//        bst.delete(5);
//        bst.print();
//
//        System.out.println("\nDeleting 1: \n");
//        bst.delete(1);
//        bst.print();
//
//        System.out.println("\nDeleting 4: \n");
//        bst.delete(4);
//        bst.print();

        bst.printLevelOrder();

        System.out.println(bst.sameAs(bst1));

        System.out.println(bst.isSymmetric(bst.root));

        List<List<Integer>> paths = bst.zigzagLevelOrder(bst.root);

//        System.out.println(bst.findClosestNode(6));

        for (List<Integer> path : paths) {
            System.out.println(path);
        }

    }
}
