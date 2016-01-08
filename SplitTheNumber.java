import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

You are given a number N and a pattern. The pattern consists of lowercase latin letters and one operation "+" or "-". The challenge is to split the number and evaluate it according to this pattern e.g. 
1232 ab+cd -> a:1, b:2, c:3, d:2 -> 12+32 -> 44

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line of the file is a test case, containing the number and the pattern separated by a single whitespace. E.g.

1
2
3
4
5
3413289830 a-bcdefghij
776 a+bc
12345 a+bcde
1232 ab+cd
90602 a+bcde
OUTPUT SAMPLE:

For each test case print out the result of pattern evaluation. E.g.

1
2
3
4
5
-413289827
83
2346
44
611
Constraints: 
N is in range [100, 1000000000]*/

public class SplitTheNumber {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split("\\s");
				String digits = elements[0];
				String operation = elements[1];
				int operatorIndex = -1;
				boolean add = false;
				if(operation.indexOf("-") != -1){
					operatorIndex = operation.indexOf("-");
					add = false;
				}else{
					operatorIndex = operation.indexOf("+");
					add = true;
				}
				long term1 = Long.parseLong(digits.substring(0, operatorIndex));
				long term2 = Long.parseLong(digits.substring(operatorIndex));
				if(add){
					System.out.println(term1 + term2);
				}else{
					System.out.println(term1 - term2);
				}
			}
			
		}
		fileScanner.close();
	}

}
