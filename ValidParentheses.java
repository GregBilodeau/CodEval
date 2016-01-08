import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Given a string comprising just of the characters (,),{,},[,] determine if it is well-formed or not.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains a string comprising of the characters mentioned above. E.g.

()
([)]
OUTPUT SAMPLE:

Print out True or False if the string is well-formed. E.g.

True
False*/

public class ValidParentheses {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			boolean wellFormed = true;
			if(!line.equalsIgnoreCase("")){
				ArrayList<Character> parens = new ArrayList<Character>();
				
				if(line.length() % 2 != 0){
					wellFormed = false;
				}else{
					for(char c : line.toCharArray()){
						if(c == '(' || c == '{' || c == '['){
							parens.add(c);
						}else{
							if(parens.isEmpty()){
								wellFormed = false;
								break;
							}
							char lastChar = parens.remove(parens.size() - 1);
							if( ((int) c - (int) lastChar) > 2){
								wellFormed = false;
								break;
							}
						}
					}
					if(parens.size() > 0){
						wellFormed = false;
					}
					
				}
			}
			
			if(wellFormed){
				System.out.println("True");
			}else{
				System.out.println("False");
			}
		}
		fileScanner.close();
	}

}
