import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

A number is a self-describing number when (assuming digit positions are labeled 0 to N-1), the digit in each position is equal to the number of times that that digit appears in the number.

INPUT SAMPLE:

The first argument is the pathname to a file which contains test data, one test case per line. Each line contains a positive integer. E.g.

2020
22
1210
OUTPUT SAMPLE:

If the number is a self-describing number, print out 1. If not, print out 0. E.g.

1
0
1
For the curious, here's how 2020 is a self-describing number: Position '0' has value 2 and there is two 0 in the number. Position '1' has value 0 because there are not 1's in the number. Position '2' has value 2 and there is two 2. And the position '3' has value 0 and there are zero 3's.*/

public class SelfDescribingNumbers {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int numbers[] = new int[10];
				char numChars[] = line.toCharArray();
				int selfy = 1;
				for(int i = 0; i < numbers.length; i++){
					numbers[i] = 0;
				}
				for(char c : numChars){
					int value = c - 48;
					numbers[value] = numbers[value] + 1;
				}
				for(int i = 0; i < numChars.length; i++){
					if( ( (int)numChars[i] - 48) != numbers[i]){
						selfy = 0;
					}
				}
				System.out.println(selfy);
			}
		}
		fileScanner.close();

	}

}
