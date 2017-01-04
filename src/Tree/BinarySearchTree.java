package Tree;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by tharun on 12/7/16.
 */
public class BinarySearchTree<T extends Comparable<T>>{
    public BinarySearchTreeNode<T> root;
    public int numOfElements;

    BinarySearchTree() {
        this.root = null;
        this.numOfElements = 0;
    }

    BinarySearchTree(BinarySearchTreeNode<T> root, int num) {
        this.root = root;
        this.numOfElements = num;
    }

    public void insert(T data) {
        BinarySearchTreeNode<T> newNode = new BinarySearchTreeNode<T>(data);
        // Case: Empty tree
        if (root == null){
            root = newNode;
        }
        // Case: Elements already in the trees.
        else{
            this.insertUtil(root, newNode);
            this.numOfElements += 1;
        }
    }

    private BinarySearchTreeNode<T> insertUtil(BinarySearchTreeNode<T> root, BinarySearchTreeNode<T> newNode){
        // If Leaf node, return newNode
        if (root == null){
            return newNode;
        }
        // If data to be inserted >= current node data, recurse right subtree
        if (root.getData().compareTo(newNode.getData()) < 0){
            root.setRight(this.insertUtil(root.getRight(), newNode));
        }
        // If data to be inserted < current node data, recurse left subtree
        else{
            root.setLeft(this.insertUtil(root.getLeft(), newNode));
        }
        return root;
    }

    public BinarySearchTreeNode<T> search(T data){
        if (root == null){
            System.out.println("Tree is Empty");
            return null;
        }else{
            return searchUtil(root, data);
        }
    }

    private BinarySearchTreeNode<T> searchUtil(BinarySearchTreeNode<T> root, T data){
        if (root == null)
            return null;
        else if (root.getData().compareTo(data) == 0)
            return root;
        else if (root.getData().compareTo(data) > 0)
            return searchUtil(root.getLeft(), data);
        else
            return searchUtil(root.getRight(), data);
    }

    public void delete(T data) {
        if (root == null){
            System.out.println("Error: Tree is Empty");
            return;
        }else{
            deleteUtil(root, data);
            this.numOfElements -= 1;
        }
    }

    private BinarySearchTreeNode<T> deleteUtil(BinarySearchTreeNode<T> node, T data){
        if (node == null){
            System.out.println("Error: Something went wrong!");
            return null;
        }else{
            if (node.getData().compareTo(data) > 0){
                node.setLeft(deleteUtil(node.getLeft(), data));
            }else if (node.getData().compareTo(data) < 0){
                node.setRight(deleteUtil(node.getRight(), data));
            }else{
                // Only left child
                if (node.getLeft() == null)
                    return node.getRight();
                    // Only right child
                else if (node.getRight() == null)
                    return node.getLeft();
                    // Both left and right child
                else{
                    BinarySearchTreeNode<T> successorNode = findSuccessor(node.getRight());
                    // Copy data to node
                    node.setData(successorNode.getData());
                    // Delete the original copy
                    node.setRight(deleteUtil(node.getRight(), successorNode.getData()));
                }
            }
        }
        return node;
    }

    public BinarySearchTreeNode<T> findSuccessor(BinarySearchTreeNode<T> node){
        while (node.getLeft() != null){
            node = node.getLeft();
        }
        return node;
    }

    public void print(){
        if (root == null)
            return;
        System.out.println(inOrder(root, new ArrayList<T>()));
    }

    public List<T> inOrder(BinarySearchTreeNode<T> root){
        if (root == null) return null;
        return inOrder(root, new ArrayList<T>());
    }

    public List<T> preOrder(BinarySearchTreeNode<T> root){
        if (root == null) return null;
        return preOrder(root, new ArrayList<T>());
    }

    public List<T> postOrder(BinarySearchTreeNode<T> root){
        if (root == null) return null;
        return postOrder(root, new ArrayList<T>());
    }

    private List<T> inOrder(BinarySearchTreeNode<T> root, List<T> path) {
        if (root == null) return null;
        inOrder(root.getLeft(), path);
        path.add(root.getData());
        inOrder(root.getRight(), path);
        return path;
    }

    private List<T> preOrder(BinarySearchTreeNode<T> root, List<T> path) {
        if (root == null) return null;
        path.add(root.getData());
        preOrder(root.getLeft(), path);
        preOrder(root.getRight(), path);
        return path;
    }

    private List<T> postOrder(BinarySearchTreeNode<T> root, List<T> path) {
        if (root == null) return null;
        postOrder(root.getLeft(), path);
        postOrder(root.getRight(), path);
        path.add(root.getData());
        return path;
    }
    /*
    // TODO: Review this to work with generics
    public List<String> findBinaryTreePaths(BinarySearchTreeNode<T> root) {
        List<String> paths = new ArrayList<String>();
        String currentPath = "";
        if (root == null)
            return paths;
        paths = binaryTreePaths(root, paths, currentPath);
        return paths;
    }

    private List<String> binaryTreePaths(BinarySearchTreeNode<T> root, List<String> paths, String currentPath) {
        if (root.getLeft() == null && root.getRight() == null) {
            return paths.add(currentPath + root.getData());
            ;
        } else {
            if (root.getLeft() != null)
                binaryTreePaths(root.getLeft(), paths, currentPath + "->" + root.getData());

            if (root.getRight() != null)
                binaryTreePaths(root.getRight(), paths, currentPath + "->" + root.getData());
        }
        return paths;
    }
    */
    public void printLevelOrder() {
        if (root == null) {
            System.out.println("\nEmpty tree!");
        } else {
            List<List<T>> paths = levelOrderBottom(root);
            for (List<T> level : paths) {
                System.out.println(level);
            }
        }
    }

