import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Credits: Programming Challenges by Steven S. Skiena and Miguel A. Revilla
The problem is as follows: choose a number, reverse its digits and add it to the original. If the sum is not a palindrome (which means, it is not the same number from left to right and right to left), repeat this procedure.

For example:

195 (initial number) + 591 (reverse of initial number) = 786

786 + 687 = 1473

1473 + 3741 = 5214

5214 + 4125 = 9339 (palindrome)
In this particular case the palindrome 9339 appeared after the 4th addition. This method leads to palindromes in a few step for almost all of the integers. But there are interesting exceptions. 196 is the first number for which no palindrome has been found. It is not proven though, that there is no such a palindrome.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file is one test case. Each test case will contain an integer n < 10,000. Assume each test case will always have an answer and that it is computable with less than 100 iterations (additions).

OUTPUT SAMPLE:

For each line of input, generate a line of output which is the number of iterations (additions) to compute the palindrome and the resulting palindrome. (they should be on one line and separated by a single space character).

For example:

4 9339*/

public class ReverseAndAdd {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
				
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int number = Integer.parseInt(line);
				int reversed = reverse(number);
				int sum = number + reversed;
				int iteration = 1;
				while(!isPalindrome(sum) && iteration < 100){
					int newReversed = reverse(sum);
					int newSum = sum + newReversed;
					sum = newSum;
					iteration++;
				}
				System.out.println(iteration + " " + sum);
			}
		}
		
		fileScanner.close();

	}
	
	public static int reverse(int number){
		int multiplier = 1;
		if(number < 0){
			multiplier = -1;
			number = number * -1;
		}
		String strNum = String.valueOf(number);
		String revNum = new StringBuilder(strNum).reverse().toString();
		return Integer.parseInt(revNum) * multiplier;
	}
	
	public static boolean isPalindrome(int number){
		String strNum = String.valueOf(number);
		String revNum = String.valueOf(reverse(number));
		if(strNum.equalsIgnoreCase(revNum)){
			return true;
		}else{
			return false;
		}
	}

}
