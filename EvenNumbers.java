import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class EvenNumbers {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int number = Integer.parseInt(line);
				if(number % 2 == 0){
					System.out.println("1");
				}else{
					System.out.println("0");
				}
			}
		}
		fileScanner.close();

	}

}
