/**
 * Binary Search Tree implementation derived from Hussein Suleman's slides.
 * Designed to handle String data.
 *
 * @author Thomas Baloyi
 * @version 1
 * 1 March 2020
 */
public class BinarySearchTree {
    
    /** Root node for binary search tree. */
    private Node root;
    
    /** Keeps track of insert comparison operations. */
    private int insertOpCount;
    
    /** Keeps track of find comparison operations. */
    private int findOpCount;

    /**
     * Creates a new BinarySearchTree
     */
    public BinarySearchTree() {
        this.root = null;
        this.insertOpCount = 0;
        this.findOpCount = 0;
    }

    /**
     * Adds new data into this binary search tree.
     *
     * @param data
     */
    public void insert(String data) {
        if (this.root == null) {
            this.root = new Node(data);
        }
        else {
            insertOpCount++;
            insert(data, root);
        }
    }

    /**
     * Adds new data into this binary seearch tree and node or its descendents.
     *
     * @param data
     * @param node
     */
    public void insert(String data, Node node) {
        if (data.compareTo(node.data) <= 0) {
            if (node.left == null) {
                node.left = new Node(data);
            }
            else {
                insert(data, node.left);
            }
        }
        else {
            if (node.right == null) {
                node.right = new Node(data);
            }
            else {
                insert(data, node.right);
            }
        }
    }

    /**
     * Searchs for data in this binary search tree.
     *
     * @param data
     * @return node in which data is found.
     */
    public Node find(String data) {
        if (root == null) {
            return null;
        }
        else {
            return find(data, root);
        }
    }

    /**
     * Searches for data in this binary search tree from a given node and its descendants.
     *
     * @param data
     * @param node
     * @return node in which data is found.
     */
    public Node find(String data, Node node) {
        if (data.compareTo( ( (node.data).substring(0,7) ).trim() ) == 0) {
            findOpCount++;
            return node;
        }
        else if (data.compareTo( ( (node.data).substring(0,7) ).trim() ) < 0) {
            findOpCount++;
            return (node.left == null) ? null : find(data, node.left);
        }
        else {
            findOpCount = findOpCount + 2;
            return (node.right == null) ? null : find(data, node.right);
        }
    }

    /**
     * Prints all data stored in this binary search tree.
     */
    public void printInOrder() {
        printInOrder(this.root);
    }

    /**
     * Prints all data stored in this binary search tree from given node.
     *
     * @param node
     */
    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println( (node.data).substring(7).trim() );
            printInOrder(node.right);
        }
    }

    /**
     * Prints data corresponding to given data.
     *
     * @param data
     */
    public void printNodeData(String data) {
        Node node = find(data);
        if (node == null) {
            System.out.println("Areas not found");
        }
        else {
            System.out.println( ( (node.data).substring(7) ).trim() );
        }   
    }

    /**
     * @return the number of operations done when searching from this binary search tree.
     */
    public int getFindOpCount() {
        return (this.findOpCount);
    }

    /**
     * @return the number of operations done when inserting in this binary search tree.
     */
    public int getInsertOpCount() {
        return (this.insertOpCount);
    }
}