import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Write a program to print a 2D array (n x m) in spiral order (clockwise)

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. The input file contains several lines. Each line is one test case. Each line contains three items (semicolon delimited). The first is 'n'(rows), the second is 'm'(columns) and the third is a single space separated list of characters/numbers in row major order. E.g.

3;3;1 2 3 4 5 6 7 8 9
OUTPUT SAMPLE:

Print out the matrix in clockwise fashion, one per line, space delimited. E.g.

1 2 3 6 9 8 7 4 5*/

public class SpiralPrinting {
	
	static LinkedList<LinkedList<String>> board = new LinkedList<LinkedList<String>>();
	static int matrixRows;
	static int matrixCols;
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			board.clear();
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(";");
				
				matrixRows = Integer.parseInt(elements[0]);
				matrixCols = Integer.parseInt(elements[1]);
				String matrixContents[] = elements[2].split("\\s");
				
				for(int i = 0; i < matrixRows; i++){
					LinkedList<String> row = new LinkedList<String>();;
					
					for(int j = 1; j < matrixCols + 1; j++){
						row.add(matrixContents[(i * matrixCols) + j - 1]);
					}
					
					board.add(row);
				}
				String outputLine = "";
				while(!board.isEmpty()){
					outputLine += printSpiral();
				}
				System.out.print(outputLine.trim());
			}
			System.out.println();
		}
		fileScanner.close();
	}
	
	public static String printSpiral(){
		String output = "";
		
		if(board.getFirst().size() == 1){
			
			for(int i = 0; i < board.size(); i++){
				output += printRow(i);
			}
			
			board.clear();
			return output;
		}
		
		output += printRow(0);
		
		if(board.size() > 1){
			for(int i = 1; i < board.size(); i++){
				if(board.get(i).size() > 0){
					output += board.get(i).getLast() + " ";
				}
			}
			
			LinkedList<String> lastRow = board.getLast();
			
			for(int i = lastRow.size() - 2; i >= 0; i--){
				output += lastRow.get(i) + " ";
			}
		}
		
		if(board.size() > 2){
			for(int i = board.size() - 2; i > 0; i--){
				if(board.get(i).size() > 0){
					output += board.get(i).getFirst() + " ";
				}
			}
		}
		
		board.removeFirst();
		if(board.size() > 0){
			board.removeLast();
		}
		boolean singleColumn = false;
		if(board.size() > 0){
			for(int i = 0; i < board.size(); i++){
				LinkedList<String> row = board.get(i);
				if(row.size() > 0){
					row.removeLast();
				}
				if(row.size() > 0){
					row.removeFirst();
				}
			}
		}
		return output;
	}
	
	public static String printRow(int row){
		String output = "";
		LinkedList<String> rowVal = board.get(row);
		for(String digit : rowVal){
			output += digit + " ";
		}
		return output;
	}
	
}