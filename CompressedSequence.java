import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class CompressedSequence {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String[] numbers = line.split("\\s");
				int currentNum = Integer.MAX_VALUE;
				int count = 1;
				for(int i = 0; i < numbers.length; i++){
					int num = Integer.parseInt(numbers[i]);
					if(num != currentNum){
						if(currentNum != Integer.MAX_VALUE){
							System.out.print(count + " " + currentNum);
						}
						System.out.print(" ");
						currentNum = num;
						count = 1;
					}else{
						count++;
					}
				}
				System.out.print(count + " " + currentNum);
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}
