import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class CountingPrimes {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String primeRange[] = line.split(",");
				int lower = Integer.parseInt(primeRange[0]);
				int upper = Integer.parseInt(primeRange[1]);
				int numPrimes = 0;
				for(int i = lower; i <= upper; i++){
					if(isPrime(i)){
						numPrimes++;
					}
				}
				System.out.println(numPrimes);
			}
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
