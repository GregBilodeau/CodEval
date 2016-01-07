import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class SumOfDigits {

	public static void main(String[] args) throws IOException{
		
		File file = new File(args[0]);
		
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int total = 0;
				//adjust for newline character
				for(int i = 0; i < line.length(); i++){
					total += Character.getNumericValue(line.charAt(i));
				}
				System.out.println(total);
			}
		}
		fileScanner.close();
	} 

}