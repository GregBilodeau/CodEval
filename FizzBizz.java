import java.io.*;
import java.util.*;

public class FizzBizz {

	public static void main(String[] args) throws IOException {
		
	//File file = new File(args[0]);
	FileReader file = new FileReader("fizzbizz.txt");
	Scanner fileScanner = new Scanner(file);
	
	int testCases = 0;
	
	while(fileScanner.hasNextLine()){
		if(testCases <= 20){
			String line = fileScanner.nextLine();
			String numbers[] = line.split("\\s");
			int firstDivider, secondDivider, countLimit = 0;
			firstDivider = Integer.parseInt(numbers[0]);
			secondDivider = Integer.parseInt(numbers[1]);
			countLimit = Integer.parseInt(numbers[2]);
			
			// enforce constraints
			if(firstDivider > 20){
				firstDivider = 20;
			}else if (firstDivider < 1){
				firstDivider = 1;
			}
			
			if(secondDivider > 20){
				secondDivider = 20;
			}else if (secondDivider < 1){
				secondDivider = 1;
			}
			
			if(countLimit > 100){
				countLimit = 100;
			}else if (countLimit < 21){
				countLimit = 21;
			}
			
			
			for(int i = 1; i <= countLimit; i++){
				if(i % (firstDivider * secondDivider) == 0){
					System.out.print("FB");
				}else if(i % secondDivider == 0){
					System.out.print("B");
				}else if(i % firstDivider == 0){
					System.out.print("F");
				}else{
					System.out.print(i);
				}
				if(i < countLimit){
					System.out.print(" ");
				}
			}
			System.out.println();
			testCases++;
		}
	}
	fileScanner.close();
	} 
	

}


