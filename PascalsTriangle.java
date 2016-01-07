import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:


A Pascals triangle row is constructed by looking at the previous row and adding the numbers to its left and right to arrive at the new value. If either the number to its left/right is not present, substitute a zero in it's place. More details can be found here: Pascal's triangle. E.g. a Pascal's triangle upto a depth of 6 can be shown as:

            1
          1   1
        1   2   1
       1  3   3   1
     1  4   6   4   1
    1  5  10  10  5   1
INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains a positive integer which indicates the depth of the triangle (1 based). E.g.

6
OUTPUT SAMPLE:

Print out the resulting pascal triangle upto the requested depth in row major form. E.g.

1 1 1 1 2 1 1 3 3 1 1 4 6 4 1 1 5 10 10 5 1*/

public class PascalsTriangle {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int depth = Integer.parseInt(line);
				
				int numOfNodes = (depth * (depth + 1))/2;
				
				int[] tree = new int[numOfNodes];
				
				tree[0] = 1;
				
				int prevIndex = 0;
				
				for(int i = 2; i <= depth; i++){
					int nextIndex = prevIndex + (i - 1);
					int lastIndex = nextIndex + (i - 1);
					//System.out.println(nextIndex + " : " + lastIndex);
					
					// this row has depth elements in it
					for(int j = 0; j < depth; j++){
						
						int myIndex = nextIndex + j;
						int myVal = 1;
						
						int leftParIndex = myIndex - i;
						int rightParIndex = myIndex - (i - 1);
						int leftPar, rightPar;
						leftPar = 0;
						rightPar = 0;
						
						//System.out.println("\tmyIndex: " + myIndex + " : " + leftParIndex + "," + rightParIndex);
						
						if(myIndex > nextIndex){
							leftPar = tree[leftParIndex];
						}
						if(myIndex < lastIndex){
							rightPar = tree[rightParIndex];
						}
						myVal = leftPar + rightPar;
						tree[myIndex] = myVal;
					}
					prevIndex = nextIndex;
				}
				String output = "";
				for(int num : tree){
					output += num + " ";
				}
				System.out.print(output.substring(0,output.length() - 1));
			}
			System.out.println();
		}
		fileScanner.close();
	}
}
