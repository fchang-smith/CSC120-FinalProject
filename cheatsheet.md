This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

The way to use HuffmanCode class to encode and decode:
Encode:
1. create a new HuffmanCode instance: HuffmanCode myCode = new HuffmanCode();
2. load the path of the .txt file that you want to encode: myCode.loadFile(filePath)
3. build the binary tree: myCode.buildTree();
    3.1 <Optional> You can print the tree (only value of the nodes) by using myCode.printTree();
    3.2 <Optional> You can print the tree with the words by using myCode.printTreeWord();
4. generate the encrypted Huffman code (return String): myCode.generateCode();
Decode:
1. create a new HuffmanCode instance: HuffmanCode myCode2 = new HuffmanCode();
2. load the tree information, the generated code, and the path of file to decode: myCode2.decode(tree, huffmanCode, filepath); If success, the program will print "File is decompressed into: filePath".

# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.
