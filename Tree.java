import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;

public class Tree {

   private Hashtable<String, Integer> wordCount;
   private ArrayList<Node> tree;
   
   public Tree (Hashtable<String, Integer> wordCount) {
    this.wordCount = wordCount;
    this.tree = new ArrayList<Node>();
   }

   public void build() {
      this.createNodes();
      this.minValueIdx();
   }

   private void twoMinValue() {
      for (Node node: this.tree) {
         if (!node.getStatus()) {
            int idx1 = this.minValueIdx();
            
         }
      }
      
   }

   private int minValueIdx() {
      int value;
      int idx;
      for (Node node : this.tree) {
         if (!node.getStatus()) {
            value = node.getValue();
            idx = this.tree.indexOf(node);
         }
         break;
      }
      for (Node node : this.tree) {
         if (!node.getStatus() && value > node.getValue()) {
            value = node.getValue();
            node.setStatusTrue();
            idx = this.tree.indexOf(node);
         }
      }
      System.out.println("Min: " + this.tree.get(idx));
      return idx;
   }

   private void createNodes() {
      Set<Entry<String, Integer>> entrySet = this.wordCount.entrySet();
      Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
      while(iterator.hasNext()) {
         Entry<String, Integer> entry2 = iterator.next();
         int value = entry2.getValue();
         String word = entry2.getKey();
         WordNode myNode = new WordNode(value, null, word);
         this.tree.add(myNode);
      }
      for (int i = 0; i < this.tree.size(); i++) {
         System.out.println("The very first wordNode list: ");
         System.out.println(this.tree.get(i));
      }
   }

   // public static void main(String[] args) {
   //    Hashtable myTable = new Hashtable<String, Integer>();
   //    myTable.put("args1", 3);
   //    myTable.put("args2", 4);
   //    Tree myTree = new Tree(myTable);
   //    myTree.build();
   // }
}
