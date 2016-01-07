import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UniqueElements {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String inputNumbers[] = line.split(",");
				int currentNum = Integer.parseInt(inputNumbers[0]);
				for(int i = 0; i < inputNumbers.length; i++){
					String number = inputNumbers[i];
					int num = Integer.parseInt(number);
					if(currentNum != num){
						System.out.print(currentNum + ",");
						currentNum = num;
					}
				}
				System.out.print(currentNum);
			}
			System.out.println();
		}
		
		fileScanner.close();

	}
}
