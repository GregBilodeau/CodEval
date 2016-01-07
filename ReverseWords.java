import java.io.*;
import java.util.*;

public class ReverseWords {

	public static void main(String[] args) throws IOException {
		
	//File file = new File(args[0]);
	FileReader file = new FileReader("reverseWords.txt");
	Scanner fileScanner = new Scanner(file);
	
	while(fileScanner.hasNextLine()){
		String line = fileScanner.nextLine();
		if(!line.equalsIgnoreCase("")){
			String words[] = line.split("\\s");
			outputReversed(words);
			System.out.println();
		}
		
	}
	fileScanner.close();
	} 
	
	private static void outputReversed(String[] words){
		for(int i = words.length - 1; i >= 0; i--){
			System.out.print(words[i]);
			if(i > 0){
				System.out.print(" ");
			}
		}
	}
}