import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
CHALLENGE DESCRIPTION:

Have you ever tried to win in the 2048 game? In this challenge, your task is to implement part of the logic of this game.

The original 2048 is played on a 4×4 grid, with numbered tiles that slide when a player moves them using the four arrow keys. Tiles slide as far as possible in the chosen direction until they are stopped by either another tile or the edge of the grid. If two tiles of the same number collide while moving, they will merge into a tile with the total value of the two tiles that collided. The resulting tile cannot merge with another tile again in the same move (Description from Wikipedia article).

Picture from the original game (by Gabriele Cirulli)

In this challenge, you have to implement the logic for the sliding tiles in the chosen direction. Unlike the original game, a new tile cannot appear after the move and the grid size may vary from 4 to 10.

INPUT SAMPLE:

The first argument is a path to a file. Each line of the input file contains one test case. Each test case consists of a direction (UP, DOWN, RIGHT, or LEFT), the length of a side in the square grid, and the initial configuration of the grid. All the data elements are separated by a semicolon. The configuration of the grid is a series of lines from top to bottom separated by a vertical bar. 0 indicates a blank tile.

For example:

1
2
RIGHT; 4; 4 0 2 0|0 0 0 8|4 0 2 4|2 4 2 2
UP; 4; 2 0 2 0|0 2 0 4|2 8 0 8|0 8 0 16
OUTPUT SAMPLE:

For each test case, print to stdout the configuration of the grid received after slide of a tile in the chosen direction. Format is the same as in the input file. Lines are written from top to bottom and are separated by a vertical bar. Blank tiles are marked with 0.

For example:

1
2
0 0 4 2|0 0 0 8|0 4 2 4|0 2 4 4
4 2 2 4|0 16 0 8|0 0 0 16|0 0 0 0
CONSTRAINTS:

The grid is square with the length of a side from 4 to 10.
The value of the tiles is equal to the power of number 2 and varies from 21 to 210.
*/

public class TwentyFortyEight {

	public static int[][] charBoard;
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String[] elements = line.split("; ");
				String direction = elements[0];

				int size = Integer.parseInt(elements[1]);
				String[] boardLines = elements[2].split("\\|");
				charBoard = new int[size][size];
				
				for(int i = 0; i < size; i++){
					String[] tempLine = boardLines[i].split("\\s");
					
					int[] tempInts = new int[tempLine.length];
					
					for(int j = 0; j < tempLine.length; j++){
						String numString = tempLine[j];
						int tempInt = Integer.parseInt(numString);
						tempInts[j] = tempInt;
					}
					
					charBoard[i] = tempInts;
				}
				
				int dir = 0;
				
				if(direction.equalsIgnoreCase("LEFT")){
					dir = 1;
				}else if(direction.equalsIgnoreCase("DOWN")){
					dir = 2;
				}else if(direction.equalsIgnoreCase("RIGHT")){
					dir = 3;
				}else if(direction.equalsIgnoreCase("UP")){
					dir = 4;
				}else{
					//
				}
				
				int[][] answer = new int[size][size];
				
				switch (dir){
				case 1:
					for(int i = 0; i < size; i++){
						answer[i] = processArray(charBoard[i], size);
					}
					break;
				case 2:
					for(int i = 0; i < size; i++){
						int[] arrayToProcess = getColumnDown(i, size);
						answer[i] = processArray(arrayToProcess, size);
						answer[i] = reverseRow(answer[i], size);
					}
					answer = rowsToCols(answer, size);
					break;
				case 3:
					for(int i = 0; i < size; i++){
						int[] arrayToProcess = getRowLeft(i, size);
						answer[i] = processArray(arrayToProcess, size);
						answer[i] = reverseRow(answer[i], size);
					}
					break;
				case 4:
					for(int i = 0; i < size; i++){
						int[] arrayToProcess = getColumnUp(i, size);
						answer[i] = processArray(arrayToProcess, size);
					}
					answer = rowsToCols(answer, size);
					break;
				}
				System.out.println(outputBoard(answer));
				
			}
		}
		fileScanner.close();
	}
	
	// process the array and return the new array
		public static int[] processArray(int[] inputArray, int boardSize){
			
			int[] input = inputArray.clone();
			int[] output = new int[boardSize];
			
			for(int i = 0; i < boardSize; i ++){
				output[i] = 0;
			}
			
			for(int i = 0; i < boardSize; i++){
				int num = input[i];
				output[i] = num;
				for(int j = 1; j < boardSize - i; j++){
					int compare = input[i + j];
					
					// case 1: 0 < num = compare > 0
					if(num == compare && num > 0){
						output[i] = num + compare;
						input[i + j] = 0;
						break;
					}
					
					// case 2: num = 0, compare = 0
					if(num == 0 && compare == 0){
						continue;
					}
					
					// case 3: num = 0, compare > 0
					if(num == 0 && compare > 0){
						input[i] = compare;
						input[i + j] = 0;
						output[i] = compare;
						// re-run on this index
						i = i - 1;
						break;
					}
					
					// case 4: num > 0, compare = 0
					if(num > 0 && compare == 0){
						continue;
					}
										
					// case 5: 0 < num <> compare > 0
					if(num > 0 && compare > 0 && num != compare){
						output[i] = input[i];
						break;
					}
					
					
				}
				
			}
			
			return output;
		}
	
	// get array in uniform direction
	public static int[] getColumnUp(int colNum, int boardSize){
		int[] result = new int[boardSize];
		
		for(int i = 0; i < boardSize; i++){
			result[i] = charBoard[i][colNum];
		}
		
		return result;
	}
	
	public static int[] getColumnDown(int colNum, int boardSize){
		int[] result = new int[boardSize];
		
		for(int i = boardSize - 1; i >= 0; i--){
			result[boardSize - (i + 1)] = charBoard[i][colNum];
		}
		
		return result;
	}
	
	public static int[] getRowRight(int rowNum){
		return charBoard[rowNum];
	}
	
	public static int[] getRowLeft(int rowNum, int boardSize){
		int[] result = new int[boardSize];
		for(int i = boardSize - 1; i >= 0; i--){
			result[boardSize - (i + 1) ] = charBoard[rowNum][i];
		}
		return result;
	}
	
	// reverse a row
	public static int[] reverseRow(int[] row, int boardSize){
		int[] output = new int[boardSize];
		
		for(int i = 0; i < boardSize; i++){
			output[i] = row[(boardSize - 1) - i];
		}
		
		return output;
	}
	
	// turn rows into columns
	public static int[][] rowsToCols(int[][] board, int boardSize){
		int[][] output = new int[boardSize][boardSize];
		
		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				output[j][i] = board[i][j];
			}
		}
		
		return output;
	}
	
	// turns 2d array into output string
	public static String outputBoard(int[][] answer){
		String output = "";
		for(int[] line : answer){
			for(int number : line){
				output += number + " ";
			}
			output = output.trim() + "|";
		}
		return output.trim().substring(0, output.length() - 1);
	}
}