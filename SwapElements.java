import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

You are given a list of numbers which is supplemented with positions that have to be swapped.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Input example is the following

1 2 3 4 5 6 7 8 9 : 0-8
1 2 3 4 5 6 7 8 9 10 : 0-1, 1-3
As you can see a colon separates numbers with positions. 
Positions start with 0. 
You have to process positions left to right. In the example above (2nd line) first you process 0-1, then 1-3.

OUTPUT SAMPLE:

Print the lists in the following way.

9 2 3 4 5 6 7 8 1
2 4 3 1 5 6 7 8 9 10*/

public class SwapElements {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
				
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(":");
				String numList = elements[0];
				String swapList = elements[1];
				String numArray[] = numList.split("\\s");
				String swapArray[] = swapList.split(", ");
				for(String swapPair : swapArray){
					swapPair = swapPair.trim();
					int hyphenIndex = swapPair.indexOf("-");
					int swap1index = Integer.parseInt(swapPair.substring(0, hyphenIndex));
					int swap2index = Integer.parseInt(swapPair.substring(hyphenIndex + 1));
					String swap1, swap2;
					swap1 = numArray[swap1index];
					swap2 = numArray[swap2index];
					numArray[swap1index] = swap2;
					numArray[swap2index] = swap1;
				}
				System.out.println(outputArray(numArray));
			}
		}
		
		fileScanner.close();

	}
	
	public static String outputArray(String array[]){
		StringBuilder sb = new StringBuilder();
		for(String digit : array){
			sb.append(digit + " ");
		}
		return sb.toString().trim();
	}

}
