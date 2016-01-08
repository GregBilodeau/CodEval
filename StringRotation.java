import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

You are given two strings. Determine if the second string is a rotation of the first string.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains two comma separated strings. E.g.

Hello,lloHe
Basefont,tBasefon
OUTPUT SAMPLE:

Print out True/False if the second string is a rotation of the first. E.g.

True
True*/
public class StringRotation {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(",");
				String original = elements[0];
				String rotated = elements[1];
				boolean isRotated = false;
				
				if(original.length() != rotated.length()){
					isRotated = false;
				}else{
					String testString = original + original;
					if(testString.contains(rotated)){
						isRotated = true;
					}
				}
				if(isRotated){
					System.out.println("True");
				}else{
					System.out.println("False");
				}
			}
		}
		
		fileScanner.close();

	}

}
