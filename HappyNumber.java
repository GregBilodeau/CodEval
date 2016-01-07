import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class HappyNumber {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				char[] originalNumber = line.toCharArray();
				System.out.print(happyMe(originalNumber, line.length()));
			}
			System.out.println();
		}
		fileScanner.close();
	}
	
	public static int happyMe(char[] number, int length){
		int result = 0;
		LinkedList<Integer> pastNumbers = new LinkedList<Integer>();
		boolean seenThisNumber = false;
		int totalOfSquares = 0;
		
		while(totalOfSquares != 1 || !seenThisNumber){
			for(int i = 0; i < number.length; i++){
				int digit = number[i] - 8;
				int digitSquared = digit * digit;
				totalOfSquares += digitSquared;
			}
			// check for cycles
			for(int j = 0; j < pastNumbers.size(); j++){
				if(pastNumbers.contains(totalOfSquares)){
					// cycle
					seenThisNumber = true;
				}else{
					// add to the end of the array
					pastNumbers.add(totalOfSquares);
				}
			}
		}
		if(totalOfSquares == 1){
			result = 1;
		}
		return result;
	}
}
