import java.io.ObjectInputFilter.Status;

public class WordNode extends Node {

    private String word;

    public WordNode (int value, Node parent, String word){
        super(value, parent);
        this.word = word;
    }

    public String toString() {
        return super.toString() + "\nword: " + this.word;
    }

    public static void main(String[] args) {
        WordNode myNode = new WordNode(2, null, "null");
        System.out.println(myNode);

    }

    
    
}
