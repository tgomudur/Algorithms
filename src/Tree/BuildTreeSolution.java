package Tree;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
/**
 * Created by tharun on 12/12/16.
 */
class TreeBuilder<T extends Comparable<T>>{
    public Map<T, Integer> mapIndices(T[] inorder){
        Map<T, Integer> inMap = new HashMap<T, Integer>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return inMap;
    }

    public BinarySearchTreeNode<T> buildTreeFromPreInOrder(T[] preorder, T[] inorder) {
        if (inorder.length == 0 || preorder.length == 0) return null;
        Map<T, Integer> inMap = mapIndices(inorder);
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private BinarySearchTreeNode<T> buildTree(T[] preorder, int preStart, int preEnd, T[] inorder, int inStart, int inEnd, Map<T, Integer> inMap){
        if (inStart > inEnd || preStart > preEnd) return null;
        T rootVal = preorder[preStart];
        BinarySearchTreeNode<T> root = new BinarySearchTreeNode<T>(rootVal);
        int inIdx = inMap.get(rootVal);
        int numsInLST = inIdx - inStart;
        root.setLeft(buildTree(preorder, preStart + 1, preStart + numsInLST, inorder, inStart, inIdx - 1, inMap));
        root.setRight(buildTree(preorder, preStart + numsInLST + 1, preEnd, inorder, inIdx + 1, inEnd, inMap));

        return root;
    }
}

public class BuildTreeSolution{
    public static void main(String[] args){
        TreeBuilder tb = new TreeBuilder<Integer>();
        BinarySearchTree bst = new BinarySearchTree<Integer>();
        bst.insert(4);
        bst.insert(3);
        bst.insert(6);
        bst.insert(1);
        bst.insert(2);
        bst.insert(5);

        List<Integer> inOrderList = bst.inOrder();
        List<Integer> preOrderList = bst.preOrder();
        int numOfElements = inOrderList.size();

        Integer[] preOrderArray = (Integer[]) preOrderList.toArray(new Integer[0]);
        Integer[] inOrderArray = (Integer[]) inOrderList.toArray(new Integer[0]);
//        int[] preOrderArray = new int[preOrderList.size()];
//        int[] inOrderArray = new int[inOrderList.size()];
//
//        for(int i = 0; i < inOrderList.size(); i++){
//            inOrderArray[i] = inOrderList.get(i);
//            preOrderArray[i] = preOrderList.get(i);
//        }
        BinarySearchTreeNode<Integer> root = tb.buildTreeFromPreInOrder(preOrderArray,inOrderArray);
        BinarySearchTree newbst = new BinarySearchTree<Integer>(root, numOfElements);
        System.out.println(newbst.postOrder());

    }
    }
