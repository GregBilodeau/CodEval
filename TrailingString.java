import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*CHALLENGE DESCRIPTION:

There are two strings: A and B. Print 1 if string B occurs at the end of string A. Otherwise, print 0.

INPUT SAMPLE:

The first argument is a path to the input filename containing two comma-delimited strings, one per line. Ignore all empty lines in the input file.

For example:

1
2
3
Hello World,World
Hello CodeEval,CodeEval
San Francisco,San Jose
OUTPUT SAMPLE:

Print 1 if the second string occurs at the end of the first string. Otherwise, print 0.

For example:

1
2
3
1
1
0
*/

public class TrailingString {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String strings[] = line.split(",");
				String a = strings[0];
				String b = strings[1];
				if(a.endsWith(b)){
					System.out.println("1");
				}else{
					System.out.println("0");
				}
			}
		}
		
		fileScanner.close();

	}

}
