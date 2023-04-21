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
      this.twoMinValue();
      for (int i = 0; i < this.tree.size(); i++){
      System.out.println(i);
      }
      this.buildTree();
      for (int i = 0; i < this.tree.size(); i++){
         System.out.println(this.tree.get(i).getClass());
         System.out.println(this.tree.get(i));
      }
   }

   private void buildTree() {
      while(this.isPossible()) {
         this.twoMinValue();
      }
   }

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

   private boolean isPossible() {
      System.out.println("enter isPossible");
      int t = 0;
      for (int i = 0; i< this.tree.size(); i++) {
         if (!this.tree.get(i).getStatus()) {
            t += 1;
         }
      }
      System.out.println(t);
      if (t >= 2) {
         System.out.println(true);
         return true;
      } else {
         System.out.println(false);
         return false;
      }
   }

   private int minValueIdx() {
      int value = -1;
      int idx = -1;
      for (int i = 0; i < this.tree.size(); i++) {
         boolean check = this.tree.get(i).getStatus();//should be false
         if (!check) {
            value = this.tree.get(i).getValue();
            idx = i;
            System.out.println("starting idx:" + idx);
            System.out.println("starting value: "+value);
            break;
         }
      } 
      for (Node n : this.tree) {
         boolean check = !n.getStatus();//should be false
         if (check && n.getValue()< value) {
            System.out.println("original value: " + value);
            System.out.println("i: " + this.tree.indexOf(n));
            System.out.println("this.tree.get(i).getValue()< value: "+ n.getValue() + "<" + value);
            idx = this.tree.indexOf(n);
            value = n.getValue();
            System.out.println("final idx: " + idx);
            System.out.println("final value:" + n.getValue());
         }
      }
      this.tree.get(idx).setStatusTrue();
      System.out.println("idx from minValueIdx: " + idx);
      System.out.println(this.tree.get(idx).getStatus());
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
   }


   // public static void main(String[] args) {
   //    Hashtable<String, Integer> myTable = new Hashtable<String, Integer>();
   //    myTable.put("args1", 3);
   //    myTable.put("args2", 4);
   //    myTable.put("args3", 1);
   //    Tree myTree = new Tree(myTable);
   //    myTree.build();
   // }

   // for (int i = 0; i < this.tree.size(); i++){
   //    System.out.println(this.tree.get(i));
   // }
}
