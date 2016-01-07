import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

There is a game where each player picks a number from 1 to 9, writes it on a paper and gives to a guide. A player wins if his number is the lowest unique. We may have 10-20 players in our game.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename.

You're a guide and you're given a set of numbers from players for the round of game. E.g. 2 rounds of the game look this way:

3 3 9 1 6 5 8 1 5 3
9 2 9 9 1 8 8 8 2 1 1
OUTPUT SAMPLE:

Print a winner's position or 0 in case there is no winner. In the first line of input sample the lowest unique number is 6. So player 5 wins.

5
0*/

public class LowestUniqueNumber {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String entries[] = line.split("\\s");
				int numbers[] = new int[9];
				for(int i = 0; i < numbers.length; i++){
					numbers[i] = 0;
				}
				for(String entry : entries){
					int number = Integer.parseInt(entry) - 1;
					numbers[number] = numbers[number] + 1;
				}				
				int winningNumber = 0;
				for(int i = 0; i < numbers.length; i++){
					if(numbers[i] == 1){
						winningNumber = i + 1;
						break;
					}
				}
				if(winningNumber > 0){
					for(int i = 0; i <entries.length; i++){
						int number = Integer.parseInt(entries[i]);
						if(number == winningNumber){
							System.out.println(i + 1);
						}
					}
				}else{
					System.out.println("0");
				}
			}
			
		}
		fileScanner.close();
	}
}
