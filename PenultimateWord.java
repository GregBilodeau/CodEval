import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class PenultimateWord {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String[] words = line.split("\\s");
				System.out.println(words[words.length - 2]);
			}
		}
		
		fileScanner.close();

	}

}
