import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

There are two details on a M*N checkered field. The detail X covers several (at least one first cell) cells in each line. The detail Y covers several (at least one last cell) cells. Each cell is either fully covered with a detail or not.

For example:

Also, the details may have cavities (or other complex structures). Please see example below (the detail Y is one detail):

The detail Y starts moving left (without any turn) until it bumps into the X detail at least with one cell. Determine by how many cells the detail Y will be moved.

INPUT SAMPLE:

The first argument is a file with different test cases. Each test case contains a matrix the lines of which are separated by comma. (Empty cells are marked as ".")

For example:

1
2
3
4
XX.YY,XXX.Y,X..YY,XX..Y
XXX.YYYY,X...Y..Y,XX..YYYY,X.....YY,XX....YY
XX...YY,X....YY,XX..YYY,X..YYYY
XXYY,X..Y,XX.Y
OUTPUT SAMPLE:

Print out the number of cells the detail Y will be moved.

For example:

1
2
3
4
1
1
2
0
CONSTRAINTS:

The matrices can be of different M*N sizes. (2 <= M <= 10, 2 <= N <= 10)
Number of test cases is 40.*/

public class Details {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
				
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String rows[] = line.split(",");
				
				int minMove = Integer.MAX_VALUE;
				
				for(String row : rows){
					
					int lastX = row.lastIndexOf("X.");
					int firstY = row.indexOf(".Y");
					
					if(lastX == -1){
						minMove = 0;
					}else{
						int distance = firstY - lastX;
						
						if(distance < minMove){
							minMove = distance;
						}
					}
				}
				System.out.println(minMove);
			}
		}
		
		fileScanner.close();

	}
}
