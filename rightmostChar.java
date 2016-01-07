import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class rightmostChar {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String lineElements[] = line.split(",");
				String stringToSearch = lineElements[0];
				String searchString = lineElements[1];
				int lastIndex = stringToSearch.lastIndexOf(searchString);
				System.out.print(lastIndex);
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}
