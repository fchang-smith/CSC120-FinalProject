public class WordNode extends Node {

    private String word;

    public WordNode (int value, Node parent, String word){
        super(value, parent);
        this.word = word;
    }

    public String toString() {
        return "value: " + String.valueOf(this.getValue()) + "\nword: " + this.word + "\nparent: " + String.valueOf(this.getParent().getValue()) +  "\nstatus: " + String.valueOf(this.getStatus());
    }

    public static void main(String[] args) {
        WordNode myNode = new WordNode(2, null, "null");
        System.out.println(myNode);
    }

    
    
}
