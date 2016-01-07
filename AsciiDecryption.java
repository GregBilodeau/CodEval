import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
