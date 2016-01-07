import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordToDigit {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String numbers[] = line.split(";");
				for(String digit : numbers){
					if(digit.equalsIgnoreCase("ZERO")){
						System.out.print("0");
					}
					if(digit.equalsIgnoreCase("ONE")){
						System.out.print("1");
					}
					if(digit.equalsIgnoreCase("TWO")){
						System.out.print("2");
					}
					if(digit.equalsIgnoreCase("THREE")){
						System.out.print("3");
					}
					if(digit.equalsIgnoreCase("FOUR")){
						System.out.print("4");
					}
					if(digit.equalsIgnoreCase("FIVE")){
						System.out.print("5");
					}
					if(digit.equalsIgnoreCase("SIX")){
						System.out.print("6");
					}
					if(digit.equalsIgnoreCase("SEVEN")){
						System.out.print("7");
					}
					if(digit.equalsIgnoreCase("EIGHT")){
						System.out.print("8");
					}
					if(digit.equalsIgnoreCase("NINE")){
						System.out.print("9");
					}
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}
