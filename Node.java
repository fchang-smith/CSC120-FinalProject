/**
 * Nodes that make up a tree
 */
public class Node {

    private int value;
    private Node parent;
    private Node LChild;
    private Node RChild;
    private Boolean status = false;

    /**
     * constructor of nodes
     * @param value value of the node
     * @param lChild left child of the node
     * @param RChild right child of the node
     */
    public Node (int value, Node lChild, Node RChild) {
        this.value = value;
        this.parent = null;
        this.LChild = lChild;
        this.RChild = RChild;
    }

    /**
     * constructor of node
     * @param value value of node
     * @param parent parent node 
     * @param LChild left child of node
     * @param RChild right child of node
     */
    public Node (int value, Node parent, Node LChild, Node RChild) {
        this.value = value;
        this.parent = parent;
        this.LChild = LChild;
        this.RChild = RChild;
    }

    /**
     * constructor of node
     * @param value value of node
     * @param parent parent of node
     */
    public Node (int value, Node parent) {
        this.value = value;
        this.parent = parent;
        this.LChild = null;
        this.RChild = null;

    }

    /**
     * adding value of two nodes and form a new parent node
     * @param n1 node to be added
     * @return new node
     */
    public Node mergeNode(Node n1) {
        Node nNode = new Node(this.getValue()+n1.getValue(), this, n1);
        return nNode;
    }

    /**
     * accessor of value
     * @return value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * check if the node is a WordNode
     * @return true if it is
     */
    public boolean isWordNode() {
        return false;
    }

    /**
     * check if the node has parent node
     * @return true if it has
     */
    public boolean hasParent() {
        if (this.getParent() != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * check if this node has children nodes
     * @return true if it has
     */
    public boolean hasChild() {
        if (this.getLChild()!= null && this.getLChild() != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * accessor of parent node
     * @return Node parent node
     */
    public Node getParent() {
        return this.parent;
    }

    /**
     * accessor of right child node
     * @return right child node
     */
    public Node getRChild() {
        return this.RChild;
    }

    /**
     * accessor of left child node
     * @return left child node
     */
    public Node getLChild() {
        return this.LChild;
    }

    /**
     * accessor of the status
     * @return boolean
     */
    public Boolean getStatus() {
        return this.status;
    }

    /**
     * manipulator of parent
     * @param n new parent
     */
    public void setParent (Node n) {
        this.parent = n;
    }

    /**
     * manipulator of left child node
     * @param n new left child
     */
    public void setLChild (Node n) {
        this.LChild = n;
    }

    /**
     * manipulator of new right child
     * @param n new right child
     */
    public void setRChild (Node n) {
        this.RChild = n;
    }

    /**
     * manipulator of node value
     * @param n new value
     */
    public void setValue (int n) {
        this.value = n;
    }

    /**
     * accessor of node word
     * @return instance of node should not have word 
     */
    public String getWord(){
        throw new RuntimeException("This should not appear -- Node.getWord()");
    }

    /**
     * set status as true
     */
    public void setStatusTrue() {
        this.status = true;
    }

    /**
     * overrided toString method
     */
    public String toString() {
        return "value: " + String.valueOf(this.value) + "\nLChild: " + String.valueOf(this.LChild.getValue()) + "\nRChild: " + String.valueOf(this.RChild.getValue()) + "\nstatus: " + String.valueOf(this.status);
    }
    
}
