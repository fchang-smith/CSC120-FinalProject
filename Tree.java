import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;

/**
 * binary tree
 */
public class Tree {

   private Hashtable<String, Integer> wordCount;
   private ArrayList<Node> tree;
   
   /**
    * constructor 
    * @param wordCount hashtable with words and wordcount
    */
   public Tree (Hashtable<String, Integer> wordCount) {
    this.wordCount = wordCount;
    this.tree = new ArrayList<Node>();
   }

   /**
    * convert individual word into words and build tree
    */
   public void build() {
      this.createNodes();
      this.twoMinValue();
      this.buildTree();
   }


   /**
    * build tree
    */
   private void buildTree() {
      while(this.isPossible()) {
         this.twoMinValue();
      }
   }


   /**
    * Get 2 nodes with minimal values and add together to form a new node 
    */
   private void twoMinValue() {
      int idx1 = this.minValueIdx();
      int idx2 = this.minValueIdx();
      Node n = this.tree.get(idx1);
      Node n1 = this.tree.get(idx2);
      Node newNode = n.mergeNode(n1);
      n.setParent(newNode);
      n1.setParent(newNode);
      this.tree.add(newNode);
   }

   /**
    * check if it is possible to find more than 1 unchosen node
    * @return
    */
   private boolean isPossible() {
      int t = 0;
      for (int i = 0; i< this.tree.size(); i++) {
         if (!this.tree.get(i).getStatus()) {
            t += 1;
         }
      }
      if (t >= 2) {
         return true;
      } else {
         return false;
      }
   }

   /**
    * find the node with least value
    * @return index 
    */
   private int minValueIdx() {
      int value = -1;
      int idx = -1;
      for (int i = 0; i < this.tree.size(); i++) {
         boolean check = this.tree.get(i).getStatus();//should be false
         if (!check) {
            value = this.tree.get(i).getValue();
            idx = i;
            break;
         }
      } 
      for (Node n : this.tree) {
         boolean check = !n.getStatus();//should be false
         if (check && n.getValue()< value) {
            idx = this.tree.indexOf(n);
            value = n.getValue();
         }
      }
      this.tree.get(idx).setStatusTrue();
      return idx;
      
   }

   /**
    * generate code
    * @param s generate code for a specific word s
    * @return code for a specific word
    */
   public String generateCode(String s) {
      Node keyNode = null;
      String code = "If this then wrong";
      for (Node node : this.tree) {
         if (node.isWordNode() && node.getWord().equals(s)) {
            keyNode = node;
            code = this.searchBack(keyNode);
            break;
         }
      }
      return code;
   }

   /**
    * check if the nodelist has element
    * @param nodeList the nodelist to be checked
    * @return true if it contains at least one element
    */
   public static boolean checkNull(ArrayList<Node> nodeList) {
      boolean notNull = false;
      for (Node node : nodeList) {
        if (node != null) {
          notNull = true;
        }
      }
      return notNull;
    }

    /**
     * print out tree with word
     * @param nodeList list with all nodes
     * @return arraylist
     */
   public ArrayList<Node> printTreeWord(ArrayList<Node> nodeList) {
      ArrayList<Node> nextList = new ArrayList<Node>();
      for (Node node : nodeList) {
         if (node != null && node.hasChild()) {
            nextList.add(node.getLChild());
            nextList.add(node.getRChild());
         } else {
            nextList.add(null);
            nextList.add(null);
         }
      }
      String printList = "";
      boolean notNull = checkNull(nodeList);
      if (notNull) {
         for (Node node : nextList) {
            if (node != null) {
               if (node.getClass().getName().equals("WordNode")) {
                  printList = printList + node.getValue() + "(" + node.getWord() + ")";
               } else {
                  printList += node.getValue() + " ";
               }
            } else {
               printList += "_ ";
            }
         }
         System.out.println(printList);
      } else {
         nextList = null;
      }
      return nextList;
   }

   /**
    * print out tree
    * @param nodeList list with all nodes
    * @return arraylist
    */
   public ArrayList<Node> printTree(ArrayList<Node> nodeList) {
      ArrayList<Node> nextList = new ArrayList<Node>();
      for (Node node : nodeList) {
         if (node != null && node.hasChild()) {
            nextList.add(node.getLChild());
            nextList.add(node.getRChild());
         } else {
            nextList.add(null);
            nextList.add(null);
         }
      }
      String printList = "";
      boolean notNull = checkNull(nodeList);
      if (notNull) {
         for (Node node : nextList) {
            if (node != null) {
               printList += node.getValue() + " ";
            } else {
               printList += "_ ";
            }
         }
         System.out.println(printList);
      } else {
         nextList = null;
      }
      return nextList;
   }

   /**
    * find the root node of a tree
    * @return root node
    */
   public Node findRootNode() {
      Node rootNode = null;
      for (Node node : this.tree) {
         if (!node.hasParent()) {
            rootNode = node;
            break;
         }
      }
      return rootNode;
   }

   /**
    * assign code to node by searching back the tree
    * @param n the node you want to know
    * @return the code of the node
    */
   private String searchBack(Node n) {
      Node parentNode = null;
      boolean loop = n.hasParent();
      String code = "";
      while (loop) {
         parentNode = n.getParent();
         if (parentNode.getLChild().equals(n)) {
            code = "0" + code;
         } else {
            code = "1" + code;
         }
         n = parentNode;
         loop = parentNode.hasParent();
      }
      return code;
   }


   /**
    * convert individual word into nodes
    */
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
   }

   /**
    * print out node list
    */
   public void printNodeList(){
      for (Node node : this.tree) {
         int idx = this.tree.indexOf(node);
         int value = node.getValue();
         String status = String.valueOf(node.getStatus());
         String parent = "";
         String LChild = "";
         String RChild = "";
         if (node.getParent() == null) {
            parent = "null";
         } else {
            parent = String.valueOf(node.getParent().getValue());
         }
         if (node.getLChild() == null) {
            LChild = "null";
         } else {
            LChild = String.valueOf(node.getLChild().getValue());
         }
         if (node.getRChild() == null) {
            RChild = "null";
         } else {
            RChild = String.valueOf(node.getRChild().getValue());
         }
         System.out.println("idx: " + idx);
         System.out.println("value: " + value);
         if (node.getClass().getName().equals("WordNode")) {
            System.out.println("word: " + node.getWord());
         }
         System.out.println("parent: " + parent);
         System.out.println("LChild: " + LChild);
         System.out.println("RChild: " + RChild);
         System.out.println("status: " + status);
      }
   }
}
