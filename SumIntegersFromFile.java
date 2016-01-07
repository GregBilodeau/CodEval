import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class SumIntegersFromFile {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		int total = 0;
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				total += Integer.parseInt(line);
			}
		}
		
		System.out.print(total);
		
		fileScanner.close();

	}

}
