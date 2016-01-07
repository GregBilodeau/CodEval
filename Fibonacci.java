import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Fibonacci {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int number = Integer.parseInt(line);
				System.out.print(doFib(number));
			}
			System.out.println();
		}
		
		fileScanner.close();

	}
	
	public static int doFib(int seed){
		int returnVal = 0;
		
		if(seed == 0){
			returnVal = 0;
		}else if(seed == 1){
			returnVal = 1;
		}else{
			returnVal = doFib(seed - 1) + doFib(seed - 2);
		}
		
		return returnVal;
	}
}
