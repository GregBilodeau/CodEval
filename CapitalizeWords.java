import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class CapitalizeWords {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String words[] = line.split("\\s");
				for(int i = 0; i < words.length; i++){
					String capWord = words[i];
					System.out.print(Character.toUpperCase(capWord.charAt(0)) + capWord.substring(1) + " ");
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}
