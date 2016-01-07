import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class RollerCoaster {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			int charCounter = 0;
			if(!line.equalsIgnoreCase("")){
				for(int i = 0; i < line.length(); i++){
					char letter = line.charAt(i);
					if(charCounter % 2 != 0){
						System.out.print(letter);
					}else{
						System.out.print(Character.toUpperCase(letter));
					}
					if((letter >= 65 && letter <= 90) || (letter >= 97 && letter <= 122)){
						charCounter++;
					}
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}
