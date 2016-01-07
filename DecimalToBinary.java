import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DecimalToBinary {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int decNumber = Integer.parseInt(line);
				System.out.println(Integer.toString(decNumber, 2));
			}
		}
		
		fileScanner.close();

	}

}
