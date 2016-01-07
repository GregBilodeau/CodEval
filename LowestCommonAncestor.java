import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Write a program to determine the lowest common ancestor of two nodes in a binary search tree. You may hardcode the following binary search tree in your program:

    30
    |
  ____
  |   |
  8   52
  |
____
|   |
3  20
    |
   ____
  |   |
  10 29
INPUT SAMPLE:

The first argument is a path to a file that contains two values. These values represent two nodes within the tree, one per line. E.g.:

8 52
3 29
OUTPUT SAMPLE:

Print to stdout the lowest common ancestor, one per line. Lowest means the lowest depth in the tree, not the lowest value. E.g.:

30
8*/

public class LowestCommonAncestor {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		String tree[] = {"30","8","52","3","20",null,null,null,null,"10","29"};
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split("\\s");
				String node1 = elements[0];
				String node2 = elements[1];
				int node1pos = 0;
				int node2pos = 0;
				for(int i = 0; i < tree.length; i++){
					if(node1.equalsIgnoreCase(tree[i])){
						node1pos = i + 1;
					}
					if(node2.equalsIgnoreCase(tree[i])){
						node2pos = i + 1;
					}
				}
				if(node1pos == 1 || node2pos == 1){
					System.out.println(tree[0]);
				}else{
					// start with largest position, find parents until both equal
					int node1Parent = getParent(node1pos);
					int node2Parent = getParent(node2pos);
					while(node1Parent != node2Parent && node1pos != node2Parent && node2pos != node1Parent){
						if(node1Parent > node2Parent){
							node1Parent = getParent(node1Parent);
						}else{
							node2Parent = getParent(node2Parent);
						}
					}
					int result = Math.max(node1Parent, node2Parent);
					if(result > 0){
						result -= 1;
					}
					System.out.println(tree[result]);
				}	
			}
		}
		fileScanner.close();
	}
	
	public static int getParent(int node){
		if(node % 2 == 0){
			return node / 2;
		}else{
			return (node - 1) / 2;
		}
	}

}
