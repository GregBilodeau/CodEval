import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FollowingInteger {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int number = Integer.parseInt(line);
				ArrayList<Integer> digits = new ArrayList<Integer>();
				while(number > 0){
					int digit = number % 10;
					digits.add(digit);
					number = number / 10;
				}
				Collections.reverse(digits);
				
				System.out.println();
			}
		}
		fileScanner.close();
	}

}
