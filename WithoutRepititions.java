import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class WithoutRepititions {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				char characters[] = line.toCharArray();
				char currentChar = characters[0];
				for(int i = 0; i < characters.length; i++){
					if(characters[i] != currentChar){
						System.out.print(currentChar);
						currentChar = characters[i];
					}
				}
				System.out.print(currentChar);
			}
			System.out.println();
		}
		
		fileScanner.close();

	}
}
