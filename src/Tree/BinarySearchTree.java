package Tree;

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
        else{
            printInOrder(root);
        }
    }
    private void printInOrder(BinarySearchTreeNode<T> root) {
        if (root == null)
            return;
        else{
            printInOrder(root.getLeft());
            System.out.print(root.getData());
            printInOrder(root.getRight());
        }
    }

    public void printPostOrder(BinarySearchTreeNode<T> root) {
        if (root == null)
            return;
        else{
            System.out.print(root.getData());
            printInOrder(root.getLeft());
            printInOrder(root.getRight());
        }
    }

    public void printPreOrder(BinarySearchTreeNode<T> root) {
        if (root == null)
            return;
        else{
            printInOrder(root.getLeft());
            printInOrder(root.getRight());
            System.out.print(root.getData());
        }
    }

}
