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
				int originalNumber = Integer.parseInt(line);
				System.out.println(happyMe(originalNumber));
			}
		}
		fileScanner.close();
	}
	
	public static int happyMe(int number){
		int result = 0;
		LinkedList<Integer> pastNumbers = new LinkedList<Integer>();
		boolean seenThisNumber = false;
		int totalOfSquares = number;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		while(totalOfSquares != 1 && !seenThisNumber){
			while (totalOfSquares > 0) {
			    stack.push( totalOfSquares % 10 );
			    totalOfSquares = totalOfSquares / 10;
			}

			while (!stack.isEmpty()) {
				int digit = stack.pop();
				totalOfSquares += digit * digit;
			}
			// check for cycles
			if(pastNumbers.contains(totalOfSquares)){
				// cycle
				seenThisNumber = true;
			}else{
				// add to the end of the array
				pastNumbers.add(totalOfSquares);
			}
		}
		if(totalOfSquares == 1){
			result = 1;
		}
		return result;
	}
}
