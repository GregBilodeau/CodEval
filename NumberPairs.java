import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*CHALLENGE DESCRIPTION:

You are given a sorted array of positive integers and a number 'X'. Print out all pairs of numbers whose sum is equal to X. Print out only unique pairs and the pairs should be in ascending order

INPUT SAMPLE:

Your program should accept as its first argument a filename. This file will contain a comma separated list of sorted numbers and then the sum 'X', separated by semicolon. Ignore all empty lines. If no pair exists, print the string NULL e.g.

1,2,3,4,6;5
2,4,5,6,9,11,15;20
1,2,3,4;50
OUTPUT SAMPLE:

Print out the pairs of numbers that equal to the sum X. The pairs should themselves be printed in sorted order i.e the first number of each pair should be in ascending order. E.g.

1,4;2,3
5,15;9,11
NULL*/

public class NumberPairs {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(";");
				int sum = Integer.parseInt(elements[1]);
				String digits[] = elements[0].split(",");
				String answer = "";
				for(int i = 0; i < digits.length; i++){
					String digit1 = digits[i];
					if(digit1 != null){
						digits[i] = null;
						int number = Integer.parseInt(digit1);
						int remainder = sum - number;
						for(int j = i; j < digits.length; j++){
							String digit2 = digits[j];
							if(digit2 != null){
								int number2 = Integer.parseInt(digits[j]);
								if(remainder == number2){
									digits[j] = null;
									answer += number + "," + number2 + ";";
									break;
								}
							}
						}
					}
				}
				if(answer == ""){
					answer = "NULL";
				}else{
					answer = answer.substring(0, answer.length() - 1);
				}
				System.out.println(answer);
			}
		}
		fileScanner.close();
	}
}