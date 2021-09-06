/**
 * Binary Search Tree implementation derived from Hussein Suleman's slides.
 * Designed to handle string data elements rather than be generating.
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
    
    /* Constructor */
    public BinarySearchTree() {
        this.root = null;
        this.insertOpCount = 0;
        this.findOpCount = 0;
    } 
    
    public void insert(String data) {
        if (this.root == null) {
            this.root = new Node(data);
        }
        else {
            insertOpCount++;
            insert(data, root);
        }
    }
    
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
    
    public Node find(String data) {
        if (root == null) {
            return null;
        }
        else {
            return find(data, root);
        }
    }   
    
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
         
    public void printInOrder() {
        printInOrder(this.root);
    }
    
    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println( (node.data).substring(7).trim() );
            printInOrder(node.right);
        }
    }
    
    /* Prints out data from nodes that match with given param */
    public void printNodeData(String data) {
        Node node = find(data);
        if (node == null) {
            System.out.println("Areas not found");
        }
        else {
            System.out.println( ( (node.data).substring(7) ).trim() );
        }   
    }
    
    public int getFindOpCount() {
        return (this.findOpCount);
    }
    
    public int getInsertOpCount() {
        return (this.insertOpCount);
    }
}

class Node {
    
    /* Data to be stored. */
    public String data;
    
    /* Left node. */
    public Node left;
    
    /* Right node. */
    public Node right;
    
    // Constructor
    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}