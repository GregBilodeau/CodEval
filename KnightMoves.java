import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

In chess, the knight moves to any of the closest squares that are not on the same rank, file, or diagonal. Thus the move is in the “L” form: two squares vertically and one square horizontally, or two squares horizontally and one square vertically:


Your task is to find all possible positions for the next move of the knight on the empty chessboard.

INPUT SAMPLE:

The first argument is a filename that contains positions of the knight on the chessboard in the CN form, where:

C is a letter from “a” to “h” and denotes a column.
N is a number from 1 to 8 and denotes a row.
Each position is indicated in a new line.

For example:



1
2
3
4
5
g2
a1
d6
e5
b1
OUTPUT SAMPLE:

Print to stdout all possible positions for the next move of the knight ordered alphabetically.

For example:

1
2
3
4
5
e1 e3 f4 h4
b3 c2
b5 b7 c4 c8 e4 e8 f5 f7
c4 c6 d3 d7 f3 f7 g4 g6
a3 c3 d2
CONSTRAINTS:

The number of test cases is 40*/

public class KnightMoves {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		Scanner fileScanner = new Scanner(file);
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				
				StringBuilder sb = new StringBuilder();
				
				int column = (int) line.charAt(0) - 97;
				int row = Character.getNumericValue(line.charAt(1)) - 1;
				
				int testCol1 = column - 2;
				int testCol2 = column - 1;
				int testCol3 = column + 1;
				int testCol4 = column + 2;
				
				int testRow1 = row - 1;
				int testRow2 = row - 2;
				int testRow3 = row + 2;
				int testRow4 = row + 1;
				
				if(testCol1 >= 0){
					if(testRow1 >= 0){
						//valid
						sb.append(getPosition(testCol1, testRow1) + " ");
					}
					if(testRow4 <= 7){
						// valid
						sb.append(getPosition(testCol1, testRow4) + " ");
					}
				}
				
				if(testCol2 >= 0){
					if(testRow2 >= 0){
						//valid
						sb.append(getPosition(testCol2, testRow2) + " ");
					}
					if(testRow3 <= 7){
						// valid
						sb.append(getPosition(testCol2, testRow3) + " ");
					}
				}
				
				if(testCol3 <= 7){
					if(testRow2 >= 0){
						//valid
						sb.append(getPosition(testCol3, testRow2) + " ");
					}
					if(testRow3 <= 7){
						// valid
						sb.append(getPosition(testCol3, testRow3) + " ");
					}
				}
				
				if(testCol4 <= 7){
					if(testRow1 >= 0){
						//valid
						sb.append(getPosition(testCol4, testRow1) + " ");
					}
					if(testRow4 <= 7){
						// valid
						sb.append(getPosition(testCol4, testRow4) + " ");
					}
				}
				
				System.out.println(sb.toString().trim());
			}
		}
		fileScanner.close();
	}
	
	public static String getPosition(int col, int row){
		int letterVal = col + 97;
		char letter = (char)letterVal;
		return "" + letter + (row + 1);
	}
}
