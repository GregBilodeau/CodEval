import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Write a program which removes specific characters from a string.

INPUT SAMPLE:

The first argument is a path to a file. The file contains the source strings and the characters that need to be scrubbed. Each source string and characters you need to scrub are delimited by comma.

For example:

2
how are you, abc
hello world, def
OUTPUT SAMPLE:

Print to stdout the scrubbed strings, one per line. Ensure that there are no trailing empty spaces on each line you print.

For example:

1
2
how re you
hllo worl
*/

public class RemoveCharacters {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(",");
				String toScrub = elements[0].trim();
				String scrubbers = elements[1].trim();
				for(char character : scrubbers.toCharArray()){
					toScrub = toScrub.replaceAll(Character.toString(character), "");
				}
				System.out.println(toScrub);
			}
			
		}
		
		fileScanner.close();

	}

}
