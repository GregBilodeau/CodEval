import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class HexToDecimal {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int decimal = Integer.parseInt(line, 16);
				System.out.println(decimal);
			}
		}
		
		fileScanner.close();

	}

}
