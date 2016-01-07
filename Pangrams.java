import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Pangrams {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int letterCount[] = new int[26];
				for(int i = 0; i < letterCount.length; i++){
					letterCount[i] = 0;
				}
				for(int i = 0; i < line.length(); i++){
					char c = line.charAt(i);
					if(Character.isLetter(c)){
						int index = ((int)Character.toLowerCase(c)) - 97;
						letterCount[index] = 1;
					}
				}
				int count = 0;
				for(int i = 0; i < letterCount.length; i++){
					if(letterCount[i] == 0){
						System.out.print((char) (i + 97) );
						count++;
					}
				}
				if(count == 0){
					System.out.print("NULL");
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}
