import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class PrimeNumbers {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			String outputString = "";
			if(!line.equalsIgnoreCase("")){
				int upper = Integer.parseInt(line);
				for(int i = 2; i <= upper; i++){
					if(isPrime(i)){
						outputString += i + ",";
					}
				}
			}
			outputString = outputString.substring(0, outputString.length() - 1);
			System.out.println(outputString);
		}
		fileScanner.close();

		
	}
	
	public static boolean isPrime(int number){
		if (number <= 1) {
			return false;
	    }
	    for (int i = 2; i <= number/2; i++) {
	    	if (number % i == 0) {
	    		return false;
	        }
	    }
	    return true;
	}

}
