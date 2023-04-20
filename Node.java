public class Node {

    private int value;
    private Node parent;
    private Node LChild;
    private Node RChild;

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

    public int getValue() {
        return this.value;
    }

    public String getParent() {
        return this.parent;
    }

    public String getRChild() {
        return this.RChild;
    }

    public String getLChild() {
        return this.LChild;
    }
}
