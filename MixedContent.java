import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/*CHALLENGE DESCRIPTION:

You have a string of words and digits divided by comma. Write a program which separates words with digits. You shouldn't change the order elements.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Input example is the following

8,33,21,0,16,50,37,0,melon,7,apricot,peach,pineapple,17,21
24,13,14,43,41
OUTPUT SAMPLE:

melon,apricot,peach,pineapple|8,33,21,0,16,50,37,0,7,17,21
24,13,14,43,41
As you cas see you need to output the same input string if it has words only or digits only.*/

public class MixedContent {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
				
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(",");
				LinkedList<String> words = new LinkedList<String>();
				LinkedList<String> digits = new LinkedList<String>();
				String wordList = "";
				String digitList = "";
				for(String item : elements){
					char c = item.charAt(0);
					int ascii = (int) c;
					if(ascii >= 48 && ascii <= 57){
						digits.add(item);
					}else{
						words.add(item);
					}
				}
				if(!words.isEmpty()){
					for(String word : words){
						wordList += word + ",";
					}
				}
				if(!digits.isEmpty()){
					for(String digit : digits){
						digitList += digit + ",";
					}
				}
				
				if(!wordList.isEmpty()){
					wordList = wordList.substring(0, wordList.length() - 1);
					System.out.print(wordList);
				}
				if(!wordList.isEmpty() && !digitList.isEmpty()){
					System.out.print("|");
				}
				if(!digitList.isEmpty()){
					digitList = digitList.substring(0, digitList.length() - 1);
					System.out.print(digitList);
				}
				System.out.println();
			}
		}
		
		fileScanner.close();

	}

}
