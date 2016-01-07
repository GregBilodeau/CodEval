import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ArmstrongNumbers {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int nPower = line.length();
				int originalNumber = Integer.parseInt(line);
				int digitTotal = 0;
				for(int i = 0; i < nPower; i++){
					int digit = line.charAt(i) - 48;
					int digitToTheN = (int) Math.pow(digit, nPower);
					digitTotal += digitToTheN;
				}
				if(digitTotal == originalNumber){
					System.out.print("True");
				}else{
					System.out.print("False");
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}
	
}
