import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

You are given a 2D N×N matrix. Each element of the matrix is a letter: from ‘a’ to ‘z’. Your task is to rotate the matrix 90° clockwise:

a b c        g d a
d e f  =>    h e b
g h i        i f c
INPUT SAMPLE:

The first argument is a file that contains 2D N×N matrices, presented in a serialized form (starting from the upper-left element), one matrix per line. The elements of a matrix are separated by spaces.

For example:

1
2
3
a b c d
a b c d e f g h i j k l m n o p
a b c d e f g h i
OUTPUT SAMPLE:

Print to stdout matrices rotated 90° clockwise in a serialized form (same as in the input sample).

For example:

1
2
3
c a d b
m i e a n j f b o k g c p l h d
g d a h e b i f c
CONSTRAINTS:

The N size of the matrix can be from 1 to 10
The number of test cases is 100*/

public class MatrixRotation {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split("\\s");
				StringBuilder sb = new StringBuilder();
				int matrixDimension = (int)Math.sqrt(elements.length);
				for(int j = 0; j < matrixDimension; j++){
					for(int i = matrixDimension - 1; i >= 0; i --){
						sb.append(elements[(i * matrixDimension) + j]);
						sb.append(" ");
					}
				}
				System.out.println(sb.toString().trim());
			}
			
			
		}
		fileScanner.close();
	}

}
