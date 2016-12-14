package Tree;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by incyphae10 on 12/12/16.
 * This class is used to serialize and deserialize a BST.
 */
class Codec<T extends Comparable<T>> {
    // Encodes a tree to a single string.
    public String serialize(BinarySearchTree<T> root) {
        if (root == null) return "";
        List<T> preorderList = root.preOrder(root.root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < preorderList.size(); i++){
            sb.append(preorderList.get(i).toString());
            if (i != preorderList.size() - 1) sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public BinarySearchTreeNode<T> deserialize(String data) {
        if (data.equals("")) return null;

        String[] preorder = data.split(",");
        List<Integer> preOrderList = new ArrayList<Integer>();
        for (int i = 0; i < preorder.length; i++)
            preOrderList.add(Integer.parseInt(preorder[i]));

        List<Integer> inOrderList = new ArrayList<>(preOrderList);
        Collections.sort(inOrderList);
        TreeBuilder tb = new TreeBuilder<Integer>();

//        System.out.println(preOrderList);
//        System.out.println(inOrderList);
        return tb.buildTreeFromPreInOrder(preOrderList, inOrderList);
    }
}

public class CodecMain{
    public static void main(String[] args) {
        // Building the binary search tree
        BinarySearchTree bst = new BinarySearchTree<Integer>();
        bst.insert(4);
        bst.insert(3);
        bst.insert(6);
        bst.insert(1);
        bst.insert(2);
        bst.insert(5);

        // Testing codec
        Codec codec = new Codec();
        BinarySearchTreeNode<Integer> root = codec.deserialize(codec.serialize(bst));
        BinarySearchTree newbst = new BinarySearchTree<Integer>(root, -1);
        System.out.println(newbst.inOrder(newbst.root));

    }
}