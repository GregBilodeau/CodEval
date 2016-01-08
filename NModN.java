import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*CHALLENGE DESCRIPTION:

Given two integers N and M, calculate N Mod M (without using any inbuilt modulus operator).

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains two comma separated positive integers. E.g.

20,6
2,3
You may assume M will never be zero.

OUTPUT SAMPLE:

Print out the value of N Mod M*/

public class NModN {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(",");
				int dividend = Integer.parseInt(elements[0]);
				int divisor = Integer.parseInt(elements[1]);
				int modValue = dividend;
				while(modValue >= divisor){
					modValue -= divisor;
				}
				System.out.println(modValue);
			}
			
		}
		fileScanner.close();
	}
}
