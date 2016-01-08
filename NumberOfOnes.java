import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Write a program which determines the number of 1 bits in the internal representation of a given integer.

INPUT SAMPLE:

The first argument is a path to a file. The file contains integers, one per line.

For example:

1
2
3
10
22
56
OUTPUT SAMPLE:

Print to stdout the number of ones in the binary form of each number.

For example:

1
2
3
2
3
3
*/

public class NumberOfOnes {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int number = Integer.parseInt(line);
				String binary = Integer.toBinaryString(number);
				int oneCount = 0;
				for(char c : binary.toCharArray()){
					if(c == '1'){
						oneCount++;
					}
				}
				System.out.println(oneCount);
			}
		}
		fileScanner.close();
	}

}
