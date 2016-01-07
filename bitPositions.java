import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class bitPositions {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String inputNumbers[] = line.split(",");
				int number, pos1, pos2;
				number = Integer.parseInt(inputNumbers[0]);
				pos1 = Integer.parseInt(inputNumbers[1]) - 1;
				pos2 = Integer.parseInt(inputNumbers[2]) - 1;
				int comparison1 = (number >> pos1) & 1;
				int comparison2 = (number >> pos2) & 1;
				if( comparison1 == comparison2 ){
					System.out.print("true");
				}else{
					System.out.print("false");
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}
}
