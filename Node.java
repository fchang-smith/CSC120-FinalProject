public class Node {

    private int value;
    private Node parent;
    private Node LChild;
    private Node RChild;
    private Boolean status = false;

    public Node (int value, Node lChild, Node RChild) {
        this.value = value;
        this.parent = null;
        this.LChild = lChild;
        this.RChild = RChild;
    }

    public Node (int value, Node parent, Node LChild, Node RChild) {
        this.value = value;
        this.parent = parent;
        this.LChild = LChild;
        this.RChild = RChild;
    }

    public Node (int value, Node parent) {
        this.value = value;
        this.parent = parent;
        this.LChild = null;
        this.RChild = null;

    }

    public Node mergeNode(Node n1) {
        Node nNode = new Node(this.getValue()+n1.getValue(), this, n1);
        return nNode;
    }

    public int getValue() {
        return this.value;
    }

    public Node getParent() {
        return this.parent;
    }

    public Node getRChild() {
        return this.RChild;
    }

    public Node getLChild() {
        return this.LChild;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setParent (Node n) {
        this.parent = n;
    }

    public void setLChild (Node n) {
        this.LChild = n;
    }

    public void setRChild (Node n) {
        this.RChild = n;
    }

    public void setValue (int n) {
        this.value = n;
    }

    public void setStatusTrue() {
        this.status = true;
    }

    public String toString() {
        return "value: " + String.valueOf(this.value) + "\nparent: " + String.valueOf(this.parent.getValue()) + "\nLChild: " + String.valueOf(this.LChild.getValue()) + "\nRChild: " + String.valueOf(this.RChild.getValue()) + "\nstatus: " + String.valueOf(this.status);
    }

    
    
}
