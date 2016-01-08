import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

You are given 3 coins of value 1, 3 and 5. You are also given a total which you have to arrive at. Find the minimum number of coins to arrive at it.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains a positive integer number which represents the total you have to arrive at. E.g.

11
20
OUTPUT SAMPLE:

Print out the minimum number of coins required to arrive at the total. E.g.

3
4*/

public class MinimumCoins {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int value = Integer.parseInt(line);
				int coinCount = 0;
				coinCount = value / 5;
				value = value % 5;
				coinCount = coinCount + (value / 3);
				value = value % 3;
				coinCount += value;
				System.out.println(coinCount);
			}
		}
		
		fileScanner.close();

	}

}
