/**
 * subclass of node, node with both value and word
 */
public class WordNode extends Node {

    private String word;

    /**
     * constructor
     * @param value value
     * @param parent parent node
     * @param word word
     */
    public WordNode (int value, Node parent, String word){
        super(value, parent);
        this.word = word;
    }

    /**
     * accessor
     * @return string word
     */
    public String getWord() {
        return this.word;
    }

    /**
     * overrided toString
     * @return String
     */
    public String toString() {
        return "value: " + String.valueOf(this.getValue()) + "\nword: " + this.word + "\nparent: " + String.valueOf(this.getParent().getValue()) +  "\nstatus: " + String.valueOf(this.getStatus());
    }

    /**
     * check if it is wordNode
     * @return true if it is
     */
    public boolean isWordNode() {
        return true;
    }

    public static void main(String[] args) {
        WordNode myNode = new WordNode(2, null, "null");
        System.out.println(myNode);
    }

    
    
}
