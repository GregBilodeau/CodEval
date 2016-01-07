import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class MultiplesOfANumber{

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String[] numbers = line.split(",");
				int x = Integer.parseInt(numbers[0]);
				int n = Integer.parseInt(numbers[1]);
				
				int lowestMultiple = n;
				int multiplier = 2;
				while(lowestMultiple < x){
					lowestMultiple = n * multiplier;
					multiplier++;
				}
				System.out.println(lowestMultiple);
				
			}
		}
		fileScanner.close();

	}

}
