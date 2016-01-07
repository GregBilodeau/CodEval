import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:
 * You are an analyst at the Central Intelligence Agency, and you have intercepted a top secret encrypted message which contains numbers. Each number is obtained by taking an ASCII code of the original character and adding some unknown constant N.
 * For example, you can encrypt the word 'test' with the condition that N = 11.
 * 'test' to ASCII -> 116 101 115 116 -> add N to each number-> 127 112 126 127
 * Based on previous intelligence reports, you know that the original message includes two identical words consisting of X characters and you know the last letter in the word.
 *
 * Your challenge is to decrypt the message.
 * INPUT SAMPLE:
 * Your program should accept as its first argument a path to a filename.
 * Each line of input consists of three parts: length of a word, which is repeated twice, the last letter of this word, and an encrypted message separated with space:
 * 1
 * 5 | s | 92 112 109 40 118 109 109 108 123 40 119 110 40 124 112 109 40
 * 117 105 118 129 40 119 125 124 127 109 113 111 112 40 124 112 109 40 118
 * 109 109 108 123 40 119 110 40 124 112 109 40 110 109 127 54 40 53 40 91
 * 120 119 107 115
 * OUTPUT SAMPLE:
 * For each line of input print out decrypted message
*/

public class AsciiDecryption {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String slots[] = line.split("\\|");
				int lengthOfRepeatWord = Integer.parseInt(slots[0].trim());
				String lastLetter = slots[1].trim();
				String message = slots[2].trim();
				String messageCodes[] = message.split("\\s");
				boolean foundDouble = false;
				int windowStartIndex = 0;
				int windowEndIndex = messageCodes.length - lengthOfRepeatWord;
				int window[] = new int[lengthOfRepeatWord];
				int testWindow[] = new int[lengthOfRepeatWord];
				while(!foundDouble){
					System.out.println(windowStartIndex);
					// create a window starting at windowStartIndex
					for(int i = 0; i < lengthOfRepeatWord; i++){
						window[i] = Integer.parseInt(messageCodes[windowStartIndex]);
					}
					
					// slide through messageCodes creating testWindows
					// if they are the same, set soundDouble to true
					
					for(int i = 0; i < windowEndIndex; i++){
						for(int j = 0; j < lengthOfRepeatWord; j++){
							testWindow[j] = Integer.parseInt(messageCodes[i + j]);
						}
						if(window == testWindow){
							// found our duplicate
							System.out.print("Dup found");
							foundDouble = true;
						}
					}
					
					// increment window if not found
					windowStartIndex++;
					
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}
