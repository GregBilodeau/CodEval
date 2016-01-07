import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

You have a sting which contains a number represented as English text. Your task is to translate these numbers into their integer representation. The numbers can range from negative 999,999,999 to positive 999,999,999. The following is an exhaustive list of English words that your program must account for:

negative,
zero, one, two, three, four, five, six, seven, eight, nine,
ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen,
twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety,
hundred,
thousand,
million
INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Input example is the following

fifteen
negative six hundred thirty eight
zero
two million one hundred seven
- Negative numbers will be preceded by the word negative. 
- The word "hundred" is not used when "thousand" could be. E.g. 1500 is written "one thousand five hundred", not "fifteen hundred".

OUTPUT SAMPLE:

Print results in the following way.

15
-638
0
2000107*/

public class TextToNumber {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				//String tokens[] = line.split("\\s");
				int total = 0;
				Boolean isNeg = false;
				int millionIndex, thousandIndex = -1;
				if(line.indexOf("negative") > -1){
					isNeg = true;
					line = line.substring(9);
				}
				if((millionIndex = line.indexOf("million")) != -1){
					total += parseMills(line.substring(0, millionIndex - 1));
					line = line.substring(millionIndex + 7);
					line = line.trim();
				}
				if((thousandIndex = line.indexOf("thousand")) != -1){
					total += parseThous(line.substring(0, thousandIndex - 1));
					line = line.substring(thousandIndex + 8);
					line = line.trim();
				}
				total += parseBlock(line);
				if(isNeg){
					total *= -1;
				}
				System.out.println(total);
			}
			
		}
		
		fileScanner.close();

	}
	
	public static int parseMills(String expression){
		return parseBlock(expression) * 1000000;
	}
	
	public static int parseThous(String expression){
		return parseBlock(expression) * 1000;
	}
	
	public static int parseBlock(String expression){
		int returnValue = 0;
		
		if(expression.indexOf("hundred") != -1){
			returnValue += parseHun(expression.substring(0, expression.indexOf("hundred") - 1));
			expression = expression.substring(expression.indexOf("hundred") + 7);
			expression = expression.trim();
		}
		returnValue += parseRest(expression);
		return returnValue;
	}
	
	public static int parseHun(String expression){
		int returnValue = getIntValue(expression);
		returnValue *= 100;
		return returnValue;
	}
	
	public static int parseRest(String expression){
		int returnValue = 0;
		String values[] = expression.split("\\s");
		for(String word : values){			
			returnValue += getIntValue(word);
		}
		
		return returnValue;
	}
	
	public static int getIntValue(String word){
		
		int returnValue = 0;
		
		if(word.equalsIgnoreCase("one")){
			returnValue = 1;
		}
		if(word.equalsIgnoreCase("two")){
			returnValue = 2;
		}
		if(word.equalsIgnoreCase("three")){
			returnValue = 3;
		}
		if(word.equalsIgnoreCase("four")){
			returnValue = 4;
		}
		if(word.equalsIgnoreCase("five")){
			returnValue = 5;
		}
		if(word.equalsIgnoreCase("six")){
			returnValue = 6;
		}
		if(word.equalsIgnoreCase("seven")){
			returnValue = 7;
		}
		if(word.equalsIgnoreCase("eight")){
			returnValue = 8;
		}
		if(word.equalsIgnoreCase("nine")){
			returnValue = 9;
		}
		if(word.equalsIgnoreCase("ten")){
			returnValue = 10;
		}
		if(word.equalsIgnoreCase("eleven")){
			returnValue = 11;
		}
		if(word.equalsIgnoreCase("twelve")){
			returnValue = 12;
		}
		if(word.equalsIgnoreCase("thirteen")){
			returnValue = 13;
		}
		if(word.equalsIgnoreCase("fourteen")){
			returnValue = 14;
		}
		if(word.equalsIgnoreCase("fifteen")){
			returnValue = 15;
		}
		if(word.equalsIgnoreCase("sixteen")){
			returnValue = 16;
		}
		if(word.equalsIgnoreCase("seventeen")){
			returnValue = 17;
		}
		if(word.equalsIgnoreCase("eighteen")){
			returnValue = 18;
		}
		if(word.equalsIgnoreCase("nineteen")){
			returnValue = 19;
		}
		if(word.equalsIgnoreCase("twenty")){
			returnValue = 20;
		}
		if(word.equalsIgnoreCase("thirty")){
			returnValue = 30;
		}
		if(word.equalsIgnoreCase("forty")){
			returnValue = 40;
		}
		if(word.equalsIgnoreCase("fifty")){
			returnValue = 50;
		}
		if(word.equalsIgnoreCase("sixty")){
			returnValue = 60;
		}
		if(word.equalsIgnoreCase("seventy")){
			returnValue = 70;
		}
		if(word.equalsIgnoreCase("eighty")){
			returnValue = 80;
		}
		if(word.equalsIgnoreCase("ninety")){
			returnValue = 90;
		}
		return returnValue;
	}

}
