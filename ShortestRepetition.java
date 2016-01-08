import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Write a program to determine the shortest repetition in a string. 
A string is said to have period p if it can be formed by concatenating one or more repetitions of another string of length p. For example, the string "xyzxyzxyzxyz" has period 3, since it is formed by 4 repetitions of the string "xyz". It also has periods 6 (two repetitions of "xyzxyz") and 12 (one repetition of "xyzxyzxyzxyz").

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line will contain a string of up to 80 non-blank characters. E.g.

abcabcabcabc
bcbcbcbcbcbcbcbcbcbcbcbcbcbc
dddddddddddddddddddd
adcdefg
OUTPUT SAMPLE:

Print out the smallest period of the input string. E.g.

3
2
1
7*/

public class ShortestRepetition {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
				
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int lineLength = line.length();
				int minPeriod = lineLength;
				String testString = line.substring(0,minPeriod/2);
				while(testString.length() >= 1){
					int testStringLength = testString.length();
					String restOfString = line.substring(testStringLength, testStringLength + testStringLength);
					if(testString.equalsIgnoreCase(restOfString)){
						minPeriod = testStringLength;
					}
					testString = testString.substring(0, testStringLength - 1);
				}
				System.out.println(minPeriod);
			}
		}
		
		fileScanner.close();

	}

}
