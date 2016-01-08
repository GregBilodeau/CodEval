import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

There is a board (matrix). Every cell of the board contains one integer, which is 0 initially. 

The next operations can be applied to the Query Board: 
SetRow i x: it means that all values in the cells on row "i" have been changed to value "x" after this operation. 
SetCol j x: it means that all values in the cells on column "j" have been changed to value "x" after this operation. 
QueryRow i: it means that you should output the sum of values on row "i". 
QueryCol j: it means that you should output the sum of values on column "j". 

The board's dimensions are 256x256 
"i" and "j" are integers from 0 to 255 
"x" is an integer from 0 to 31 
INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains an operation of a query. E.g.

SetCol 32 20
SetRow 15 7
SetRow 16 31
QueryCol 32
SetCol 2 14
QueryRow 10
SetCol 14 0
QueryRow 15
SetRow 10 1
QueryCol 2
OUTPUT SAMPLE:

For each query, output the answer of the query. E.g.

5118
34
1792
3571*/

public class QueryBoard {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		int board[][] = new int[256][256];
		for(int i = 0; i <= 255; i++){
			for(int j = 0; j <= 255; j++){
				board[i][j] = 0;
			}
		}
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split("\\s");
				String command = elements[0];
				int target = Integer.parseInt(elements[1]);
				int value = 0;
				if(command.equalsIgnoreCase("setcol")){
					value = Integer.parseInt(elements[2]);
					for(int i = 0; i <= 255; i++){
						board[i][target] = value;
					}
				}
				if(command.equalsIgnoreCase("setrow")){
					value = Integer.parseInt(elements[2]);
					for(int i = 0; i <= 255; i++){
						board[target][i] = value;
					}
				}
				if(command.equalsIgnoreCase("querycol")){
					int total = 0;
					for(int i = 0; i <= 255; i++){
						total += board[i][target];
					}
					System.out.println(total);
				}
				if(command.equalsIgnoreCase("queryrow")){
					int total = 0;
					for(int i = 0; i <= 255; i++){
						total += board[target][i];
					}
					System.out.println(total);
				}
			}
		}
		
		fileScanner.close();

	}

}
