/**
 * Represents a node to be used in data structures such as binary search trees.
 *
 * @author Thomas Baloyi
 */
public class Node {

    /** Data to be stored. */
    public String data;

    /** Left node. */
    public Node left;

    /** Right node. */
    public Node right;

    /** Creates a new Node. */
    public Node(String data) {
    this.data = data;
    this.left = null;
    this.right = null;
}