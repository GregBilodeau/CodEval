import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*CHALLENGE DESCRIPTION:

Credits: This challenge has been authored by Terence Rudkin 

You are given a positive integer number. This represents the sales made that day in your department store. The payables department however, needs this printed out in english. NOTE: The correct spelling of 40 is Forty. (NOT Fourty)

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename.The input file contains several lines. Each line is one test case. Each line contains a positive integer. E.g.

3
10
21
466
1234
OUTPUT SAMPLE:

For each set of input produce a single line of output which is the english textual representation of that integer. The output should be unspaced and in Camelcase. Always assume plural quantities. You can also assume that the numbers are < 1000000000 (1 billion). In case of ambiguities e.g. 2200 could be TwoThousandTwoHundredDollars or TwentyTwoHundredDollars, always choose the representation with the larger base i.e. TwoThousandTwoHundredDollars. For the examples shown above, the answer would be:

ThreeDollars
TenDollars
TwentyOneDollars
FourHundredSixtySixDollars
OneThousandTwoHundredThirtyFourDollars*/

public class TextDollar {
	
	static String intStr[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	static String teensStr[] = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	static String decStr[] = {"Zero","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	static String hundred = "Hundred";
	static String thousand = "Thousand";
	static String million = "Million";
	static String dollars = "Dollars";
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				line = line.trim();
				int numberInput = (int) Double.parseDouble(line);
				
				int thousandMultiplier = 0;
				String output = "";
				
				if(numberInput > 0){
					while(numberInput > 0){
						int threeDigits = numberInput % 1000;
						output = parseTriple(threeDigits, thousandMultiplier) + output;
						numberInput = numberInput / 1000;
						thousandMultiplier++;
					}
					System.out.println(output + dollars);
				}else{
					System.out.println("Zero" + dollars);
				}
			}
		}
		fileScanner.close();
	}
	
	public static String parseTriple(int value, int multiplier){
		String result = "";
		if(value > 99){
			int hundreds = value / 100;
			result += intStr[hundreds] + hundred;
		}
		int tens;
		int ones;
		ones = value % 10;
		tens = (value / 10) % 10;
		if(tens < 1){
			result += intStr[ones];
		}else if(tens == 1){
			result += teensStr[ones];
		}else{
			if(ones >= 1){
				result += decStr[tens] + intStr[ones];
			}else{
				result += decStr[tens];
			}
		}
		
		if(!result.equalsIgnoreCase("")){
			switch(multiplier){
				case 0:
					break;
				case 1:
					result += thousand;
					break;
				case 2:
					result += million;
					break;
			}
		}
		return result;
	}
}
