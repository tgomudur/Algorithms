package Tree;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
/**
 * Created by tharun on 12/12/16.
 */
class TreeBuilder<T extends Comparable<T>>{
    public Map<T, Integer> mapIndices(List<T> inorder){
        Map<T, Integer> inMap = new HashMap<T, Integer>();
        for (int i = 0; i < inorder.size(); i++)
            inMap.put(inorder.get(i), i);
        return inMap;
    }

    public BinarySearchTreeNode<T> buildTreeFromPreInOrder(List<T> preorder, List<T> inorder) {
        if (inorder.size() == 0 || preorder.size() == 0) return null;
        Map<T, Integer> inMap = mapIndices(inorder);
        return buildTreeFromPreInOrder(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, inMap);
    }

    private BinarySearchTreeNode<T> buildTreeFromPreInOrder(List<T> preorder, int preStart, int preEnd, List<T> inorder, int inStart, int inEnd, Map<T, Integer> inMap){
        if (inStart > inEnd || preStart > preEnd) return null;
        T rootVal = preorder.get(preStart);
        BinarySearchTreeNode<T> root = new BinarySearchTreeNode<T>(rootVal);
        int inIdx = inMap.get(rootVal);
        int numsInLST = inIdx - inStart;
        root.setLeft(buildTreeFromPreInOrder(preorder, preStart + 1, preStart + numsInLST, inorder, inStart, inIdx - 1, inMap));
        root.setRight(buildTreeFromPreInOrder(preorder, preStart + numsInLST + 1, preEnd, inorder, inIdx + 1, inEnd, inMap));
        return root;
    }

    public BinarySearchTreeNode<T> buildTreeFromPostInOrder(List<T> postorder, List<T> inorder) {
        if (inorder.size() == 0 || postorder.size() == 0) return null;
        Map<T, Integer> inMap = mapIndices(inorder);
        return buildTreeFromPostInOrder(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1, inMap);
    }

    private BinarySearchTreeNode<T> buildTreeFromPostInOrder(List<T> inorder, int inStart, int inEnd, List<T> postorder, int postStart, int postEnd, Map<T, Integer> inMap){
        if (inStart > inEnd || postStart > postEnd) return null;
        T rootVal = postorder.get(postEnd);
        BinarySearchTreeNode<T> root = new BinarySearchTreeNode<T>(rootVal);
        int inIdx = inMap.get(rootVal);
        int numsInLST =  inIdx - inStart;
        root.setLeft(buildTreeFromPostInOrder(inorder, inStart, inIdx - 1, postorder, postStart, postStart + numsInLST - 1, inMap));
        root.setRight(buildTreeFromPostInOrder(inorder, inIdx + 1, inEnd, postorder,  postStart + numsInLST, postEnd - 1, inMap));
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

        List<Integer> inOrderList = bst.inOrder(bst.root);
        List<Integer> preOrderList = bst.preOrder(bst.root);
        List<Integer> postOrderList = bst.postOrder(bst.root);

        int numOfElements = inOrderList.size();

//        Integer[] preOrderArray = (Integer[]) preOrderList.toArray(new Integer[0]);
//        Integer[] inOrderArray = (Integer[]) inOrderList.toArray(new Integer[0]);
//        Integer[] postOrderArray = (Integer[]) postOrderList.toArray(new Integer[0]);

//        BinarySearchTreeNode<Integer> root = tb.buildTreeFromPreInOrder(preOrderArray,inOrderArray);
        BinarySearchTreeNode<Integer> root = tb.buildTreeFromPostInOrder(postOrderList,inOrderList);

        BinarySearchTree newbst = new BinarySearchTree<Integer>(root, numOfElements);

        System.out.println(newbst.postOrder(newbst.root).equals(postOrderList));



    }
    }
