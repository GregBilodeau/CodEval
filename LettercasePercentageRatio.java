import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Your task is to write a program which determines (calculates) the percentage ratio of lowercase and uppercase letters.

INPUT SAMPLE:

Your program should accept a file as its first argument. Each line of input contains a string with uppercase and lowercase letters.

For example:

1
2
3
4
thisTHIS
AAbbCCDDEE
N
UkJ
OUTPUT SAMPLE:

For each line of input, print the percentage ratio of uppercase and lowercase letters rounded to the second digit after the point.

For example:

1
2
3
4
lowercase: 50.00 uppercase: 50.00
lowercase: 20.00 uppercase: 80.00
lowercase: 0.00 uppercase: 100.00
lowercase: 33.33 uppercase: 66.67
*/

public class LettercasePercentageRatio {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int upper = 0;
				int lower = 0;
				int total = 0;
				double upperPercentage = 0.00;
				double lowerPercentage = 0.00;
				for(char character : line.toCharArray()){
					if(Character.isUpperCase(character)){
						upper++;
					}else{
						lower++;
					}
				}
				total = upper + lower;
								
				if(upper > 0){
					upperPercentage = (double)upper/total * 100;
				}else{
					upperPercentage = 0.0;
				}
				
				if(lower > 0){
					lowerPercentage = (double)lower/total * 100;
				}else{
					lowerPercentage = 0.0;
				}
				DecimalFormat df = new DecimalFormat("##0.00");
				System.out.println("lowercase: " + df.format(lowerPercentage) + " uppercase: " + df.format(upperPercentage));
				
			}
			
		}
		
		fileScanner.close();

	}

}
