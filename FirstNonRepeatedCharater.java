import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * CHALLENGE DESCRIPTION:

Write a program which finds the first non-repeated character in a string.

INPUT SAMPLE:

The first argument is a path to a file. The file contains strings.

For example:

1
2
yellow
tooth
OUTPUT SAMPLE:

Print to stdout the first non-repeated character, one per line.

For example:

1
2
y
h
*/

public class FirstNonRepeatedCharater {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				TreeMap<Character, Integer> letterFreq = new TreeMap<Character, Integer>();
				for(char c : line.toCharArray()){
					if(letterFreq.containsKey(c)){
						letterFreq.put(c, letterFreq.get(c) + 1);
					}else{
						letterFreq.put(c, 1);
					}
				}
				
				for(char c : line.toCharArray()){
					if(letterFreq.get(c) == 1){
						System.out.println(c);
						break;
					}
				}
			}
			
		}
		fileScanner.close();
	}
}
