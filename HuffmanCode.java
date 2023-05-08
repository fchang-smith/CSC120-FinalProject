import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Hashtable;
import java.io.IOException;
import java.io.FileWriter;

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
        String [] nList = Arrays.copyOf(list, length+1);
        nList[length] = "\n";
        int n = nList.length;
        for (int i = 0; i < n; i++) {
          this.wordList.add(nList[i]);
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

  public void printTree () {
    Node rootNode = this.tree.findRootNode();
    ArrayList<Node> nodeList = new ArrayList<Node>();
    nodeList.add(rootNode);
    System.out.print(rootNode.getValue() + " ");
    System.out.println();
    boolean loop = true;
    while (loop) {
      nodeList = this.tree.printTree(nodeList);
      if (nodeList == null) {
        loop = false;
      }
    }
  }

  public void printTreeWord () {
    Node rootNode = this.tree.findRootNode();
    ArrayList<Node> nodeList = new ArrayList<Node>();
    nodeList.add(rootNode);
    System.out.print(rootNode.getValue() + " ");
    System.out.println();
    boolean loop = true;
    while (loop) {
      nodeList = this.tree.printTreeWord(nodeList);
      if (nodeList == null) {
        loop = false;
      }
    }
  }

  public String generateCode() {
    String code = "";
    for (String word : this.wordList) {
      code += this.tree.generateCode(word);
    }
    System.out.println(code);
    return code;
  }

  public String generateCode(String word) {
    String code = "";
    code = this.tree.generateCode(word);
    System.out.println(code);
    return code;
  }

  public void deCode(String code, String filePath) {
    char[] path = code.toCharArray();
    int idx = 0;
    try {
      File f = new File(filePath);
      if (!f.exists()){
        f.createNewFile();
      }
      FileWriter myWriter = new FileWriter(f);
      while (idx < path.length -1) {
        idx = convertCode(idx, path, filePath, myWriter);
      }
      myWriter.close();
      System.out.println("File is decompressed into: " + filePath);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    
  }

  private int convertCode(int idx, char[] path, String filePath, FileWriter myWriter) {
    Node upNode = this.tree.findRootNode();
    Node downNode = null;
    char zero = '0';
    for (int i = idx; i < path.length ; i++) {
      char edge = path[i];
      if (Character.compare(edge, zero)== 0) {
        downNode = upNode.getLChild();
      } else {
        downNode = upNode.getRChild();
      }
      upNode = downNode;
      if (!upNode.hasChild()) {
        try {
          myWriter.append(upNode.getWord());
          if (!upNode.getWord().equals("\n")) {
            myWriter.append(" ");
          }
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
        return i+1;
      } 
    }
    throw new RuntimeException("The code is incomplete");
  }

  public static void main(String[] args) {
      HuffmanCode myCode = new HuffmanCode();
      myCode.loadFile("/Users/fiona/Library/Mobile Documents/com~apple~CloudDocs/smith/Study/2023_Spring/CSC_120/CSC120-FinalProject/TheBoarPrincess.txt");
      myCode.buildTree();
      myCode.printTree();
      String huffmanCode = myCode.generateCode();
      //myCode.printTreeWord();
      // regenerate text into a test file "TestTheBoarPrincess"
      String filePath = "/Users/fiona/Library/Mobile Documents/com~apple~CloudDocs/smith/Study/2023_Spring/CSC_120/CSC120-FinalProject/TestTheBoarPrincess.txt";
      myCode.deCode(huffmanCode, filePath);
  }
}
