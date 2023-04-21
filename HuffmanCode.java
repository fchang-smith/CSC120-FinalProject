import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Hashtable;

public class HuffmanCode {
  ArrayList<String> wordList;
  Hashtable<String, Integer> wordCound; 
  Tree tree;

    public HuffmanCode() {
      this.wordList = new ArrayList<String>();
      this.tree = null;
      this.wordCound = new Hashtable<String, Integer>();

    }

    public void loadFile(String filePath) {
      try {
        File myObj = new File(filePath);
        Scanner FileReader = new Scanner(myObj);
        while (FileReader.hasNextLine()) {
          String line = FileReader.nextLine();
          String [] list = line.split(" ");
          int length = list.length;
          for (int i = 0; i < length; i++) {
            this.wordList.add(list[i]);
          }
        }
        FileReader.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();}
    }

    public void buildTree() {
      if (this.wordList == null) {
        throw new RuntimeException("You need to load a text file using loadFile() first!");
      } else {
        this.countWord();
        this.tree = new Tree(wordCound);
        this.tree.build();
        }
      }
    

    private void countWord() {
      for (int i = 0; i < this.wordList.size(); i++) {
        String current = this.wordList.get(i);
        if (this.wordCound.containsKey(current)) {
          int value = this.wordCound.get(current);
          this.wordCound.replace(current, value+1);
        } else {
          this.wordCound.put(current, 1);
        }
      }
    }

    public static void main(String[] args) {
        HuffmanCode myCode = new HuffmanCode();
        myCode.loadFile("/Users/fiona/Library/Mobile Documents/com~apple~CloudDocs/smith/Study/2023_Spring/CSC_120/CSC120-FinalProject/TheBoarPrincess.txt");
        myCode.buildTree();
        
    }

}
