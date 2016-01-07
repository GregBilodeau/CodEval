import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

The goal of this challenge is to design a cash register program. You will be given two float numbers. The first is the purchase price (PP) of the item. The second is the cash (CH) given by the customer. Your register currently has the following bills/coins within it:

'PENNY': .01,
'NICKEL': .05,
'DIME': .10,
'QUARTER': .25,
'HALF DOLLAR': .50,
'ONE': 1.00,
'TWO': 2.00,
'FIVE': 5.00,
'TEN': 10.00,
'TWENTY': 20.00,
'FIFTY': 50.00,
'ONE HUNDRED': 100.00
The aim of the program is to calculate the change that has to be returned to the customer.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. The input file contains several lines. Each line is one test case. Each line contains two numbers which are separated by a semicolon. The first is the Purchase price (PP) and the second is the cash(CH) given by the customer. eg.

1
2
3
4
15.94;16.00
17;16
35;35
45;50
OUTPUT SAMPLE:

For each set of input produce a single line of output which is the change to be returned to the customer. In case the CH < PP, print out ERROR. If CH == PP, print out ZERO. For all other cases print the amount that needs to be returned, in terms of the currency values provided. The output should be sorted in highest-to-lowest order (DIME,NICKEL,PENNY). eg.

1
2
3
4
NICKEL,PENNY
ERROR
ZERO
FIVE
*/

public class CashRegister{

	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(";");
				float price = Float.parseFloat(elements[0]);
				float cash = Float.parseFloat(elements[1]);
				
				double change = cash - price;
				
				if(change < 0){
					System.out.println("ERROR");
				}else if(change == 0){
					System.out.println("ZERO");
				}else{
					System.out.println(findChange(change));
				}
			}
		}
		fileScanner.close();
	}
	
	private static String findChange(double change){
		
		String textChange = "";
		
		DecimalFormat df = new DecimalFormat("########.##");
		int intChange = (int)(Double.valueOf(df.format(change)) * 100);
		
		while(intChange >= 0.01){
			if(intChange >= 10000){
				textChange += "ONE HUNDRED,";
				intChange -= 10000;
			} else if(intChange >= 5000){
				textChange += "FIFTY,";
				intChange -= 5000;
			} else if(intChange >= 2000){
				textChange += "TWENTY,";
				intChange -= 2000;
			} else if(intChange >= 1000){
				textChange += "TEN,";
				intChange -= 1000;
			} else if(intChange >= 500){
				textChange += "FIVE,";
				intChange -= 500;
			} else if(intChange >= 200){
				textChange += "TWO,";
				intChange -= 200;
			} else if(intChange >= 100){
				textChange += "ONE,";
				intChange -= 100;
			} else if(intChange >= 50){
				textChange += "HALF DOLLAR,";
				intChange -= 50;
			} else if(intChange >= 25){
				textChange += "QUARTER,";
				intChange -= 25;
			} else if(intChange >= 10){
				textChange += "DIME,";
				intChange -= 10;
			} else if(intChange >= 5){
				textChange += "NICKEL,";
				intChange -= 5;
			} else if(intChange >= 1){
				textChange += "PENNY,";
				intChange -= 1;
			}
		}
		return textChange.substring(0, textChange.length() - 1);
	}	
}