import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

To check whether a bank card number is valid or it is it just a set of random numbers, Luhn formula is used.

The formula verifies a number against its included check digit, which is usually appended to a partial account number to generate the full account number. This account number must pass the following test:

From the rightmost digit, which is the check digit, moving left, double the value of every second digit; if the product of this doubling operation is greater than 9 (for example, 7×2=14), then sum the digits of the products (for example, 12:1+2=3, 14:1+4=5).
Take the sum of all the digits.
If the total modulo 10 is equal to 0 (if the total ends in zero) then, according to the Luhn formula, the number is valid; otherwise, it is not valid.
Examples of formula calculation and result checking:

Checking number 1556 9144 6285 339

1   5   5   6   9   1   4   4   6   2   8   5   3   3   9
1   10  5   12  9   2   4   8   6   4   8   10  3   6   9
1 + 1 + 5 + 3 + 9 + 2 + 4 + 8 + 6 + 4 + 8 + 1 + 3 + 6 + 9 = 70

70 mod 10 = 0, card number is valid

Checking number 6363 1811 2857 7650

6   3   6   3   1   8   1   1   2   8   5   7   7   6   5   0
12  3   12  3   2   8   2   1   4   8   10  7   14  6   10  0
3 + 3 + 3 + 3 + 2 + 8 + 2 + 1 + 4 + 8 + 1 + 7 + 5 + 6 + 1 + 0 = 57

57 mod 10 = 7 <> 0, card number is not valid

INPUT SAMPLE:

The first argument is a file that contains bank card numbers, one per line. For better readability, numbers are split into groups of 4 digits separated by spaces.

For example:

1
2
3
4
5
6011 5940 0319 9511
5537 0213 6797 6815
5574 8363 8022 9735
3044 8507 9391 30
6370 1675 9034 6211 774
OUTPUT SAMPLE:

Print to stdout the results of bank card numbers validation, one per line. If the number is correct – print 1, otherwise – print 0.

For example:

1
2
3
4
5
0
1
0
0
1
CONSTRAINTS:

Bank card numbers can be from 12 to 19 digits length.
Numbers are split into groups of 4 digits separated by spaces, spaces should be ignored.
Number of test cases is 100.*/

public class CardNumberValidation {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				line = line.replaceAll("\\s", "");
				char digits[] = line.toCharArray();
				int nums[] = new int[digits.length];
				
				for(int i = 0; i < digits.length; i++){
					nums[i] = (int)digits[i] - 48;
				}
				
				for(int i = nums.length - 2; i >= 0; i -= 2){
					int digitValue = nums[i];
					int newDigit = (digitValue * 2);
					if(newDigit < 10){
						nums[i] = newDigit;
					}else{
						int ones = newDigit % 10;
						int tens = newDigit / 10;
						nums[i] = tens + ones;
					}
				}
				
				int total = 0;
				for(int number : nums){
					total += number;
				}
				
				if(total % 10 != 0){
					System.out.print("0");
				}else{
					System.out.print("1");
				}
			}
			System.out.println();
		}
		scanner.close();
	}

}
