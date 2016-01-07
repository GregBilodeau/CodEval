import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * CHALLENGE DESCRIPTION:

Imagine we have an immutable array of size N which we know to be filled with integers ranging from 0 to N-2, inclusive. Suppose we know that the array contains exactly one duplicated entry and that duplicate appears exactly twice. Find the duplicated entry. (For bonus points, ensure your solution has constant space and time proportional to N)

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file is one test case. Ignore all empty lines. Each line begins with a positive integer(N) i.e. the size of the array, then a semicolon followed by a comma separated list of positive numbers ranging from 0 to N-2, inclusive. i.e eg.

1
2
5;0,1,2,3,0
20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14
OUTPUT SAMPLE:

Print out the duplicated entry, each one on a new line eg

1
2
0
4
 * 
 */
public class ArrayAbsurdity {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(";");
				String numbers[] = elements[1].split(",");
				TreeMap<String, Integer> freq = new TreeMap<String, Integer>();
				for(String number : numbers){
					if(freq.containsKey(number)){
						// duplicate
						System.out.println(number);
						break;
					}else{
						freq.put(number, 1);
					}
				}
			}
		}
		
		fileScanner.close();

	}

}