    // Faster implementation for level order traversal
    public List<List<T>> levelOrderBottom(BinarySearchTreeNode<T> root) {
        List<List<T>> paths = new ArrayList<>();
        if (root == null) return paths;
        else {
            paths = levelOrderUtil(root, paths, 0);
        }

        Collections.reverse(paths);
        return paths;
    }

    public List<List<T>> levelOrderUtil(BinarySearchTreeNode<T> root, List<List<T>> paths, int currentLevel) {
        if (root == null) return null;

        if (currentLevel >= paths.size()) {
            List<T> level = new ArrayList<T>();
            paths.add(currentLevel, level);
        }
        paths.get(currentLevel).add(root.getData());
        levelOrderUtil(root.getLeft(), paths, currentLevel + 1);
        levelOrderUtil(root.getRight(), paths, currentLevel + 1);

        return paths;
    }

    public List<List<T>> levelOrderBottomSlower(BinarySearchTreeNode<T> root) {
        List<List<T>> paths = new LinkedList<>();
        List<T> level;
        int height = 0;
        if (root == null) return paths;
        else {
            height = findHeight(root);
            System.out.println(height);
            for (int i = 0; i < height; i++) {
                level = new LinkedList<T>();
                paths.add(0, printGivenLevel(root, level, 0, i));
            }
        }
        return paths;
    }

    public List<T> printGivenLevel(BinarySearchTreeNode<T> root, List<T> level, int currentLevel, int targetLevel) {
        if (root == null) return level;

        if (currentLevel == targetLevel) {
            level.add(root.getData());
            return level;
        }

        printGivenLevel(root.getLeft(), level, currentLevel + 1, targetLevel);
        printGivenLevel(root.getRight(), level, currentLevel + 1, targetLevel);

        return level;
    }

    public int findHeight(BinarySearchTreeNode<T> root) {
        if (root == null) return 0;
        else return Math.max(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;
    }

    public boolean sameAs(BinarySearchTree p) {
        return isSameTree(this.root, p.root);
    }

    public boolean isSameTree(BinarySearchTreeNode<T> p, BinarySearchTreeNode<T> q) {
        if (p == null || q == null) return (p == q);
        if (p.getData() == q.getData())
            return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
        return false;
    }

    public boolean isSymmetric(BinarySearchTreeNode<T> root) {
        if (root == null) return true;
        return isSymmetric(root.getLeft(), root.getRight());
    }

    private boolean isSymmetric(BinarySearchTreeNode<T> p, BinarySearchTreeNode<T> q) {
        if (p == null || q == null) return (p == q);
        if (p.getData() == q.getData())
            return isSymmetric(p.getLeft(), q.getRight()) && isSymmetric(p.getRight(), q.getLeft());
        return false;
    }

    public List<List<T>> zigzagLevelOrder(BinarySearchTreeNode<T> root) {
        List<List<T>> paths = new ArrayList<>();
        if (root == null) return paths;
        return zigzagLevelOrder(root, paths, 0);
    }

    private List<List<T>> zigzagLevelOrder(BinarySearchTreeNode<T> root, List<List<T>> paths, int currentLevel) {
        if (root == null) return paths;
        if (currentLevel >= paths.size()) paths.add(currentLevel, new ArrayList<T>());
        if (currentLevel % 2 == 0) paths.get(currentLevel).add(root.getData());
        else paths.get(currentLevel).add(0, root.getData());

        zigzagLevelOrder(root.getLeft(), paths, currentLevel + 1);
        zigzagLevelOrder(root.getRight(), paths, currentLevel + 1);
        return paths;
    }

//    public BinarySearchTreeNode<T> findClosestNode(T value) {
//        if (root == null) return null;
//        else return search(findClosestNodeUtil(root, value, 0, -1));
//    }
//
//    private T findClosestNodeUtil(BinarySearchTreeNode<T> root, T value, T minDist, T goal) {
//        if (root == null) return goal;
//        if ((root.getData() - value) < minDist) {
//            minDist = root.getData() - value;
//            goal = root.getData();
//        }
//
//        if (root.getData() < target) findClosestNodeUtil(root.left, value, minDist, goal);
//        else findClosestNodeUtil(root.right, value, minDist, goal);
//        return goal;
//    }

    public BinarySearchTreeNode<T> findLCA(T p, T q) {
        return findLCA(this.root, search(p), search(q));
    }
    private BinarySearchTreeNode<T> findLCA(BinarySearchTreeNode<T> root, BinarySearchTreeNode<T> p,BinarySearchTreeNode<T> q) {
        if (root == null) return root;

        if (p.getData().compareTo(root.getData()) < 0 && q.getData().compareTo(root.getData()) < 0)
            return findLCA(root.getLeft(), p, q);

        if (p.getData().compareTo(root.getData()) > 0 && q.getData().compareTo(root.getData()) > 0)
            return findLCA(root.getRight(), p, q);

        return root;
    }
}
