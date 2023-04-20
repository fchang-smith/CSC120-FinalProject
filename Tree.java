import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class Tree {

   private Hashtable wordCount;
   private ArrayList<Node> tree;
   
   public Tree (Hashtable wordCount) {
    this.wordCount = wordCount;
    this.tree = new ArrayList<Node>();
   }

   public void build() {
      this.createNodes();
   }

   private int twoMinValue() {

   }

   private void createNodes() {
      Set set = this.wordCount.entrySet();
      Iterator it = set.iterator();
      while (it.hasNext()) {
         Map.Entry entry = (Map.Entry) it.next();
         this.tree.add(new WordNode(entry.getValue(), null, entry.getKey()));
      }
   }
}
