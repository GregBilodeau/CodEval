import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Many persons are familiar with the Roman numerals for relatively small numbers. The symbols I (capital i), V, X, L, C, D, and M represent the decimal values 1, 5, 10, 50, 100, 500 and 1000 respectively. To represent other values, these symbols, and multiples where necessary, are concatenated, with the smaller-valued symbols written further to the right. For example, the number 3 is represented as III, and the value 73 is represented as LXXIII. The exceptions to this rule occur for numbers having units values of 4 or 9, and for tens values of 40 or 90. For these cases, the Roman numeral representations are IV (4), IX (9), XL (40), and XC (90). So the Roman numeral representations for 24, 39, 44, 49, and 94 are XXIV, XXXIX, XLIV, XLIX, and XCIV, respectively. 

Write a program to convert a cardinal number to a Roman numeral.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Input example is the following

159
296
3992
Input numbers are in range [1, 3999]

OUTPUT SAMPLE:

Print out Roman numerals.

CLIX
CCXCVI
MMMCMXCII*/

public class RomanNumerals {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				line = line.trim();
				String levels[] = {"I","V","X","L","C","D","M","",""};
				// use 0, 2, 4, 6 as current
				StringBuilder sb = new StringBuilder();
				for(int i = line.length() - 1; i >= 0; i--){
					int digit = Integer.parseInt(line.substring(i, i+1));
					int levelIndex = ((line.length() - i) - 1) * 2;
					sb.insert(0, switchToRoman(digit, levels[levelIndex], levels[levelIndex + 1], levels[levelIndex + 2]));
					//System.out.println(digit + " : " + switchToRoman(digit, levels[levelIndex], levels[levelIndex + 1], levels[levelIndex + 2]));
				}
				System.out.println(sb.toString());
			}
			
		}
		fileScanner.close();
	}
	
	public static String switchToRoman(int number, String current, String middle, String next){
		switch(number){
			case 1:
				return current;
			case 2:
				return current + current;
			case 3:
				return current + current + current;
			case 4:
				return current + middle;
			case 5:
				return middle;
			case 6:
				return middle + current;
			case 7:
				return middle + current + current;
			case 8:
				return middle + current + current + current;
			case 9:
				return current + next;
			default:
				return "";
		}
	}

}
